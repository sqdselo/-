import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Write {
    SimpleObfuscation simpleObfuscation = new SimpleObfuscation();
    public static int countWrite = 0;
    public Write(){
        try {
            countWrite = 0;
            new FileWriter("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt", false).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Write(String headerMessage, String descriptionMessage, String flagMessage ){

        try {
            if(!IsThereAny(descriptionMessage)){
                LocalDate localDate = LocalDate.now();
                LocalTime localTime = LocalTime.now();
                LocalTime localTime2 = localTime.truncatedTo(ChronoUnit.SECONDS);
                FileWriter writer = new FileWriter("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt", true);
                String lineForWrite = simpleObfuscation.encode(headerMessage + " ; " + descriptionMessage + " ; " + localDate + " " + localTime2 + " ; " + localDate + " " + localTime2 + " ; " + flagMessage);
                writer.write( lineForWrite + "\n");
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

    private boolean IsThereAny(String descriptionMessage){
        try {
            FileReader read = new FileReader("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt");
            BufferedReader bufferedReader = new BufferedReader(read);
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] words = simpleObfuscation.decode(line).split(";");
                if(words.length > 1 && words[1].trim().equals(descriptionMessage.trim())){
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return false;
    }



}
