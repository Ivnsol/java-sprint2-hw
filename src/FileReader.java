import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileReader {



    ArrayList<String> readFileContents(String fileName) {
        String path = "./resources/" + fileName;
        try {
            return new ArrayList<>(Files.readAllLines(Path.of(path)));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с отчётом. Возможно, файл отсутствует в нужной директории.");
            return new ArrayList<>();
        }
    }

}

/*Считать все месячные отчёты — прочитать данные из файлов месячных отчётов, сохранить их в память программы.
Считать годовой отчёт — прочитать данные из файла годового отчёта, сохранить их в память программы.
Вывести информацию обо всех месячных отчётах — по сохранённым данным вывести в консоль имеющуюся информацию.
Вывести информацию о годовом отчёте — по сохранённым данным вывести в консоль имеющуюся информацию.
 */
