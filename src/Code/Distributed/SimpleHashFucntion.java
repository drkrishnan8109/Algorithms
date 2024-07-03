package Code.Distributed;

import java.nio.charset.StandardCharsets;

// Note: Any arbitrary length string can be converted to fixed length hash using hash function.
// Then use modulo operator to fit into the given space n. Used in sharding
// PRefer UTF-8 over ASCII since it can represent all characters in Unicode encoding.
// ASCII doesnt support internationalization and other language

public class SimpleHashFucntion {

    static final int n = 10;

    public int hashUTF8(String key) {
        int sum = 0;
        byte[] bytearray = key.getBytes(StandardCharsets.UTF_8);
        for(byte b : bytearray)
            sum += (b & 0xFF);  // byte is an 8 bit unsigned integer - means -128 to 127. But for UTF-8,
                                // we need to make it unsigned integer, so between 0 to 255.
                                // 0xFF represents 256 and as hexadecimal 11111111. So we do a bitwise AND here
        int index = sum % n;
        return index;
    }

    public int hashASCII(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i); // Directly using ASCII values
        }
        return sum % 5;
    }
}
