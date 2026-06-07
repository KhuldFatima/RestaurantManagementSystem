// View/js/Table.js
const restaurantTables = [
    { tableNumber: 1, capacity: 4, status: "AVAILABLE" },
    { tableNumber: 2, capacity: 2, status: "OCCUPIED" },
    { tableNumber: 3, capacity: 6, status: "RESERVED" },
    { tableNumber: 4, capacity: 4, status: "AVAILABLE" }
];

document.addEventListener("DOMContentLoaded", () => {
    if (document.getElementById("table-grid-container")) {
        renderFloorMap();
    }
});

function renderFloorMap() {
    const gridContainer = document.getElementById("table-grid-container");
    gridContainer.innerHTML = "";

    restaurantTables.forEach(table => {
        const tableBox = document.createElement("div");
        tableBox.className = `table-box status-${table.status.toLowerCase()}`;
        tableBox.style.border = "2px solid #ccc";
        tableBox.style.padding = "15px";
        tableBox.style.margin = "10px";
        tableBox.style.display = "inline-block";
        tableBox.style.borderRadius = "8px";
        tableBox.style.textAlign = "center";

        tableBox.innerHTML = `
            <h3>Table ${table.tableNumber}</h3>
            <p>Seating Capacity: ${table.capacity}</p>
            <strong style="color: ${table.status === 'AVAILABLE' ? 'green' : 'red'}">${table.status}</strong>
            <br><br>
            <button onclick="toggleSeatingState(${table.tableNumber})">Toggle Status</button>
        `;
        gridContainer.appendChild(tableBox);
    });
}

function toggleSeatingState(tableNum) {
    const targetTable = restaurantTables.find(t => t.tableNumber === tableNum);
    if (!targetTable) return;

    // Cycle through states
    if (targetTable.status === "AVAILABLE") {
        targetTable.status = "OCCUPIED";
    } else if (targetTable.status === "OCCUPIED") {
        targetTable.status = "RESERVED";
    } else {
        targetTable.status = "AVAILABLE";
    }

    console.log(`Table ${tableNum} updated via TableController to: ${targetTable.status}`);
    renderFloorMap(); // Refresh interface display changes
}