package name.max_ferrara.CSVMain;

import java.io.*;

public class MainCSV {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\MAKCOH\\IdeaProjects\\AcademItOOP\\CSV\\input.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
        PrintWriter printWriter = new PrintWriter("C:\\Users\\MAKCOH\\IdeaProjects\\AcademItOOP\\CSV\\output.txt");

        int num = bufferedReader.read();

        boolean isTableDetailEnded = false;
        boolean isTableRowEnded = false;
        boolean isQuotesOpened = false;
        int quotesCount = 0;

        printWriter.println("<table>");
        printWriter.println("<tr>");
        printWriter.print("<td>");

        while (num != -1) {
            char symbol = (char) num;

            if (symbol == '"') {
                ++quotesCount;

                if (isTableDetailEnded && quotesCount == 1) {
                    printWriter.print("<td>");

                    isTableDetailEnded = false;
                    isQuotesOpened = true;
                } else if (quotesCount == 1) {
                    isQuotesOpened = true;
                } else if (quotesCount == 3) {
                    quotesCount = 1;
                    printWriter.print(symbol);
                }
            } else if (symbol == ',') {
                if (!isQuotesOpened) {
                    printWriter.println("</td>");

                    isTableDetailEnded = true;
                } else if (quotesCount == 2) {
                    printWriter.println("</td>");

                    quotesCount = 0;
                    isQuotesOpened = false;
                    isTableDetailEnded = true;
                } else {
                    printWriter.print(symbol);
                }
            } else if (symbol == '\r') {
                if (quotesCount == 2) {
                    printWriter.println("</td>");
                    printWriter.print("</tr>");
                    printWriter.print('\r');

                    quotesCount = 0;
                    isQuotesOpened = false;
                    isTableRowEnded = true;
                } else if (isQuotesOpened) {
                    printWriter.print("<br>");
                } else if (isTableDetailEnded) {
                    printWriter.print("</tr>");
                    printWriter.print('\r');

                    isTableRowEnded = true;
                    isTableDetailEnded = false;
                } else {
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
        printWriter.println("</tr>");
        printWriter.print("</table>");

        printWriter.close();
    }
}
