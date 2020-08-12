package Controller;

import GameObjects.*;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CommandRequestServlet")
public class CommandRequestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        int gameID = Integer.parseInt(request.getParameter("gameID"));
        String playerName = request.getParameter("playername");
        String playerID = request.getParameter("IDPlayer");
        String command = request.getParameter("command");

        System.out.println("CMD: "+gameID+" "+playerName+" "+playerID+" "+command);
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        System.out.println("Json is : "+jsonObject==null);
        GameMap map = GameListener.getGameMap(gameID);
        System.out.println("MAP IS "+(map==null));
        if (command.equals("logout")){
            if (jsonObject.get("fiqht")==null) {
                PlayersFight playeLose = new PlayersFight(map);
                int playerGold = map.getPlayer(playerID).getPlayerItem(new Gold().getITEM_NAME()).getItemValue();
                playeLose.makePlayerLose(playerID);
                playeLose.takeGold(playerID, playerGold);
                playeLose.removeItems(playerID);
            }
        }
        String result = "";
        if (map.isAvailable()) {
            MapController controller = new MapController(map);
            controller.makeAction(command, playerID);
            result = (String) jsonObject.get("result");
            boolean isGameEnd = checkGameEnd(result);
            if (isGameEnd){
                map.setAvailable(false);
                map.setWinnerName(playerName);
                System.out.println("first winner name is " + playerName);
                jsonObject.put("winner",playerName);
            }
        }else {
            jsonObject.put("result","finished");
            jsonObject.put("winner",map.getWinnerName());
            result = "finished";
        }
        if (jsonObject.get("fight") != null){
            if (jsonObject.get("fight").equals("lose")) {
                result="lose";
            }
        }

        out.print(result);
        out.close();
    }

    private boolean checkGameEnd(String result){
        if (result.equals("finished")){
            return true;
        }
        return false;
    }

}
