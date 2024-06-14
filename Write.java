import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Write {
    public Write(){
        try {
            new FileWriter("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt", false).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Write(String message){

        try {
            LocalDate localDate = LocalDate.now();
            FileWriter writer = new FileWriter("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt", true);
            writer.write(localDate + " | " + message + " \n\r ");
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
        }
    }



}
