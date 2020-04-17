package name.max_ferrara.lambdas_main;

import java.util.Scanner;
import java.util.stream.DoubleStream;

public class StreamMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введи число:");
        int sqrtCount = scanner.nextInt();

        DoubleStream numbersStream = DoubleStream.iterate(1, x -> x + 1).map(Math::sqrt);
        numbersStream.limit(sqrtCount).forEach(System.out::println);
    }
}
