package ru.academits.java.suslov.csv_parser_main;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String path;
        StringBuilder stringBuilder = new StringBuilder();

        for (String e : args) {
            stringBuilder.append(e).append(File.separator);
        }

        path = stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).toString();

        writeHtmlToFile(path);
    }

    public static void writeHtmlToFile(String filePath) {
        ArrayList<String> rowElements = new ArrayList<>();

        try (PrintWriter printWriter = new PrintWriter(filePath + File.separator + "output.txt");
             BufferedWriter writer = new BufferedWriter(printWriter)) {
            StringBuilder html = new StringBuilder("<!DOCTYPE html>");
            html.append(System.lineSeparator())
                    .append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"ru\" lang=\"ru\">").append(System.lineSeparator())
                    .append("<head>").append(System.lineSeparator())
                    .append("   <meta charset=\"UTF-8\">").append(System.lineSeparator())
                    .append("   <title>Список из входящего файла</title>").append(System.lineSeparator())
                    .append("</head>").append(System.lineSeparator())
                    .append("<body>").append(System.lineSeparator())
                    .append("   <table>").append(System.lineSeparator());

            writer.write(html.toString());

            try (FileReader fileReader = new FileReader(filePath + File.separator + "input.txt");
                 BufferedReader reader = new BufferedReader(fileReader)) {
                StringBuilder element = new StringBuilder();
                boolean isShieldedModeSector = false;
                boolean isProtectedSymbol = false;

                while (reader.ready()) {
                    String row = reader.readLine();

                    for (int i = 0; i < row.length(); i++) {
                        if (!isProtectedSymbol) {
                            if (row.charAt(i) == '"') {
                                if (!isShieldedModeSector && element.isEmpty()) {
                                    isShieldedModeSector = true;
                                    continue;
                                }

                                if (isShieldedModeSector) {
                                    if (i < row.length() - 1 && row.charAt(i + 1) != ',') {
                                        isProtectedSymbol = true;
                                        continue;
                                    }
                                }

                                isShieldedModeSector = false;
                                continue;
                            }

                            if (!isShieldedModeSector && (row.charAt(i) == ',' || i == row.length() - 1)) {
                                if (i == row.length() - 1 && row.charAt(i) != ',') {
                                    element.append(row.charAt(i));
                                }

                                rowElements.add(element.toString());
                                element = new StringBuilder();
                                continue;
                            }
                        }

                        if (row.charAt(i) == '<') {
                            element.append("&lt;");
                        } else if (row.charAt(i) == '>') {
                            element.append("&gt;");
                        } else if (row.charAt(i) == '&') {
                            element.append("&amp;");
                        } else {
                            element.append(row.charAt(i));
                        }

                        isProtectedSymbol = false;
                    }

                    if (isShieldedModeSector) {
                        element.append("<br/>");
                    } else {
                        if (reader.ready()) {
                            writer.write(convertRowToTrTd(rowElements));
                        } else {
                            rowElements.add(element.toString());
                        }
                    }
                }
            } catch (IOException e) {
                System.out.printf("Ошибка: %s", e.getMessage());
            }

            writer.write(convertRowToTrTd(rowElements));

            html = new StringBuilder();
            html.append("   </table>").append(System.lineSeparator())
                    .append("</body>").append(System.lineSeparator())
                    .append("</html>");

            writer.write(html.toString());

        } catch (IOException e) {
            System.out.printf("Ошибка: %s", e.getMessage());
        }
    }

    private static String convertRowToTrTd(ArrayList<String> rowList) {
        StringBuilder html = new StringBuilder();

        html.append("       <tr>").append(System.lineSeparator());

        while (rowList.size() > 0) {
            html.append("           <td>").append(System.lineSeparator());
            html.append("               ").append(rowList.get(0)).append(System.lineSeparator());
            html.append("           </td>").append(System.lineSeparator());

            rowList.remove(0);
        }

        html.append("       </tr>").append(System.lineSeparator());

        return html.toString();
    }
}