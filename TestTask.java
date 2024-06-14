import java.util.Arrays;
import java.util.Scanner;
public class TestTask {
    static boolean flag = true;
    static String[] array = {"#read", "#write", "#statistics"};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Доступные команды для использования: ");
        System.out.println("#write, #read, #statistics");
        System.out.println("Важно! следите за правильностью написания команды");
        while(flag){
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Введите команду: ");
            String currentCommand = scan.nextLine();
            if (Arrays.asList(array).contains(currentCommand)){
                switch(currentCommand){
                    case "#read":
                        Read read = new Read();
                        System.out.println("Считывание из файла");
                        break;

                    case "#write":
                        Write write = new Write();
                        System.out.println("Запись в файл");
                        break;

                    case "#statistics":
                        Statistics statistics = new Statistics();
                        System.out.println("Статистика ");
                        break;
                }
            }
            else{
                System.out.println("Неверная команда. Попробуйте еще раз");
            }
        }
    }
}
