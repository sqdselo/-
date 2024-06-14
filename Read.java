import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Read {
    public Read(){
        try {
            FileReader read = new FileReader("D:\\Test\\тестик\\ФайлДляХраненияДанных.txt");
            BufferedReader bufferedReader = new BufferedReader(read);
            String line;
            int count = 0;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
                count += 1;
            }
            if(count == 0){
                throw new Exception();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл");
        } catch (Exception e){
            System.out.println("Данных в файле нет");
        }


    }

}
