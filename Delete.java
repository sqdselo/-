import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Delete {

    public Delete(String deleteMessage) {
        List<String> list = new ArrayList<>();
        FileReader read = null;
        try {
            read = new FileReader("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt");
            BufferedReader bufferedReader = new BufferedReader(read);
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] words = line.split(";");
                if(words.length > 1 && !words[1].equals(" " + deleteMessage + " ") ){
                    list.add(line);
                }
            }
            FileWriter writer = new FileWriter("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt", false);
            for(int i = 0 ; i < list.size(); i++){
                writer.write(list.get(i) + "\n");
            }
            Write.countWrite -= 1;
           writer.close();
        } catch (IOException ex) {
            System.out.println("файл не найден");
        }
    }
}
