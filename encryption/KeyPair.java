package encryption;

public class KeyPair {
    // Secret Key
    private byte[] key1;
    // Product Key
    private byte[] key2;

    public KeyPair(byte[] key1, byte[] key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    public String getEncryptedStringMessage() {
        return key2.toString();
    }

    public String getOriginalMessage() {

        byte[] originalMessage = new byte[key2.length];
        for (int i = 0; i < key1.length; i++) {
            originalMessage[i] = (byte) (key1[i] ^ key2[i]);
        }
        return originalMessage.toString();
    }
}