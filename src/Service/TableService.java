package Service;

import controller.TableController;
import model.Table;
import util.Constants;
import util.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class TableService {
    private TableController tableController = new TableController();

    public List<Table> getAllTables() {
        return tableController.getAllTables();
    }

    public List<Table> getAvailableTables() {
        return tableController.getAllTables()
                .stream()
                .filter(t -> t.getStatus().equals(Constants.TABLE_AVAILABLE))
                .collect(Collectors.toList());
    }

    public List<Table> getOccupiedTables() {
        return tableController.getAllTables()
                .stream()
                .filter(t -> t.getStatus().equals(Constants.TABLE_OCCUPIED))
                .collect(Collectors.toList());
    }

    // Returns error message or null if success
    public String markOccupied(int tableId) {
        if (tableId <= 0) return "Invalid table selected.";
        boolean ok = tableController.updateTableStatus(tableId, Constants.TABLE_OCCUPIED);
        return ok ? null : Constants.MSG_DB_ERROR;
    }

    public String markAvailable(int tableId) {
        if (tableId <= 0) return "Invalid table selected.";
        boolean ok = tableController.updateTableStatus(tableId, Constants.TABLE_AVAILABLE);
        return ok ? null : Constants.MSG_DB_ERROR;
    }

    public String markReserved(int tableId) {
        if (tableId <= 0) return "Invalid table selected.";
        boolean ok = tableController.updateTableStatus(tableId, Constants.TABLE_RESERVED);
        return ok ? null : Constants.MSG_DB_ERROR;
    }

    // Returns error message or null if success
    public String addTable(String tableNumberText, String capacityText) {
        if (!Validator.isValidTableNumber(tableNumberText)) return "Invalid table number.";
        if (!Validator.isValidCapacity(capacityText))       return "Capacity must be between 1 and 20.";

        int number   = Integer.parseInt(tableNumberText.trim());
        int capacity = Integer.parseInt(capacityText.trim());
        boolean ok   = tableController.addTable(number, capacity);
        return ok ? null : "Table number already exists or DB error.";
    }
}