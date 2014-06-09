package be.ordina.workshop.java8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExamples {
    public static void main(String[] args) {
        printList(Arrays.asList("a", "b", "c"));

        registerActionListener(new JButton("My Button"));
    }

    public static void printList(List<String> aList) {
        // Java 7
        for (String s : aList) {
            System.out.println(s);
        }

        // Java 8
        aList.forEach((String s) -> System.out.println(s));
        // or shorter
        aList.forEach(s -> System.out.println(s));
    }

    public static void registerActionListener(JButton aButton) {
        // Java 7
        aButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked me!");
            }
        });

        // Java 8
        aButton.addActionListener(e -> System.out.println("You clicked me!"));
    }

    class Book {
        private String author;
        private String title;

        public Book(String aAuthor, String aTitle) {
            this.author = aAuthor;
            this.title = aTitle;
        }

        public String getAuthor() { return author; }
        public String getTitle() { return title; }
    }

    public static void sortList(List<Book> aList) {
        // Java 7
        Collections.sort(aList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        // Java 8
        Collections.sort(aList, (b1, b2) -> {
            int result = 0;
            result = b1.getTitle().compareTo(b2.getTitle());
            return result;
        });
        // or shorter
        Collections.sort(aList, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
    }
}
