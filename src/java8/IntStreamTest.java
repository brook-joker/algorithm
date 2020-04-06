package java8;

import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String[] args) {
        IntStream.range(1,4).forEach(System.out::println);
    }
}
