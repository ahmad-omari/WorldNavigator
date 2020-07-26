package GameObjects;

public class Mirror implements MapSite {
    private Key key;

    public Mirror() {
        key = null;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    @Override
    public String look() {
        return "You See a silhouette of you";
    }

    @Override
    public String toString() {
        return "Mirror";
    }
}
