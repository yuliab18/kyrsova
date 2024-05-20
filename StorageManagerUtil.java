import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public final class StorageManagerUtil {
    public List<BaseItem> storage = new LinkedList<>();
    private final Scanner scanner = new Scanner(System.in);

    public StorageManagerUtil() {
        storage.add(new Shoes("красовки", "білий колір, 30шт", 15, 41, TypeSeason.SUMMER));
        storage.add(new Shoes("туфлі жін.", "Vitto Rosi, 15шт", 10, 39, TypeSeason.SUMMER));
        storage.add(new Clothing("плаття", "Timberland", 1.5, ClothingType.DRESS, TypeSeason.SUMMER, "black"));
        storage.add(new Toys("ведмедик", "сірий колір, 13шт", 52, TypeOfToys.SOFTTOY));
    }

    public void getAllItemTypesInStorage() {
        System.out.println("==================");
        for (BaseItem item : storage) {
            System.out.println(item.toString());
            System.out.println("==================");
        }
    }

    public void addItemToStorage() {
        System.out.println(("""
                Якого типу ви хочете добавити обє'кт в склад?\s
                Введіть 1, якщо це взуття\s
                Введіть 2, якщо це одяг\s
                Введіть 3, якщо це іграшки\s
                """));
        Scanner scanner = new Scanner(System.in);
        int numberToCreateItem = 0;
        try {
            numberToCreateItem = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Введіть будь-ласка саме цифру");
        }

        itemToCreate(numberToCreateItem);
        getAllItemTypesInStorage();
    }

    private void itemToCreate(int numberToCreateItem) {
        switch (numberToCreateItem) {
            case 1:
                createAndAddShoesToStorage();
                break;
            case 2:
                createAndAddClothingToStorage();
                break;
            case 3:
                createAndAddToysToStorage();
                break;
            default:
                System.out.println("Такої команди я не знаю");
        }
    }

    private void createAndAddShoesToStorage() {
        System.out.println("Введіть назву взуття");
        String name = scanner.nextLine();

        System.out.println("Введіть опис взуття");
        String description = scanner.nextLine();

        double wightInKg = getWightInKg();

        int size = getShoesSize();

        TypeSeason typeSeason = getTypeSeason();

        Shoes shoes = new Shoes(name, description, wightInKg, size, typeSeason);
        storage.add(shoes);
    }

    private double getWightInKg() {
        System.out.println("Введіть вагу в кілограмах");
        double wightInKg;

        try {
            wightInKg = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Введіть саме вагу");
            wightInKg = getWightInKg();
        }

        if (wightInKg < 0) {
            System.out.println("Вага не може бути від'ємна");
            wightInKg = getWightInKg();
        }

        return wightInKg;
    }

    private int getShoesSize() {
        System.out.println("Введіть розмір взуття");
        int size;

        try {
            size = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Введіть саме розмір");
            size = getShoesSize();
        }

        if (size < 0) {
            System.out.println("Розмір не може бути від'ємний");
            size = getShoesSize();
        }

        return size;
    }

    private TypeSeason getTypeSeason() {
        System.out.println("Введіть тип сезону: WINTER, SUMMER, AUTUMN, SPRING");
        TypeSeason typeSeason;

        try {
            String typeSeasonFromUser = scanner.nextLine().toUpperCase();
            typeSeason = TypeSeason.valueOf(typeSeasonFromUser);
        } catch (Exception e) {
            System.out.println("Введіть тип сезону коректно,як показано в прикладі");
            typeSeason = getTypeSeason();
        }

        return typeSeason;
    }

    private void createAndAddClothingToStorage() {
        System.out.println("Введіть назву одягу");
        String name = scanner.nextLine();

        System.out.println("Введіть опис одягу");
        String description = scanner.nextLine();

        System.out.println("Введіть колір одягу");
        String color = scanner.nextLine();

        ClothingType clothingType = getClothingType();

        double wightInKg = getWightInKg();

        TypeSeason typeSeason = getTypeSeason();

        Clothing clothing = new Clothing(name, description, wightInKg, clothingType, typeSeason, color);
        storage.add(clothing);
    }

    private ClothingType getClothingType() {
        System.out.println("Виберіть тип одягу: DRESS, SKIRT, BLOUSE");
        ClothingType clothingType;

        try {
            String clothingTypeFromUser = scanner.nextLine().toUpperCase();
            clothingType = ClothingType.valueOf(clothingTypeFromUser);
        } catch (Exception e) {
            System.out.println(("Введіть тип одягу коректно, як показано в прикладі"));
            clothingType = getClothingType();
        }

        return clothingType;
    }

    private void createAndAddToysToStorage() {
        System.out.println("Введіть назву іграшки");
        String name = scanner.nextLine();

        System.out.println("Введіть опис іграшки");
        String description = scanner.nextLine();

        double wightInKg = getWightInKg();

        TypeOfToys typeOfToys = getTypeOfToys();

        Toys toys = new Toys(name, description, wightInKg, typeOfToys);
        storage.add(toys);
    }

    private TypeOfToys getTypeOfToys() {
        System.out.println("Введіть вид іграшки: SOFTTOY, CARS, DOLLS");
        TypeOfToys typeOfToys;

        try {
            String typeOfToysFromUser = scanner.nextLine().toUpperCase();
            typeOfToys = TypeOfToys.valueOf(typeOfToysFromUser);
        } catch (Exception e) {
            System.out.println(("Введіть вид коректно, як показано в прикладі"));
            typeOfToys = getTypeOfToys();
        }

        return typeOfToys;
    }

    public String findItemByName() {
        System.out.println("Введіть назву товару:");
        String name = scanner.nextLine();

        BaseItem currentItem = null;
        for (BaseItem item : storage) {
            if (item.getName().equalsIgnoreCase(name)) {
                currentItem = item;
                break;
            }
        }

        if (currentItem != null) {
            System.out.println("Ми знайшли товар за іменем:");
            System.out.println("==================");
            System.out.println(currentItem);
            System.out.println("==================");
            return name;
        } else {
            System.out.println("Ми не знайшли товар за іменем");
            return null;
        }

    }

    public void orderItem() {
        String name = findItemByName();
        if (name != null) {
            int quantity = selectItemQuantity();
            System.out.println("Ви замовили товар '" + name + "', у кількості " + quantity + " штук(и)");
            System.out.println("Дякуємо за замовлення! <3");
        }
    }

    public int selectItemQuantity() {
        System.out.println("Введіть кількість товару скільки потрібно замовити: ");
        int quantity;

        try {
            quantity = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Помилка, Введіть кількість");
            quantity = selectItemQuantity();
        }

        if (quantity < 0) {
            System.out.println("Кількість товару не може бути відє'мна");
            quantity = selectItemQuantity();
        }

        return quantity;
    }


}