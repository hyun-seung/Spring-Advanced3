package methodref.start;

import methodref.Person;

import java.util.function.BiFunction;

public class MethodRefEx6 {

    public static void main(String[] args) {
        Person person = new Person("Kim");

        BiFunction<Person, Integer, String> fun1 = (p, num) -> p.introduceWithNumber(num);
        System.out.println("person.introduceWithNumber = " + fun1.apply(person, 1));

        BiFunction<Person, Integer, String> fun2 = Person::introduceWithNumber;
        System.out.println("person.introduceWithNumber = " + fun2.apply(person, 1));
    }
}
