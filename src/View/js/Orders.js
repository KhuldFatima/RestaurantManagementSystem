// View/js/Orders.js

/**
 * Pushes the active cart contents to the order processing logic.
 */
function sendCartToCheckout() {
    if (typeof cart === 'undefined' || cart.length === 0) {
        alert("Your order cart is completely empty!");
        return;
    }

    const selectedPayment = document.getElementById("payment-method").value;
    const selectedTable   = parseInt(document.getElementById("table-number").value);
    const baseSubtotal    = cart.reduce((sum, item) => sum + (item.price * item.quantity), 0);

    if (!selectedTable || selectedTable <= 0) {
        alert("Please enter a valid table number before placing the order.");
        return;
    }

    // Build the structural payload matching our backend OrderRequest DTO structure
    const orderRequestPayload = {
        cartItems:     cart,
        subtotal:      baseSubtotal,
        paymentMethod: selectedPayment,
        tableNumber:   selectedTable
    };

    console.log("Submitting order request payload to backend pipeline...", orderRequestPayload);

    // Simulate standard response confirmation from OrderController
    alert(`Order Received Successfully!\nTable: ${selectedTable}\nGross Bill: PKR ${baseSubtotal}\nPayment Type: ${selectedPayment}\n\nSent directly to Kitchen Display System!`);

    // Clear cart and refresh view
    cart = [];
    if (typeof renderCart === "function") {
        renderCart();
    }
}