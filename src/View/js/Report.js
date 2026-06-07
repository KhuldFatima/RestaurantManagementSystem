// View/js/Report.js
document.addEventListener("DOMContentLoaded", () => {
    if (document.getElementById("reports-dashboard")) {
        loadDailyOperationalMetrics();
    }
});

function loadDailyOperationalMetrics() {
    console.log("Querying ReportController to compile today's performance metrics...");

    // Mock data structures mirroring the map returned by ReportService
    const mockReportData = {
        grossRevenue: 48250.00,
        discountsGiven: 3450.00,
        taxCollected: 7168.00,
        netRevenue: 51968.00
    };

    // Safely inject performance metrics maps into our summary HTML dashboard rows
    const grossEl = document.getElementById("report-gross");
    const discEl = document.getElementById("report-discounts");
    const taxEl = document.getElementById("report-tax");
    const netEl = document.getElementById("report-net");

    if (grossEl) grossEl.innerText = `PKR ${mockReportData.grossRevenue.toLocaleString()}`;
    if (discEl) discEl.innerText = `PKR ${mockReportData.discountsGiven.toLocaleString()}`;
    if (taxEl) taxEl.innerText = `PKR ${mockReportData.taxCollected.toLocaleString()}`;
    if (netEl) netEl.innerText = `PKR ${mockReportData.netRevenue.toLocaleString()}`;
}