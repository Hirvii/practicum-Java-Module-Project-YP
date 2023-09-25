import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int count = countGuests(scanner);
        System.out.println(count);
    }

    public static int countGuests(Scanner scanner) {
        System.out.println("Ведите количество гостей: ");

        while (true) {
            if(scanner.hasNextInt()) {
                int count = scanner.nextInt();
                    if (count == 1) {
                        System.out.println("Нет необходимоти делить счёт.");
                        return count;
                    } else if (count < 1) {
                        System.out.println("Число гостей должно быть больше 1!");
                    } else {
                        return count;
                    }
            } else {
                System.out.println("Вы ввели некорректное число гостей! \n Повторите ввод: ");
                scanner.next();
            }
        }
    }

}

/*public class Calulator {

}*/