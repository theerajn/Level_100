public class StreamChange {
    private String tableName;
    private String operation; // INSERT, UPDATE, DELETE
    private String changedData;

    public StreamChange(String tableName, String operation, String changedData) {
        this.tableName = tableName;
        this.operation = operation;
        this.changedData = changedData;
    }

    public String getTableName() {
        return tableName;
    }

    public String getOperation() {
        return operation;
    }

    public String getChangedData() {
        return changedData;
    }

    @Override
    public String toString() {
        return "Table: " + tableName + " | Operation: " + operation + " | Data: " + changedData;
    }
}
