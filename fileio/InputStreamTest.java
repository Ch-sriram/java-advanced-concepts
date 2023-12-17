package fileio;

import java.io.IOException;
import java.io.InputStream;

/**
 * <h4><u>Code Output</u></h4>
 * <p>
 * <code>
 * This
 * is
 * some
 * text
 * java.io.BufferedInputStream@5e2de80c
 * Exception occurred while reading the stream.java.io.IOException: Stream closed
 * java.io.IOException: Stream closed
 * 	at java.io.BufferedInputStream.getBufIfOpen(BufferedInputStream.java:170)
 * 	at java.io.BufferedInputStream.fill(BufferedInputStream.java:214)
 * 	at java.io.BufferedInputStream.read(BufferedInputStream.java:265)
 * 	at fileio.InputStreamTest.readAndCloseStream(InputStreamTest.java:21)
 * 	at fileio.InputStreamTest.main(InputStreamTest.java:31)
 * </code>
 * </p>
 */
public class InputStreamTest {
    private static void readAndCloseStream (InputStream iStream) {
        try (InputStream inputStream = iStream) {
            int i;
            while ((i = inputStream.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred while reading the stream." + e);
        }

        System.out.println(iStream);

        try {
            iStream.read();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception occurred while reading the stream." + e);
        }

    }

    public static void main(String[] args) {
        InputStream inputStream = InputStreamTest.class.getResourceAsStream("test.txt");
        readAndCloseStream(inputStream);
    }
}
