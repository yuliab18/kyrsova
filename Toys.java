public class Toys extends BaseItem {
    public TypeOfToys typeOfToys;

    public Toys(String name, String description, double wightInKg, TypeOfToys typeOfToys) {
        super(name, description, wightInKg);
        setItemType(ItemType.TOYS);
        this.typeOfToys = typeOfToys;
    }

    @Override
    public String toString() {
        return "Назва товара: " + getName() + "\nОпис товара: " + getDescription() + "\nВага товара: " + getWightInKg() +
                "кг" + "\nТип товара: " + getItemType().name() + "\nТип іграшки: " + typeOfToys.name();
    }

    @Override
    public String typeOfItem() {
        return "Іграшки";
    }

}
