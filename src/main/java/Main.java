import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerGuests = new Scanner(System.in);
        int guestCount = countGuests(scannerGuests);

        Calulator calculator = new Calulator();

        System.out.println("Введите название товара (или команду \"Завершить\", чтобы завершить работу приложения)");

        while (true) {

            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");

            if (scanner.hasNextLine()) {
                String itemName = scanner.nextLine();

                if (itemName.equalsIgnoreCase("завершить")) {
                    break;
                } else if (itemName.equals("")) {
                    System.out.println("Название товара не может быть пустым! Введите название товара еще раз: ");
                } else {
                    calculator.addItemName(itemName + "\n");

                    System.out.println("Введите стоимость товара в формате рубли.копейки");

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
                                    System.out.println("Стоимость не может быть отрицательной! Введите стоимость еще раз:");
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

                if (count == 1){
                    System.out.println("Нет необходимости делить счёт. Введите число гостей ещё раз: ");
                } else if(count < 1) {
                    System.out.println("Число гостей должно быть больше 1! Введите число гостей ещё раз: ");
                } else {
                    return count;
                }
            } else {
                System.out.println("Вы ввели некорректное число гостей! Введите число гостей ещё раз: ");
                scanner.next();
            }
        }
    }

    public static String getRuble(double cost) {
        int costInt = (int)Math.floor(cost);

        if (costInt % 100 >= 11 && costInt % 100 <= 19) {
            return "рублей";
        } else if ((costInt == 1) || (costInt % 10 == 1 && costInt != 11)) {
            return "рубль";
        } else if((costInt >= 2 && costInt <=4) || ((costInt % 10 >= 2 && costInt % 10 <= 4) && (costInt != 12 && costInt != 13 && costInt != 14))) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
}