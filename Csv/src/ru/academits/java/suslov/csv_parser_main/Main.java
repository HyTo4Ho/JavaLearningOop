package ru.academits.java.suslov.csv_parser_main;
import ru.academits.java.suslov.csv_parser.CsvParser;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CsvParser inputCsv = new CsvParser();
        inputCsv.parse("Csv/input.txt");
        inputCsv.writeToFile("Csv/output.txt");
    }
}