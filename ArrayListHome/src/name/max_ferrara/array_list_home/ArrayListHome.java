package name.max_ferrara.array_list_home;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayListHome {
    public static void deleteOddNumbers(List<Integer> list) {
        list.removeIf(element -> element % 2 == 0);
    }

    public static List<Integer> getListWithoutDuplicates(List<Integer> list) {
        List<Integer> listWithoutDuplicates = new ArrayList<>();

        for (int i = 0; i < list.size(); ++i) {
            boolean isHaveDuplicate = false;

            for (int j = i + 1; j < list.size(); ++j) {
                if (list.get(j).equals(list.get(i))) {
                    isHaveDuplicate = true;

                    break;
                }
            }

            if (!isHaveDuplicate) {
                listWithoutDuplicates.add(list.get(i));
            }
        }

        return listWithoutDuplicates;
    }


    public static List<String> getStringsReadFileList(String filePlace) {
        List<String> outputList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream(filePlace))) {
            while (scanner.hasNextLine()) {
                outputList.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("not found:" + filePlace);
        }

        return outputList;
    }

    public static void main(String[] args) {
        List<String> inputsList = getStringsReadFileList("./ArrayListHome/input.txt");
        System.out.println(inputsList);

        List<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 3, 3, 3, 4, 5, 5, 6, 10, -5));
        System.out.println(numbersList);
        deleteOddNumbers(numbersList);

        System.out.println(numbersList);
        System.out.println(getListWithoutDuplicates(numbersList));
    }
}
