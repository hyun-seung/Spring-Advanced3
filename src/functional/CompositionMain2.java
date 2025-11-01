package functional;

import java.util.function.Function;

public class CompositionMain2 {

    public static void main(String[] args) {
        Function<String, Integer> parseInt = Integer::parseInt;

        Function<Integer, Integer> square = x -> x * x;

        Function<Integer, String> toString = x -> "결과: " + x;

        Function<String, String> finalFunc = parseInt.andThen(square).andThen(toString);
        System.out.println("finalFunc 결과 = " + finalFunc.apply("10"));

        Function<String, Integer> stringToSquareFunc = parseInt.andThen(square);
        Integer result = stringToSquareFunc.apply("5");
        System.out.println("result = " + result);
    }
}
