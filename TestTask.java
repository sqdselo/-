import java.util.Arrays;
import java.util.Scanner;
public class TestTask {
    static boolean flag = true;
    static String[] array = {"#read", "#write", "#statistics", "#delete", "#search", "#change"};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Доступные команды для использования: ");
        System.out.println("#write, #read, #statistics, #delete, #search, #change");
        System.out.println("Запись происходит так: Заголовок ; Описание дела ; Дата создания ; Дата редактирования ; Выполнена ли цель");
        System.out.println("Важно! следите за правильностью написания команды");
        Write writeEnd = new Write();
        while(flag){
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Введите команду: ");
            String currentCommand = scan.nextLine();
            if (Arrays.asList(array).contains(currentCommand)){
                switch(currentCommand){
                    case "#read":
                        Read read = new Read();
                        break;

                    case "#write":
                        System.out.println("Введите заголовок вашей цели");
                        String headerMessage = scan.nextLine();
                        System.out.println("Введите описание вашей цели на сегодняшний день: ");
                        String descriptionMessage = scan.nextLine();
                        System.out.println("Ваша цель выполнена? Да/Нет");
                        String flagMessage = scan.nextLine();
                        if(flagMessage.equals("Да") || flagMessage.equals("Нет")){
                            Write write = new Write(headerMessage, descriptionMessage, flagMessage);
                        }
                        else{
                            System.out.println("Не все данные введены верно");
                        }
                        break;

                    case "#statistics":
                        Statistics statistics = new Statistics();
                        break;

                    case "#delete":
                        System.out.println("Введите описание плана, который хотите вычеркнуть из списка: ");
                        String deleteMessage = scan.nextLine();
                        Delete delete = new Delete(deleteMessage);
                        break;

                    case "#search":
                        System.out.println("Введите описание плана, который хотите найти: ");
                        String searchMessage = scan.nextLine();
                        Search search = new Search(searchMessage);
                        break;

                    case "#change":
                        System.out.println("Укажите описание плана, который хотите изменить: ");
                        String changeMessage = scan.nextLine();
                        Search search2 = new Search(changeMessage);
                        if(search2.flag){
                            System.out.println("Что именно вы хотите изменить?");
                            System.out.println("---------");
                            System.out.println("1: Заголовок ");
                            System.out.println("2: Описание ");
                            System.out.println("3: Маркер ");
                            System.out.println("---------");
                            int n = Integer.parseInt(scan.nextLine());
                            Change change = new Change(changeMessage, n);
                        }
                        break;
                }
            }
            else{
                System.out.println("Неверная команда. Попробуйте еще раз");
            }
        }
    }
}
