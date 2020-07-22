package GameObjects;

public class PlainWall implements MapSite {
    @Override
    public void look() {
        System.out.println("You are facing an empty wall");
    }

    @Override
    public String toString() {
        return "Plain wall";
    }
}
