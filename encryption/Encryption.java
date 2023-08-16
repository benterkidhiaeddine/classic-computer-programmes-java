package encryption;

import java.util.Random;

public class Encryption {
    Random random = new Random();

    // Method for generating a random byte array which is our secret dummy data from
    // the length of our message string
    public byte[] dummyData(int length) {
        String string = "Hello";
        byte[] dummy = new byte[length];
        random.nextBytes(dummy);
        return dummy;

    }

    public KeyPair encrypt(String message) {

        byte[] messageBytes = message.getBytes();
        byte[] dummyData = dummyData(messageBytes.length);
        byte[] encryptedMessage = new byte[messageBytes.length];

        for (int i = 0; i < encryptedMessage.length; i++) {
            // XOR
            encryptedMessage[i] = (byte) (messageBytes[i] ^ dummyData[i]);
        }

        return new KeyPair(dummyData, encryptedMessage);

    }
}