// Concrete Component (base ETL data input)
public class BasicETLComponent implements ETLComponent {
    private String data;

    public BasicETLComponent(String data) {
        this.data = data;
    }

    @Override
    public String process() {
        // Just returns raw input data without modifications
        return data;
    }
}
