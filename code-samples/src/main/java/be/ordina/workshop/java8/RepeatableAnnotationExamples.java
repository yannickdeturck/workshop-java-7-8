package be.ordina.workshop.java8;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Yannick De Turck
 */
public class RepeatableAnnotationExamples {

    @Retention(RetentionPolicy.RUNTIME)
    @interface Cars {
        Car[] value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Cars.class)
    @interface Car {
        String value();
    }

    @Car("Opel Corsa")
    class Person {}


    // Container annotation
    @Cars({@Car("Porsche Boxter"), @Car("Porsche 911")})
    class Family2 {}

    // Repeatable annotations
    @Car("Volkswagen Sharan")
    @Car("Mini Cooper")
    class Family1 {}

    public static void main(String[] args) {
        Car car = Person.class.getAnnotation(Car.class);
        System.out.println(car);

        Cars cars = Family2.class.getAnnotation(Cars.class);
        System.out.println(cars.value().length);

        Car[] cars2 = Family1.class.getAnnotationsByType(Car.class);
        System.out.println(cars2.length);
    }
}
