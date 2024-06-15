import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Change {
    Scanner scan = new Scanner(System.in);
    public Change(String changeMessage, int n){
        try {
            n--;
            List<String> list = new ArrayList<>();

            FileReader read = new FileReader("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt");
            BufferedReader bufferedReader = new BufferedReader(read);
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] words = line.split(" ; ");
                if(words.length > 1 && words[1].trim().equals(changeMessage.trim())){
                    if(n == 0){
                        System.out.print("Введите новый заголовок для вашего плана: ");
                        String newHeader = scan.nextLine();
                        words[0] = newHeader;
                    }
                    if(n == 1){
                        System.out.print("Введите новое описание вашегоплана: ");
                        String newDescription = scan.nextLine();
                        words[1] = newDescription;
                    }
                    if(n == 2){
                        System.out.print("Выполнили ли вы цель? (Да/Нет): ");
                        String newFlag = scan.nextLine();
                        words[4] = newFlag;
                    }
                    LocalDate localDate = LocalDate.now();
                    LocalTime localTime = LocalTime.now();
                    LocalTime localTime2 = localTime.truncatedTo(ChronoUnit.SECONDS);
                    words[3] = String.valueOf(localDate) +" "+String.valueOf(localTime2);
                    list.add(String.join(" ; ", words));
                }
                else{
                    list.add(line);
                }
            }
            bufferedReader.close();
            read.close();
            FileWriter writer = new FileWriter("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt", false);
            for(int i = 0 ; i < list.size(); i++){
                writer.write(list.get(i) + "\n");
            }
            writer.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
