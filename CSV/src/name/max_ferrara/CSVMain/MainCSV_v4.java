package name.max_ferrara.CSVMain;

import java.io.*;

public class MainCSV_v4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\MAKCOH\\IdeaProjects\\AcademItOOP\\CSV\\CSV_test_simple.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis, "windows-1251"));
        PrintWriter printWriter = new PrintWriter("C:\\Users\\MAKCOH\\IdeaProjects\\AcademItOOP\\CSV\\CSV.txt");

        int num;

        StringBuilder stringBuilder = new StringBuilder();

        boolean isTableDetailEnded = false;
        boolean isTableRowEnded = false;

        printWriter.print("<tr>");

        while ((num = bufferedReader.read()) != -1) {
            char symbol = (char) num;

            if (symbol == '\r' && !isTableRowEnded) {
                printWriter.print("</tr>");

                isTableRowEnded = true;
            } else if (isTableRowEnded) {
                printWriter.write(symbol);
                printWriter.print("<tr>");

                isTableRowEnded = false;
            } else {
                printWriter.write(symbol);
            }

        }

        printWriter.print("</tr>");

        printWriter.close();
    }
}

