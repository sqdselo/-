import java.io.*;
import java.time.LocalDate;

public class Write {
    public static int countWrite = 0;
    public Write(){
        try {
            countWrite = 0;
            new FileWriter("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt", false).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Write(String message){

        try {
            if(!IsThereAny(message)){
                LocalDate localDate = LocalDate.now();
                FileWriter writer = new FileWriter("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt", true);
                writer.write(localDate + " ; " + message + " \n ");
                countWrite += 1;
                writer.close();
            }
            else{
                System.out.println("Такие данные уже имеются. попробуйте снова");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
        }
    }

    private boolean IsThereAny(String message){
        try {
            FileReader read = new FileReader("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt");
            BufferedReader bufferedReader = new BufferedReader(read);
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] words = line.split(";");
                if(words.length > 1 && words[1].trim().equals(message.trim())){
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return false;
    }



}
