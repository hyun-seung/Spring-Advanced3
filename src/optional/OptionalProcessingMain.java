package optional;

import java.util.Optional;

public class OptionalProcessingMain {

    public static void main(String[] args) {
        Optional<String> optValue = Optional.of("Hello");
        Optional<String> optEmpty = Optional.empty();

        System.out.println("=== 1. ifPresent() ===");
        optValue.ifPresent(v -> System.out.println("optValue 값: " + v));
        optEmpty.ifPresent(v -> System.out.println("optEmpty 값: " + v));

        System.out.println("=== 2. ifPresentOfElse() ===");
        optValue.ifPresentOrElse(
                v -> System.out.println("optValue 값: " + v),
                () -> System.out.println("optValue 비어있음")
        );
        optEmpty.ifPresentOrElse(
                v -> System.out.println("optEmpty 값: " + v),
                () -> System.out.println("optEmpty 비어있음")
        );

        System.out.println("=== 3. map() ===");
        Optional<Integer> lengthOpt1 = optValue.map(String::length);
        System.out.println("lengthOpt1 = " + lengthOpt1);
        Optional<Integer> lengthOpt2 = optEmpty.map(String::length);
        System.out.println("lengthOpt2 = " + lengthOpt2);

        System.out.println("=== 4. flatMap() ===");
        System.out.println("[map]");
        // Optional[Hello] -> Optional[Optional[Hello]]
        Optional<Optional<String>> nestedOpt = optValue.map(s -> Optional.of(s));
        System.out.println("optValue = " + optValue);
        System.out.println("nestedOpt = " + nestedOpt);

        System.out.println("[flatMap]");
        // Optional[Hello] -> Optional[Hello]
        Optional<String> flattedOpt = optValue.flatMap(s -> Optional.of(s));
        System.out.println("flattedOpt = " + flattedOpt);

        System.out.println("=== 5. filter() ===");
        Optional<String> filtered1 = optValue.filter(s -> s.startsWith("H"));
        System.out.println("filtered1 = " + filtered1);
        Optional<String> filtered2 = optValue.filter(s -> s.startsWith("X"));
        System.out.println("filtered2 = " + filtered2);

        System.out.println("=== 6. stream() ===");
        optValue.stream()
                .forEach(s -> System.out.println("optValue.stream() -> " + s));
        optEmpty.stream()
                .forEach(s -> System.out.println("optEmpty.stream() -> " + s));
    }
}
