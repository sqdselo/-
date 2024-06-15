import java.util.Base64;

public class SimpleObfuscation {
    public String encode(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }
    public String decode(String encodedData) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedData);
        return new String(decodedBytes);
    }
}
