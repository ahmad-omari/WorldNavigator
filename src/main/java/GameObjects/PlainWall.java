package GameObjects;

public class PlainWall implements MapSite {
    @Override
    public String look() {
        return "You are facing an empty wall";
    }

    @Override
    public String toString() {
        return "Plain wall";
    }
}
