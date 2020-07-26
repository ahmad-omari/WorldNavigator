package GameObjects;

public class FinishTrade implements Command {
    @Override
    public void execute(String playerID) {
        System.out.println("Trade mode finished");
    }

    @Override
    public String toString() {
        return "Finish trade command";
    }
}
