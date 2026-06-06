async function handleLogin() {
    const username = document.getElementById('loginUsername').value.trim();
    const password = document.getElementById('loginPassword').value.trim();
    const errorDiv = document.getElementById('loginError');

    if (!username || !password) {
        errorDiv.textContent = 'Please enter username and password.';
        errorDiv.classList.remove('hidden');
        return;
    }

    const res = await apiFetch('/auth/login', 'POST', { username, password });

    if (res.success) {
        currentUser = res.data;
        document.getElementById('sidebarUsername').textContent = currentUser.username;
        document.getElementById('loginPage').classList.remove('active');
        document.getElementById('loginPage').classList.add('hidden');
        document.getElementById('mainApp').classList.remove('hidden');
        document.getElementById('mainApp').classList.add('active');
        loadOrderDropdowns();
        loadOrders();
    } else {
        errorDiv.textContent = res.message;
        errorDiv.classList.remove('hidden');
    }
}

function handleLogout() {
    currentUser = null;
    currentOrderItems = [];
    currentOrderTotal = 0;
    document.getElementById('mainApp').classList.add('hidden');
    document.getElementById('loginPage').classList.remove('hidden');
    document.getElementById('loginPage').classList.add('active');
    document.getElementById('loginUsername').value = '';
    document.getElementById('loginPassword').value = '';
}