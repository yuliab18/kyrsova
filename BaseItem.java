public abstract class BaseItem {
    private String name;

    private String description;

    private double wightInKg;
    private ItemType itemType;

    public BaseItem(String name, String description, double wightInKg) {
        this.name = name;
        this.description = description;
        this.wightInKg = wightInKg;
    }

    @Override
    public String toString() {
        return "Назва товара: " + name + "\nОпис товара: " + description + "\nВага товара: " + wightInKg + "\n Тип товара: " + itemType.toString();
    }

    public abstract String typeOfItem();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWightInKg() {
        return wightInKg;
    }

    public void setWightInKg(double wightInKg) {
        this.wightInKg = wightInKg;
    }
    public void setItemType(ItemType itemType){ this.itemType = itemType;}

    public ItemType getItemType() {
        return itemType;
    }
}
