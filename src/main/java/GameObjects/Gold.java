package GameObjects;

public class Gold extends Item {
    public Gold() {
        super("Gold");
        setItemValue(20);
    }

    public void addGold(int amount){
        int total = getItemValue()+amount;
        setItemValue(total);
    }

    public void removeGold(int amount){
        if (getItemValue() >= amount) {
            int total = getItemValue() - amount;
            setItemValue(total);
        }
    }

    @Override
    public String toString() {
        return "Gold";
    }
}
