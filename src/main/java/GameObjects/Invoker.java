package GameObjects;

public class Invoker {
    private Command command;

    public void storeCommand(Command command){this.command = command;}

    public void invoke(String playerID){command.execute(playerID);}

    @Override
    public String toString() {
        return "Command invoker";
    }
}
