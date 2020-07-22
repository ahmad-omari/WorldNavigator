package GameObjects;

import java.util.Arrays;

public class TradeCommand extends MapCommands {
    private Item tradeItem;
    public TradeCommand(GameMap map) {
        super(map);
        tradeItem = new EmptyItem();
    }

    @Override
    public void makeCommands() {
        Invoker invoker = new Invoker();
        invoker.storeCommand(new ListSellerItem(map));
        commandsMap.put("trade", invoker);

        invoker = new Invoker();
        BuyItem buyItem = new BuyItem(map);
        buyItem.setItem(tradeItem);
        invoker.storeCommand(buyItem);
        commandsMap.put("buy", invoker);

        invoker = new Invoker();
        SellItem sellItem = new SellItem(map);
        sellItem.setItem(tradeItem);
        invoker.storeCommand(sellItem);
        commandsMap.put("sell", invoker);

        invoker = new Invoker();
        invoker.storeCommand(new FinishTrade());
        commandsMap.put("finish", invoker);
    }

    @Override
    public void invoke(String commandRequest) {
        String command = prepareCommand(commandRequest);
        Invoker invoker = commandsMap.get(command);
        if (invoker != null) {
            invoker.invoke();
        }
    }



    private String prepareCommand(String commandRequest){
        String [] commandsArray = commandRequest.split("\\s");
        if (commandsArray.length == 1) {
            return commandsArray[0];
        }
        String itemString = makeItemName(commandsArray);
        makeItem(itemString);
        commandRequest = commandsArray[0];
        checkTradeCommand(commandRequest);
        return commandRequest;
    }

    private void checkTradeCommand(String commandRequest){
        if (commandRequest.equals("buy"))
            updateBuyCommand();
        else if (commandRequest.equals("sell"))
            updateSellCommand();
    }

    private String makeItemName(String [] commandsArray){
        String itemString = "";
        if (commandsArray.length == 1) {
            return commandsArray[0];
        }else if (commandsArray.length==2) {
            itemString = commandsArray[1].toLowerCase();
        }else if (commandsArray.length==3){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(commandsArray[1]);
            stringBuilder.append(commandsArray[2]);
            itemString = stringBuilder.toString().toLowerCase();
        }
        return itemString;
    }

    private void makeItem(String itemName){
        if (itemName.equals("flashlight")) {
            tradeItem = new FlashLight();
        }else if (itemName.equals("magickey")){
            tradeItem = new MagicKey();
        }else if (itemName.equals("silverkey")){
            tradeItem = new SilverKey();
        }else if (itemName.equals("goldenkey")){
            tradeItem = new GoldenKey();
        }
    }

    private void updateBuyCommand(){
        Invoker invoker = new Invoker();
        BuyItem buyItem = new BuyItem(map);
        buyItem.setItem(tradeItem);
        invoker.storeCommand(buyItem);
        commandsMap.put("buy", invoker);
    }

    private void updateSellCommand(){
        Invoker invoker = new Invoker();
        SellItem sellItem = new SellItem(map);
        sellItem.setItem(tradeItem);
        invoker.storeCommand(sellItem);
        commandsMap.put("sell", invoker);
    }

    @Override
    public String toString() {
        return "Trade Command";
    }
}
