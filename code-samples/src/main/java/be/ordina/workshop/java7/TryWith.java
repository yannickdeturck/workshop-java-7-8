package be.ordina.workshop.java7;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Yannick De Turck
 */
public class TryWith {

    public TryWith() throws IOException {
        // Java 6
        FileInputStream in = null;
        try {
            in = new FileInputStream("/Users/yannickdt/Desktop/interessant/test.txt");
            System.out.println(in.read());
        } finally {
            if (in != null) {
                in.close();
            }
        }

        // Java 7
        try (FileInputStream in2 = new FileInputStream("/Users/yannickdt/Desktop/interessant/test.txt")) {
            System.out.println(in2.read());
        } // Resources are automatically closed when leaving the code block
        
        try(Deur deur = new Deur()){
            deur.openDeur();
        }
    }

    public static void main(String[] args) throws IOException {
        new TryWith();
    }

    /**
     * Custom class implementing the AutoClosable interface so it can be used in a try-with-resources statement
     */
    public class Deur implements AutoCloseable {

        @Override
        public void close() throws IOException {
            System.out.println("Deur toe");
        }

        public void openDeur() {
            System.out.println("Deur is open");
        }
    }
}
