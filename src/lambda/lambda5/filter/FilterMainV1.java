package lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterMainV1 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = filterEvenNumbers(numbers);
        System.out.println("evenNumbers = " + evenNumbers);

        List<Integer> oddNumbers = filterOddNumbers(numbers);
        System.out.println("oddNumbers = " + oddNumbers);

        List<Integer> evenNumbers2 = filter(numbers, i -> i % 2 == 0);
        System.out.println("evenNumbers2 = " + evenNumbers2);

        List<Integer> oddNumbers2 = filter(numbers, i -> i % 2 == 1);
        System.out.println("oddNumbers2 = " + oddNumbers2);

    }

    private static List<Integer> filter(List<Integer> numbers, Predicate<Integer> predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                filtered.add(number);
            }
        }
        return filtered;
    }

    private static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer number : numbers) {
            boolean testResult = number % 2 == 0;
            if (testResult) {
                filtered.add(number);
            }
        }
        return filtered;
    }

    private static List<Integer> filterOddNumbers(List<Integer> numbers) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer number : numbers) {
            boolean testResult = number % 2 == 1;
            if (testResult) {
                filtered.add(number);
            }
        }
        return filtered;
    }
}
