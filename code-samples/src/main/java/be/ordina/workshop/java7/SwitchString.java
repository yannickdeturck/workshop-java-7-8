package be.ordina.workshop.java7;

import java.util.Scanner;

public class SwitchString {
    public static final String MORNING = "morning";
    public static final String NOON = "noon";
    public static final String EVENING = "evening";
    public static void main(String[] args) {
        System.out.print("What part of the day is it? ");
        Scanner scanner = new Scanner(System.in);
        String dayPart = scanner.nextLine();

        // Java 6
        if (MORNING.equals(dayPart)) {
            System.out.println("Good morning!");
        } else if (NOON.equals(dayPart)) {
            System.out.println("Good afternoon!");
        } else if (EVENING.equals(dayPart)) {
            System.out.println("Good evening");
        } else {
            System.out.println("Good day!");
        }

        // Java 7
        switch (dayPart) {
            case MORNING:
                System.out.println("Good morning!");
                break;
            case NOON:
                System.out.println("Good afternoon!");
                break;
            case EVENING:
                System.out.println("Good evening");
                break;
            default:
                System.out.println("Good day!");
                break;
        }
    }
}
