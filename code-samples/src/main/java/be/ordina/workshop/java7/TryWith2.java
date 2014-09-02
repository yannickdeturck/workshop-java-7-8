package be.ordina.workshop.java7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Yannick De Turck
 */
public class TryWith2 {

    public static void main(String[] args) {
        File file = new File("leesmij.txt");
        File file2 = new File("schrijfmij.txt");
        
        // Java 6
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(file);
            // Read from file
            try {
                out = new FileOutputStream(file2);
                // Write to file
            } catch (IOException e) {
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        } catch (IOException e) {
        } finally {
            try {
                in.close();
            } catch (IOException e) {
            }
        }

        // Java 7
        try (InputStream in2 = new FileInputStream(file);
                OutputStream out2 = new FileOutputStream(file2)) {
            // Read and write
        } catch (IOException ex) {
        } // Resources get automatically closed when leaving the code block
    }
}
