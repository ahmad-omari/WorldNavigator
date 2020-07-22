package GameObjects;

public class Invoker {
    private Command command;

    public void storeCommand(Command command){this.command = command;}

    public void invoke(){command.execute();}

    @Override
    public String toString() {
        return "Command invoker";
    }
}
