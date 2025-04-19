package ru.academits.java.suslov.csv_parser;
/*
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class CsvParser {
    private String[][] rows;

    public CsvParser() {
        rows = new String[0][0];
    }

    public void parse(String filePath) throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath + File.separator + "input.txt"))) {
            StringBuilder element = new StringBuilder();
            int rowIndex = 0;
            int columnIndex = 0;
            boolean isShielded = false;
            boolean isProtectedSymbol = false;

            while (reader.ready()) {
                String row = reader.readLine();
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
                        element.append("&lt;");
                    } else if (rowChars[i] == '>') {
                        element.append("&gt;");
                    } else if (rowChars[i] == '&') {
                        element.append("&amp;");
                    } else {
                        element.append(rowChars[i]);
                    }

                    isProtectedSymbol = false;
                }

                if (isShielded) {
                    element.append("<br/>");
                } else {
                    if (reader.ready()) {
                        rowIndex++;
                        columnIndex = 0;
                    } else {
                        rows[rowIndex] = Arrays.copyOf(rows[rowIndex], columnIndex + 1);
                        rows[rowIndex][columnIndex] = element.toString();
                    }
                }
            }
        } catch (IOException e) {
            System.out.printf("Ошибка: %s", e.getMessage());
        }
    }

    public String getHtml() {
        StringBuilder html = new StringBuilder("<!DOCTYPE html>");
        html.append(System.lineSeparator())
                .append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"ru\" lang=\"ru\">").append(System.lineSeparator())
                .append("<head>").append(System.lineSeparator())
                .append("   <meta charset=\"UTF-8\">").append(System.lineSeparator())
                .append("   <title>Список из входящего файла</title>").append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("   <table>").append(System.lineSeparator());

        for (String[] row : rows) {
            html.append("       <tr>").append(System.lineSeparator());

            for (String element : row) {
                html.append("           <td>").append(System.lineSeparator());
                html.append("               ").append(element).append(System.lineSeparator());
                html.append("           </td>").append(System.lineSeparator());
            }

            html.append("       </tr>").append(System.lineSeparator());
        }

        html.append("   </table>").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>");

        return html.toString();
    }

    public void writeToFile(String filePath) throws FileNotFoundException {
        try (
                PrintWriter writer = new PrintWriter(filePath + File.separator + "output.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(writer)
        ) {
            bufferedWriter.write(getHtml());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
} */
