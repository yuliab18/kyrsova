import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StorageManagerUtil storageManager = new StorageManagerUtil();

        System.out.println("Вітаємо на нашому складі!!");
        System.out.println("Ось інстукція:");

        boolean flag = true;
        while (flag) {
            System.out.println("Введіть 1, щоб побачити всі речі які є на складі");
            System.out.println("Введіть 2, щоб додати будь-яку річ до складу");
            System.out.println("Введіть 3, щоб перевірити наявність товару");
            System.out.println("Введіть 4, щоб замовити товар");
            System.out.println("Введіть 0, щоб завершити програму");

            String action = scanner.nextLine();
            switch (action) {
                case ("1") -> storageManager.getAllItemTypesInStorage();
                case ("2") -> storageManager.addItemToStorage();
                case ("3") -> storageManager.findItemByName();
                case ("4") -> storageManager.orderItem();
                case ("0") -> flag = false;
                default -> System.out.println("Помилка, введіть ще раз");
            }
        }
    }
}