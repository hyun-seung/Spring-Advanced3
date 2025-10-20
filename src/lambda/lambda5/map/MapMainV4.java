package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapMainV4 {

    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");

        List<Integer> numbers = StringToIntegerMapper.map(list, s1 -> Integer.valueOf(s1));
        System.out.println("numbers = " + numbers);

        List<Integer> lengths = StringToIntegerMapper.map(list, s -> s.length());
        System.out.println("lengths = " + lengths);
    }
}
