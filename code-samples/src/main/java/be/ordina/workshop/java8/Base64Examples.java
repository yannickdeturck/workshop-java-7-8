package be.ordina.workshop.java8;

import javax.xml.bind.DatatypeConverter;
import java.util.Base64;
import java.util.UUID;

/**
 * @author Yannick De Turck
 */
public class Base64Examples {
    public static void main(String[] args) throws Exception {
        // Java 1.6 API from JAXB
        String encodedString = DatatypeConverter.printBase64Binary("secret".getBytes("UTF-8"));
        System.out.println("Java 1.6+ Encoded String: " + encodedString);

        // Java 8
        encodedString = new String(Base64.getEncoder().encode("secret".getBytes("UTF-8")), "UTF-8");
        System.out.println("Java 8 Encoded String: " + encodedString);
        String decodedString = new String(Base64.getDecoder().decode(encodedString.getBytes()), "UTF-8");
        System.out.println("Decoded String: " + decodedString);

        System.out.println("---");

        // Basic vs URL
        String basicEncoded = Base64.getEncoder().encodeToString("watch?v=oavMtUWDBTM".getBytes("utf-8"));
        System.out.println("Using Basic: " + basicEncoded);

        String urlEncoded = Base64.getUrlEncoder().encodeToString("watch?v=oavMtUWDBTM".getBytes("utf-8"));
        System.out.println("Using URL: " + urlEncoded); // Note the slash is replaced

        System.out.println("---");

        // MIME encoding
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < 10; ++t) {
            sb.append(UUID.randomUUID().toString());
        }
        byte[] bytes = sb.toString().getBytes("utf-8");
        String mineEncoded = Base64.getMimeEncoder().encodeToString(bytes);
        System.out.println(mineEncoded); // Notice output no longer than 76 chars and ends with carriage return followed by a line feed
    }
}
