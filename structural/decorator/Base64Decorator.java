import java.util.Base64;

public class Base64Decorator extends DataSourceDecorator {

    public Base64Decorator(DataSource source) {
        super(source);
    }

    @Override
    public void write(String data) {
        String encoded = Base64.getEncoder().encodeToString(data.getBytes());
        super.write(encoded);
    }

    @Override
    public String read() {
        byte[] decoded = Base64.getDecoder().decode(super.read());
        return new String(decoded);
    }
}
