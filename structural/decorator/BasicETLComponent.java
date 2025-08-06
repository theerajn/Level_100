public class BasicETLComponent implements ETLComponent {
    private String data;

    public BasicETLComponent(String data) {
        this.data = data;
    }

    @Override
    public String process() {
        return data;
    }
}
