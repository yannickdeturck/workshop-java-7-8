package be.ordina.workshop.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Yannick De Turck
 */
public class MethodConstructorReferenceExamples {

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

    public static void main(String[] args) {
        Converter<String, Integer> integerConverter = s -> Integer.parseInt(s);
        Integer integer = integerConverter.convert("125");
        System.out.println(integer);

        // can also be written using a static method reference
        Converter<String, Integer> integerConverterV2 = Integer::valueOf;
        integer = integerConverterV2.convert("76");
        System.out.println(integer);

        // but this also applies to objects
        Capitalizer capitalizer = new Capitalizer();
        Converter<String, String> capitalizerConverter = capitalizer::capitalize;
        System.out.println(capitalizerConverter.convert("hello"));

        // and constructors
        BookFactory bookFactory = Book::new;
        Book b = bookFactory.create("Yannick", "Yannick's book");

        System.out.println("---");

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> filteredList = filter(NumberInspector::isEven, list);
        for (Integer i : filteredList) {
            System.out.println(i);
        }
    }

    static class Capitalizer {
        String capitalize(String s) {
            return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
        }
    }


    static class Book {
        String author;
        String title;

        Book() {}

        Book(String aAuthor, String aTitle) {
            this.author = aAuthor;
            this.title = aTitle;
        }

        public String getAuthor() { return author; }
        public String getTitle() { return title; }
    }

    @FunctionalInterface
    interface BookFactory {
        Book create(String aAuthor, String aTitle);
    }


    static class NumberInspector {
        public static boolean isEven(Integer aNumber) {
            return aNumber % 2 == 0;
        }
    }

    static List<Integer> filter(Predicate<Integer> aPredicate, List<Integer> aList) {
        List<Integer> filteredList = new ArrayList<>();
        for (Integer i : aList) {
            if(aPredicate.test(i)) {
                filteredList.add(i);
            }
        }
        return filteredList;
    }


}
