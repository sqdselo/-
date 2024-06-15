import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Change {

    public Change(String changeMessage, int vibor){
        try {
            FileReader read = new FileReader("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt");
            BufferedReader bufferedReader = new BufferedReader(read);
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] words = line.split("");
                if(words.length > 1 && words[1].trim().equals(changeMessage.trim())){
                    break;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
