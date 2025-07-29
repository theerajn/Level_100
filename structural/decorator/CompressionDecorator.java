import java.util.zip.*;
import java.io.*;
import java.util.Base64;


public class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void write(String data) {
        super.write(compress(data));
    }

    @Override
    public String read() {
        return decompress(super.read());
    }

    private String compress(String data) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(bos);
            gzip.write(data.getBytes());
            gzip.close();
            return Base64.getEncoder().encodeToString(bos.toByteArray());
        } catch (IOException e) {
            return data;
        }
    }

    private String decompress(String data) {
        try {
            byte[] compressed = Base64.getDecoder().decode(data);
            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
            BufferedReader reader = new BufferedReader(new InputStreamReader(gis));
            return reader.readLine();
        } catch (IOException e) {
            return data;
        }
    }
}
