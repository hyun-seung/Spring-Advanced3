package lambda.lambda4;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionMain {

    public static void main(String[] args) {
        // 익명 클래스
        Function<String, Integer> function1 = s -> s.length();
        System.out.println("function1.apply(\"hello\") = " + function1.apply("hello"));

        Consumer consumer1 = s -> System.out.println(s);
        consumer1.accept("hello consumer");

        Supplier supplier1 = () -> new Random().nextInt(10);
        System.out.println("suplier1.get() = " + supplier1.get());

        Runnable runnable1 = () -> System.out.println("Hello Runnable");
        runnable1.run();
    }
}
