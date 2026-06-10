
const BACKEND_URL = "http://localhost:8080/api/order";


function sendCartToCheckout() {

    if (typeof cart === "undefined" || cart.length === 0) {
        showStatus("error", "Your order cart is empty. Add at least one item.");
        return;
    }

    const tableInput = document.getElementById("table-number");
    const tableNumber = tableInput ? parseInt(tableInput.value) : 0;
    if (!tableNumber || tableNumber < 1) {
        showStatus("error", "Please enter a valid table number before placing the order.");
        return;
    }

    const selectedPayment = document.getElementById("payment-method").value;

    const baseSubtotal = cart.reduce(
        (sum, item) => sum + (item.price * item.quantity), 0
    );

    if (baseSubtotal <= 0) {
        showStatus("error", "Subtotal is invalid. Please check your cart.");
        return;
    }

    const orderRequestPayload = {
        cartItems: cart.map(item => ({
            menuItemId: item.id,
            itemName:   item.name,
            quantity:   item.quantity,
            unitPrice:  item.price
        })),
        subtotal:      baseSubtotal,
        paymentMethod: selectedPayment
    };

    console.log("Dispatching order to backend:", orderRequestPayload);

    const placeBtn = document.getElementById("place-order-btn");
    if (placeBtn) {
        placeBtn.disabled = true;
        placeBtn.textContent = "Processing...";
    }

    fetch(BACKEND_URL, {
        method:  "POST",
        headers: { "Content-Type": "application/json" },
        body:    JSON.stringify(orderRequestPayload)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Server returned status " + response.status);
        }
        return response.json();
    })
    .then(data => {
        if (data.status === "success") {
            showStatus("success",
                "✅ Order saved! Table " + tableNumber +
                " | PKR " + baseSubtotal.toLocaleString() +
                " | " + selectedPayment
            );

            cart = [];
            if (typeof renderCart === "function") renderCart();

        } else {
            showStatus("error", "Order rejected: " + (data.message || "Unknown error."));
        }
    })
    .catch(error => {
        console.error("Backend connection failed:", error);
        showStatus("error",
            "Could not reach the backend server. " +
            "Make sure Tomcat is running on port 8080. (" + error.message + ")"
        );
    })
    .finally(() => {
        if (placeBtn) {
            placeBtn.disabled = false;
            placeBtn.textContent = "Place Order";
        }
    });
}


function showStatus(type, message) {
    let statusEl = document.getElementById("order-status-msg");

    if (!statusEl) {
        statusEl = document.createElement("div");
        statusEl.id = "order-status-msg";
        statusEl.style.cssText = `
            margin-top: 12px;
            padding: 10px 14px;
            border-radius: 6px;
            font-size: 0.875rem;
            font-weight: 500;
        `;
        const btn = document.getElementById("place-order-btn");
        if (btn) btn.insertAdjacentElement("afterend", statusEl);
    }

    if (type === "success") {
        statusEl.style.background = "#d4edda";
        statusEl.style.color      = "#155724";
        statusEl.style.border     = "1px solid #c3e6cb";
    } else {
        statusEl.style.background = "#ffeaea";
        statusEl.style.color      = "#c0392b";
        statusEl.style.border     = "1px solid #f5c6cb";
    }

    statusEl.textContent = message;

    if (type === "success") {
        setTimeout(() => { if (statusEl) statusEl.textContent = ""; }, 4000);
    }
}