package name.max_ferrara.CSVMain;

import java.io.*;
import java.util.Scanner;

public class MainCSV {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        try (Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\MAKCOH\\IdeaProjects\\AcademItOOP\\CSV\\CSV_file.txt"));
             PrintWriter writer = new PrintWriter("C:\\Users\\MAKCOH\\IdeaProjects\\AcademItOOP\\CSV\\", "UTF-8")) {

            while (scanner.hasNextLine()) {
                String lowerCaseString = scanner.nextLine();
                writer.println(lowerCaseString);
            }
        }
    }
}
