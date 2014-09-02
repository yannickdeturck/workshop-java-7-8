package be.ordina.workshop.java7;

import java.util.Random;

/**
 * @author Yannick De Turck
 */
public class MultipleExceptionHandling {

    public static void main(String[] args) throws NoSuchFieldException {

        // Java 6
        try {
            foo();
        } catch (ClassNotFoundException ex) {
            // Handle Exception properly
        } catch (NoSuchMethodException ex) {
            // Handle Exception properly
        } catch (NoSuchFieldException ex) {
            // Handle Exception properly
        }

        // Java 7
        try {
            foo();
        } catch (ClassNotFoundException | NoSuchMethodException | NoSuchFieldException ex) {
            // Handle Exception properly
        }

        // Improved checking for rethrown exceptions
        // Prior to Java 7, the compiler would force us to make our main-method throw ReflectiveOperationException,
        // in Java 7 however the compiler knows that despite the fact that an ReflectiveOperationException can be catched and rethrown
        // the only possible inheritant of ReflectiveOperationException will be NoSuchFieldException
        try {
            throw new NoSuchFieldException();
        } catch (final ReflectiveOperationException ex) { // Note the final next to the Exception!
            System.out.println("Rethrowing Exception...");
            throw ex;
        }
    }

    public static void foo() throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        //Throw random Exception
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
