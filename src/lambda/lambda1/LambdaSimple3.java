package lambda.lambda1;

import lambda.MyFunction;

public class LambdaSimple3 {

    public static void main(String[] args) {
        MyFunction myFunction = (int a, int b) -> a + b;

        // 타입을 통해 타입 추론 가능, 람다는 타입 생략 가능
        MyFunction function2 = (a, b) -> a + b;
        int result = function2.apply(1, 2);
        System.out.println("function2 = " + result);
    }
}
