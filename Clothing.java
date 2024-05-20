public class Clothing extends BaseItem {

    private ClothingType clothingType;

    private TypeSeason typeSeason;

    private String color;

    public Clothing(String name, String description, double wightInKg, ClothingType clothingType, TypeSeason typeSeason,
                    String color) {
        super(name, description, wightInKg);
        setItemType(ItemType.CLOTHING);
        this.clothingType = clothingType;
        this.typeSeason = typeSeason;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Назва товара: " + getName() + "\nОпис товара: " + getDescription() + "\nВага товара: " + getWightInKg() +
                "кг" + "\nТип товара: " + getItemType().name() + "\nТип одягу: " + clothingType + "\nСезон: "
                + typeSeason + "\nКолір: " + color;
    }

    @Override
    public String typeOfItem() {
        return "Одяг";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ClothingType getClothingType() {
        return clothingType;
    }

    public void setClothingType(ClothingType clothingType) {
        this.clothingType = clothingType;
    }

    public TypeSeason getTypeSeason() {
        return typeSeason;
    }

    public void setTypeSeason(TypeSeason typeSeason) {
        this.typeSeason = typeSeason;
    }

}

