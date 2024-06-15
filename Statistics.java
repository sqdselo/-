import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

public class Statistics {
    SimpleObfuscation simpleObfuscation = new SimpleObfuscation();
    public static Map<String, Integer> dict;
    public Statistics(){
        try {
            dict = new Hashtable<>();
            FileReader read = new FileReader("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt");
            BufferedReader bufferedReader = new BufferedReader(read);
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] words = simpleObfuscation.decode(line).split(" ; ");
                dict.put(words[2], 1);
            }
            int maxCountForDay = -1;
            String maxDay = "";
            for(int i : dict.values()){
                if(i > maxCountForDay){
                    maxCountForDay = i;
                    for(String key : dict.keySet()){
                        if(dict.get(key) == maxCountForDay){
                            maxDay = key.split(" ")[0];
                        }
                    }
                }
            }

            System.out.println("--Текущая статистика--");
            System.out.println("Колличество записей: " + Write.countWrite);
            System.out.println("Самый активный день по записям: " + (maxCountForDay != -1 ? maxDay : "нет данных"));
        }
        catch(FileNotFoundException ex){
            System.out.println("Файл не найден");
        }
        catch(Exception ex){
            System.out.println("Статистика пуста");
        }

    }

}
