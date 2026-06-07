
const menuItems = [
    { id: 1, name: "Chicken Makhni Handi (Half)",    category: "Karahi",  price: 1450 },
    { id: 2, name: "Mutton Peshawari Karahi (Full)", category: "Karahi",  price: 3200 },
    { id: 3, name: "Beef Seekh Kebab (4 Pcs)",       category: "BBQ",     price: 850  },
    { id: 4, name: "Chicken Tikka Piece (Leg)",      category: "BBQ",     price: 420  },
    { id: 5, name: "Mutton Dum Biryani",             category: "Rice",    price: 780  },
    { id: 6, name: "Garlic Naan / Roghni Naan",      category: "Tandoor", price: 90   },
    { id: 7, name: "Mint Raita & Fresh Salad",       category: "Sides",   price: 180  },
    { id: 8, name: "Pakola / Soft Drink Can",        category: "Drinks",  price: 120  }
];

let cart = [];

document.addEventListener("DOMContentLoaded", () => {
    const dateInput = document.getElementById("order-date");
    const today = new Date().toISOString().split('T')[0];
    dateInput.value = today;

    renderMenu();
});

function renderMenu() {
    const container = document.getElementById("menu-container");
    container.innerHTML = "";

    menuItems.forEach(item => {
        const card = document.createElement("div");
        card.className = "menu-card";
        card.innerHTML = `
            <h4>${item.name}</h4>
            <p style="color: #666; font-size: 0.85rem; margin:0;">${item.category}</p>
            <p class="price">PKR ${item.price}</p>
            <button class="btn" onclick="addToCart(${item.id})">Add to Order</button>
        `;
        container.appendChild(card);
    });
}

function addToCart(id) {
    const item = menuItems.find(p => p.id === id);
    const existing = cart.find(c => c.id === id);

    if (existing) {
        existing.quantity += 1;
    } else {
        cart.push({ ...item, quantity: 1 });
    }
    renderCart();
}

function removeFromCart(id) {
    cart = cart.filter(item => item.id !== id);
    renderCart();
}

function renderCart() {
    const container = document.getElementById("cart-items");

    if (cart.length === 0) {
        container.innerHTML = `<p style="color: #888; text-align: center;">No items selected yet.</p>`;
        recalculateBill();
        return;
    }

    container.innerHTML = "";
    cart.forEach(item => {
        const row = document.createElement("div");
        row.className = "cart-item";
        row.innerHTML = `
            <div class="cart-item-info">
                <strong>${item.name}</strong><br>
                <small>PKR ${item.price} x ${item.quantity}</small>
            </div>
            <span>PKR ${item.price * item.quantity}</span>
            <button class="btn-remove" onclick="removeFromCart(${item.id})">Remove</button>
        `;
        container.appendChild(row);
    });

    recalculateBill();
}

function recalculateBill() {
    let subtotal = cart.reduce((sum, item) => sum + (item.price * item.quantity), 0);

    const paymentMethod  = document.getElementById("payment-method").value;
    const selectedDateVal = document.getElementById("order-date").value;

    let discountPercent = 0.0;

    // Check Card Discount
    if (paymentMethod === "MEEZAN" || paymentMethod === "ASKARI") {
        discountPercent += 0.10;
    }

    // Check First Wednesday
    if (selectedDateVal) {
        const dateObj  = new Date(selectedDateVal);
        const dayOfWeek  = dateObj.getDay();  // 0 = Sunday, 3 = Wednesday
        const dayOfMonth = dateObj.getDate();

        if (dayOfWeek === 3 && dayOfMonth <= 7) {
            discountPercent += 0.05;
        }
    }

    let discountAmount    = subtotal * discountPercent;
    let discountedSubtotal = subtotal - discountAmount;
    let taxAmount          = discountedSubtotal * 0.16; // 16% Provincial Revenue Tax
    let totalPayable       = discountedSubtotal + taxAmount;

    document.getElementById("bill-subtotal").innerText = `PKR ${subtotal.toFixed(2)}`;
    document.getElementById("bill-discount").innerText = `${(discountPercent * 100).toFixed(0)}% (-PKR ${discountAmount.toFixed(2)})`;
    document.getElementById("bill-tax").innerText      = `PKR ${taxAmount.toFixed(2)}`;
    document.getElementById("bill-total").innerText    = `PKR ${totalPayable.toFixed(2)}`;
}