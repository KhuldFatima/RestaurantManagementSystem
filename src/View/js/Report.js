// View/js/Report.js
document.addEventListener("DOMContentLoaded", () => {
    if (document.getElementById("reports-dashboard")) {
        loadDailyOperationalMetrics();
    }
});
function loadDailyOperationalMetrics() {
    fetch("http://localhost:8080/api/report")
    .then(res => res.json())
    .then(data => {
        if (data.status === "success") {
            const m = data.data;
            document.getElementById("report-gross").innerText
                = "PKR " + m.grossRevenue.toLocaleString();
            document.getElementById("report-net").innerText
                = "PKR " + m.netRevenue.toLocaleString();
            document.getElementById("report-discounts").innerText
                = "PKR " + m.discountsGiven.toLocaleString();
            document.getElementById("report-tax").innerText
                = "PKR " + m.taxCollected.toLocaleString();
        }
    })
    .catch(err => console.error("Report fetch failed:", err));
}