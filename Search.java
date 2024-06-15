import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Search {
    public boolean flag;
    SimpleObfuscation simpleObfuscation = new SimpleObfuscation();
    public Search(String searchMessage, int operation){
        flag = false;
        try {
            FileReader read = new FileReader("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt");
            BufferedReader bufferedReader = new BufferedReader(read);
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] words = simpleObfuscation.decode(line).split(";");
                if(words.length > 1 && words[1].trim().equals(searchMessage.trim())){
                    flag = true;
                    if(operation != 0){
                        System.out.println("Ваша строка: " + simpleObfuscation.decode(line));
                    }

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(!flag){
            System.out.println("В списке не имеются строки с таким планом");
        }

    }
}