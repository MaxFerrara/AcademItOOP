package name.max_ferrara.CSVMain;

import java.io.*;

public class MainCSV {
    public static void convertCSVTableToHTML(String inputFile, String outputFile, char delimiter) {
        try {
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            PrintWriter printWriter = new PrintWriter(outputFile);

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
                } else if (symbol == delimiter) {
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
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        convertCSVTableToHTML("C:\\Users\\MAKCOH\\IdeaProjects\\AcademItOOP\\CSV\\input.txt", "C:\\Users\\MAKCOH\\IdeaProjects\\AcademItOOP\\CSV\\output.txt", ',');
    }
}
