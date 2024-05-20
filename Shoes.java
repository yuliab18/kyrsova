public class Shoes extends BaseItem {

    private Integer size;
    private TypeSeason typeSeason;

    public Shoes(String name, String description, double wightInKg, int size, TypeSeason typeSeason) {
        super(name, description, wightInKg);
        this.size = size;
        this.typeSeason = typeSeason;
        setItemType(ItemType.SHOES);
    }


    @Override
    public String toString() {
        return "Назва товара: " + getName() + "\nОпис товара: " + getDescription() + "\nВага товара: " + getWightInKg() +
                "кг" + "\nТип товара: " + getItemType().name() + "\nРозмір взуття: " + size + "\nСезон: "
                + typeSeason;
    }

    @Override
    public String typeOfItem() {
        return "Взуття";
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public TypeSeason getTypeSeason() {
        return typeSeason;
    }

    public void setTypeSeason(TypeSeason typeSeason) {
        this.typeSeason = typeSeason;
    }
}
