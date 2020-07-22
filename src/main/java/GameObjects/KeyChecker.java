package GameObjects;

public class KeyChecker {
    private Key key;

    public KeyChecker(Key key) {
        this.key = key;
    }

    public Key check(){
        if (key != null){
            System.out.println("The "+key.getITEM_NAME()+" was acquired");
            return key;
        }
        return new EmptyKey();
    }

    @Override
    public String toString() {
        return "Key checker";
    }
}
