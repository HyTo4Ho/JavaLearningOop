package ru.academits.java.suslov.csv_parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CsvParser {
    private String[][] rows;

    public CsvParser() {
        rows = new String[0][0];
    }

    public void parse(String fileName) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            StringBuilder element = new StringBuilder();
            int rowIndex = 0;
            int columnIndex = 0;
            boolean isShielded = false;
            boolean isProtectedSymbol = false;

            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                char[] rowChars = row.toCharArray();

                for (int i = 0; i < rowChars.length; i++) {
                    if (!isProtectedSymbol) {
                        if (rowChars[i] == '"') {
                            if (!isShielded && element.isEmpty()) {
                                isShielded = true;
                                continue;
                            } else if (isShielded) {
                                if (i < rowChars.length - 1 && rowChars[i + 1] != ',') {
                                    isProtectedSymbol = true;
                                    continue;
                                }

                                isShielded = false;

                                continue;
                            }
                        }

                        if (!isShielded && (rowChars[i] == ',' || i == rowChars.length - 1)) {
                            rows = Arrays.copyOf(rows, rowIndex + 1);

                            if (rows[rowIndex] == null) {
                                rows[rowIndex] = new String[0];
                            }

                            rows[rowIndex] = Arrays.copyOf(rows[rowIndex], columnIndex + 1);

                            if (i == rowChars.length - 1 && rowChars[i] != ',') {
                                element.append(rowChars[i]);
                            }

                            rows[rowIndex][columnIndex] = element.toString();
                            columnIndex++;
                            element = new StringBuilder();
                            continue;
                        }
                    }

                    if (rowChars[i] == '<') {
                        element.append("&lt");
                    } else if (rowChars[i] == '>') {
                        element.append("&gt");
                    } else if (rowChars[i] == '&') {
                        element.append("&amp");
                    } else {
                        element.append(rowChars[i]);
                    }

                    isProtectedSymbol = false;
                }

                if (isShielded) {
                    element.append(System.lineSeparator());
                } else {
                    if (scanner.hasNextLine()) {
                        rowIndex++;
                        columnIndex = 0;
                    } else {
                        rows[rowIndex] = Arrays.copyOf(rows[rowIndex], columnIndex + 1);
                        rows[rowIndex][columnIndex] = element.toString();
                    }
                }
            }
        }
    }

    public String getHtml() {
        StringBuilder html = new StringBuilder();

        html.append("<table>").append(System.lineSeparator());

        for (String[] row : rows) {
            html.append("  <tr>").append(System.lineSeparator());

            for (String element : row) {
                html.append("    <td>").append(System.lineSeparator());
                html.append("      ").append(element).append(System.lineSeparator());
                html.append("    </td>").append(System.lineSeparator());
            }

            html.append("  </tr>").append(System.lineSeparator());
        }

        html.append("</table>");

        return html.toString();
    }

    public void writeToFile(String fileName) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(fileName);
        writer.println(getHtml());
        writer.close();
        System.out.println(getHtml());
    }
}
