// View/js/Auth.js
document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.getElementById("login-form");
    if (loginForm) {
        loginForm.addEventListener("submit", handleLoginSubmission);
    }
});

function handleLoginSubmission(event) {
    event.preventDefault();

    const usernameInput = document.getElementById("username").value.trim();
    const passwordInput = document.getElementById("password").value.trim();

    if (!usernameInput || !passwordInput) {
        alert("Please fill in both your username and password details.");
        return;
    }

    // Creating mock request body to send to our AuthController mapping pipeline
    const loginPayload = {
        username: usernameInput,
        password: passwordInput
    };

    console.log("Sending authorization payload to backend...", loginPayload);

    // Simulate backend response verification
    if (loginPayload.username === "admin" && loginPayload.password === "admin123") {
        sessionStorage.setItem("userSession", JSON.stringify({
            name: "Zauq Manager",
            role: "ADMIN",
            token: "SESSION_TOKEN_XYZ_2026"
        }));
        alert("Login Successful! Redirecting to Management Dashboard...");
        window.location.href = "Index.html";
    } else {
        alert("Access Denied: Invalid username or password combination.");
    }
}

function logOutSession() {
    sessionStorage.removeItem("userSession");
    window.location.href = "login.html";
}