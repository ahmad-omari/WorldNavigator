package GameObjects;

public class Painting implements MapSite {
    private Key key;

    public Painting() {
        key = null;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    @Override
    public void look() {
        System.out.println("You are facing a painting");
    }

    @Override
    public String toString() {
        return "Painting";
    }
}
