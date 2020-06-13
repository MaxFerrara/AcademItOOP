package name.max_ferrara.CSVMain;

import java.io.*;

public class MainCSV_v1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\MAKCOH\\IdeaProjects\\AcademItOOP\\CSV\\QuotesTest.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis, "windows-1251"));
        PrintWriter printWriter = new PrintWriter("C:\\Users\\MAKCOH\\IdeaProjects\\AcademItOOP\\CSV\\CSV.txt");

        int num = bufferedReader.read();

        boolean isTableDetailEnded = false;
        boolean isTableRowEnded = false;
        boolean isQuotesOpened = false;
        //boolean isBrAdded = false;
        int quotesCount = 0;

        printWriter.println("<tr>");
        printWriter.print("<td>");

        while (num != -1) {
            char symbol = (char) num;

            if (symbol == '"') {
                quotesCount++;

                if (quotesCount == 1) {
                    isQuotesOpened = true;
                } else if (quotesCount == 2) {
                    quotesCount = 0;
                    isQuotesOpened = false;
                }
            } else if (symbol == ',') {
                if (!isQuotesOpened) {
                    printWriter.println("</td>");

                    isTableDetailEnded = true;
                } else {
                    printWriter.print(symbol);
                }
            } else if (symbol == '\r') {
                if (isQuotesOpened) {
                    printWriter.print("<br>");
                }

                if (!isQuotesOpened) {
                    printWriter.println("</td>");
                    printWriter.print("</tr>");
                    printWriter.print('\r');

                    isTableRowEnded = true;
                }
            } else if (isTableRowEnded) {
                printWriter.write(symbol);
                printWriter.print("<tr>");
                printWriter.print('\r');
                printWriter.print("<td>");

                isTableRowEnded = false;
            } else if (isTableDetailEnded) {
                printWriter.print("<td>");
                printWriter.write(symbol);

                isTableDetailEnded = false;
            } else {
                printWriter.print(symbol);
            }

            num = bufferedReader.read();
        }

        printWriter.println("</td>");
        printWriter.print("</tr>");

        printWriter.close();
    }
}
