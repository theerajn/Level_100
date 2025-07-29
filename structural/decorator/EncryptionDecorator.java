public class EncryptionDecorator extends DataSourceDecorator {
    private static final int SHIFT = 3;

    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void write(String data) {
        super.write(encrypt(data));
    }

    @Override
    public String read() {
        return decrypt(super.read());
    }

    private String encrypt(String data) {
        StringBuilder result = new StringBuilder();
        for (char c : data.toCharArray()) {
            result.append((char) (c + SHIFT));
        }
        return result.toString();
    }

    private String decrypt(String data) {
        StringBuilder result = new StringBuilder();
        for (char c : data.toCharArray()) {
            result.append((char) (c - SHIFT));
        }
        return result.toString();
    }
}
