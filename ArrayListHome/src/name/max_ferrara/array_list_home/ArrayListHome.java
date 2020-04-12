package name.max_ferrara.array_list_home;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayListHome {
    public static void deleteOddNumbers(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; --i) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
    }

    public static List<Integer> getListWithoutDuplicates(List<Integer> list) {
        List<Integer> listWithoutDuplicates = new ArrayList<>();

        for (Integer number : list) {
            if (!listWithoutDuplicates.contains(number)) {
                listWithoutDuplicates.add(number);
            }
        }

        return listWithoutDuplicates;
    }


    public static List<String> getStringsListFromFile(String filePath) {
        List<String> outputList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            while (scanner.hasNextLine()) {
                outputList.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("not found:" + filePath);
        }

        return outputList;
    }

    public static void main(String[] args) {
        List<String> inputsList = getStringsListFromFile("./ArrayListHome/input.txt");
        System.out.println(inputsList);

        List<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 3, 3, 3, 4, 5, 5, 6, 10, -5));
        System.out.println(numbersList);
        deleteOddNumbers(numbersList);

        System.out.println(numbersList);
        System.out.println(getListWithoutDuplicates(numbersList));
    }
}
