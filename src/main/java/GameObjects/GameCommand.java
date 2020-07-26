package GameObjects;

public class GameCommand extends MapCommands {
    public GameCommand(GameMap map) {
        super(map);
    }

    @Override
    public void makeCommands() {
        Invoker invoker = new Invoker();
        invoker.storeCommand(new Look(map));
        commandsMap.put("look", invoker);
        invoker = new Invoker();
        invoker.storeCommand(new Check(map));
        commandsMap.put("check", invoker);
        invoker = new Invoker();
        invoker.storeCommand(new TurnLeft(map));
        commandsMap.put("left", invoker);
        invoker = new Invoker();
        invoker.storeCommand(new TurnRight(map));
        commandsMap.put("right", invoker);
        invoker = new Invoker();
        invoker.storeCommand(new PlayerStatus(map));
        commandsMap.put("playerstatus", invoker);
        invoker = new Invoker();
        invoker.storeCommand(new MoveForward(map));
        commandsMap.put("forward", invoker);
        invoker = new Invoker();
        invoker.storeCommand(new MoveBackward(map));
        commandsMap.put("backward", invoker);
        invoker = new Invoker();
        invoker.storeCommand(new OpenDoor(map));
        commandsMap.put("open", invoker);
        invoker = new Invoker();
        invoker.storeCommand(new UseKey(map));
        commandsMap.put("usekey", invoker);
        invoker = new Invoker();
        invoker.storeCommand(new UseFlashLight(map));
        commandsMap.put("useflashlight", invoker);
        invoker = new Invoker();
        invoker.storeCommand(new SwitchLight(map));
        commandsMap.put("switchlight", invoker);
    }

    public void invoke(String commandRequest,String playerID){
        String command = prepareCommand(commandRequest);
        Invoker invoker = commandsMap.get(command);
        if (invoker != null){
            invoker.invoke(playerID);
        }
    }

    private String prepareCommand(String commandRequest){
        commandRequest = commandRequest.replaceAll("\\s","").toLowerCase();
        return commandRequest;
    }

    @Override
    public String toString() {
        return "Game command";
    }
}
