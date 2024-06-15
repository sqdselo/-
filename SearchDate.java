import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class SearchDate {
    SimpleObfuscation simpleObfuscation = new SimpleObfuscation();
    public SearchDate(LocalDate date) {
        try {
            FileReader read = new FileReader("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt");
            BufferedReader bufferedReader = new BufferedReader(read);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = simpleObfuscation.decode(line).split(";");
                if (LocalDate.parse(words[2].trim().split(" ")[0]).equals(date)) {
                    System.out.println(simpleObfuscation.decode(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Не найден файл");
        }

    }
}
