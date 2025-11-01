package functional;

import java.util.function.Function;

public class CompositionMain1 {

    public static void main(String[] args) {
        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> add = x -> x + 1;

        // 함수 합성
        // 1. compose()를 사용한 새로운 함수 생성
        Function<Integer, Integer> newFunc1 = square.compose(add);  // square(add(n))
        System.out.println("newFunc1 결과 = " + newFunc1.apply(2));   // square(add(2)) -> square(3) -> 9

        // 2. andThen()을 사용한 새로운 함수 생성
        // 먼저 square 적용 후 add 적용하는 새로운 함수 newFunc2 생성
        Function<Integer, Integer> newFunc2 = square.andThen(add);  // add(square(n)
        System.out.println("newFunc2 결과 = " + newFunc2.apply(2));   // add(suqare(2)) -> add(4) -> 5
    }
}
