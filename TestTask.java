import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
public class TestTask {
    static boolean flag = true;
    static String[] array = {"#read", "#write", "#statistics", "#end"};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Доступные команды для использования: ");
        System.out.println("#write, #read, #statistics, #end");
        System.out.println("Важно! следите за правильностью написания команды");
        while(flag){
            System.out.println();
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Введите команду: ");
            String currentCommand = scan.nextLine();
            if (Arrays.asList(array).contains(currentCommand)){
                switch(currentCommand){
                    case "#read":
                        Read read = new Read();
                        break;

                    case "#write":
                        System.out.print("Введите ваши планы на сегодняшний день: ");
                        String message = scan.nextLine();
                        Write write = new Write(message);
                        break;

                    case "#statistics":
                        Statistics statistics = new Statistics();
                        System.out.println("Статистика ");
                        break;

                    case "#end":
                        Write write2 = new Write();
                        System.exit(0);
                }
            }
            else{
                System.out.println("Неверная команда. Попробуйте еще раз");
            }
        }
    }
}
