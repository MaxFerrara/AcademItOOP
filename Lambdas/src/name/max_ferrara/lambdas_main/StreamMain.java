package name.max_ferrara.lambdas_main;

import java.util.Scanner;
import java.util.stream.DoubleStream;

public class StreamMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Поток корней чисел, укажите сколько нужно вычислить: ");
        int sqrtCount = scanner.nextInt();

        DoubleStream squaresStream = DoubleStream.iterate(1, x -> x + 1).map(Math::sqrt);
        squaresStream.limit(sqrtCount).forEach(System.out::println);
    }
}
