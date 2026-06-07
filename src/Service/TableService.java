package Service;

import Model.Table;
import Repository.TableRepository;

public class TableService {
    private final TableRepository tableRepository = new TableRepository();

    public boolean changeStatus(int tableNumber, String newStatus) {
        if (tableNumber <= 0 || newStatus == null || newStatus.trim().isEmpty()) {
            return false;
        }

        String formattedStatus = newStatus.toUpperCase().trim();

        // Ensure status update values match authorized state criteria safely
        // Uses Table model constants to keep status values consistent across the system
        if (formattedStatus.equals(Table.STATUS_AVAILABLE) ||
                formattedStatus.equals(Table.STATUS_OCCUPIED)  ||
                formattedStatus.equals(Table.STATUS_RESERVED)) {
            return tableRepository.updateTableStatus(tableNumber, formattedStatus);
        }

        return false;
    }
}