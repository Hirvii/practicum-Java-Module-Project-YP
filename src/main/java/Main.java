import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerGuests = new Scanner(System.in);
        int guestCount = countGuests(scannerGuests);
        Calulator calculator = new Calulator();

        System.out.println("Введите название товара (или команду \"Завершить\", если все товары добавлены)");

        while(true) {

            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");

            if (scanner.hasNextLine()) {
                String itemName = scanner.nextLine();

                if (itemName.equalsIgnoreCase("завершить")) {
                    break;
                } else if(itemName.equals("")) {
                    System.out.println("Название товара не может быть пустым!");
                } else {
                    calculator.addItemName(itemName + "\n");

                    System.out.println("Введите стоимость товара");

                    while (true) {
                        if (scanner.hasNextDouble()) {

                            double itemCost = scanner.nextDouble();

                            if (itemCost > 0) {
                                calculator.addItemCost(itemCost);

                                System.out.println("Товар успешно добавлен\n");
                                System.out.printf("Текущая общая сумма товаров: %.2f ", calculator.itemsCosts);
                                System.out.println(getRuble(calculator.itemsCosts) + "\n");
                                break;
                            } else {
                                System.out.println("Стоимость не может быть отрицательной! Повторите ввод:");
                            }
                        } else {
                            System.out.println("Вы ввели не число!");
                            scanner.next();
                        }
                    }
                }
                System.out.println("Введите название следующего товара (или команду \"Завершить\", если все товары добавлены)");
            }
        }
        System.out.println("Добавленные товары:\n" + calculator.itemsNames);
        System.out.printf("Итоговая общая сумма товаров: %.2f ", calculator.itemsCosts);
        System.out.println(getRuble(calculator.itemsCosts) + "\n");

        double costPerGuest = calculator.itemsCosts / guestCount;

        System.out.printf("Каждый гость должен заплатить: %.2f ", costPerGuest);
        System.out.println(getRuble(costPerGuest));

    }

    public static int countGuests(Scanner scanner) {
        System.out.println("На скольких гостей необходимо разделить счёт? ");

        while (true) {
            if(scanner.hasNextInt()) {
                int count = scanner.nextInt();

                if (count == 1) {
                    System.out.println("Нет необходимоти делить счёт. Вы можете добавить товары, чтобы посчитать их общую сумму.");
                    return count;
                } else if (count < 1) {
                    System.out.println("Число гостей должно быть больше 1! Повторите ввод:");
                } else {
                    return count;
                }
            } else {
                System.out.println("Вы ввели некорректное число гостей! Повторите ввод: ");
                scanner.next();
            }
        }
    }
    public static String getRuble(double cost) {
        int costInt = (int)cost;
        if ((costInt == 1) || (costInt % 10 == 1)) {
            return "рубль";
        } else if((costInt >= 2 && costInt <=4) || (costInt % 10 >= 2 && costInt % 10 <= 4)) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}