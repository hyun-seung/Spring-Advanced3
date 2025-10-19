package lambda.lambda4;

import java.util.Random;
import java.util.function.*;

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

        Predicate<Integer> predicate = i -> i % 2 == 0;
        System.out.println(predicate.test(10));

        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5));

        BiFunction<Integer, Integer, Integer> addition1 = (a, b) -> a + b;
        BinaryOperator<Integer> addition2 = (a, b) -> a + b;
        System.out.println(addition1.apply(1,2));
        System.out.println(addition2.apply(1,2));

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(1, 2));

        BiConsumer<String, Integer> repeat = (c, n) -> {
            for (int i = 0; i < n; i++) {
                System.out.print(c);
            }
            System.out.println();
        };
        repeat.accept("*", 5);

        BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
        System.out.println(isGreater.test(10, 5));
    }
}
