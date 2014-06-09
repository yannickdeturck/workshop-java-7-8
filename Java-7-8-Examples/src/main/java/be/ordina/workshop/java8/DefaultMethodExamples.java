package be.ordina.workshop.java8;

public class DefaultMethodExamples { // aka Extension Methods

    public static void main(String[] args) {
        Printer simplePrinter = new Printer(){};
        Printer capsPrinter = new CapsPrinter();

        simplePrinter.print("hello world");
        capsPrinter.print("hello world");
    }

    interface Printer {
        default void print(String s) {
            System.out.println(s);
        }
    }

    static class CapsPrinter implements Printer {
        @Override
        public void print(String s) {
            Printer.super.print(s.toUpperCase());
        }
    }

    interface Copier {
        default void print(String s) { System.out.println("Out of paper..."); }
    }

//    static class MultiFunctionalPrinter implements Printer, Copier {
//    }

}