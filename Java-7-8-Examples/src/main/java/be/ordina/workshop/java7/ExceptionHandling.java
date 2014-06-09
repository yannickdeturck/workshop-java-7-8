package be.ordina.workshop.java7;

import java.util.Random;

public class ExceptionHandling {
    public static void main(String[] args) throws NoSuchFieldException {
        // Java 6
        try {
            foo();
        } catch (ClassNotFoundException ex) {
            // Handle Exception
        } catch (NoSuchMethodException ex) {
            // Handle Exception
        } catch (NoSuchFieldException ex) {
            // Handle Exception
        }

        // Java 7
        try {
            foo();
        } catch (ClassNotFoundException | NoSuchMethodException | NoSuchFieldException ex) {
            // Handle Exception
        }

        // Improved checking for rethrown exceptions
        // Prior to Java 7, the compiler would force us to make our main-method throw ReflectiveOperationException,
        // in Java 7 however the compiler knows that despite the fact that an ReflectiveOperationException can be catched and rethrown
        // the only possible Exception inheriting of ReflectiveOperationException will be NoSuchFieldException
        try {
            throw new NoSuchFieldException();
        } catch (ReflectiveOperationException ex) { // No need to include in method signature
            System.out.println("Throwing Exception...");
            throw ex;
        }
    }

    public static void foo() throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        // Throw random Exception
        Random random = new Random();
        int i = random.nextInt(2 + 1);
        switch (i) {
            case 0:
                throw new ClassNotFoundException();
            case 1:
                throw new NoSuchMethodException();
            case 2:
                throw new NoSuchFieldException();
        }
    }
}
