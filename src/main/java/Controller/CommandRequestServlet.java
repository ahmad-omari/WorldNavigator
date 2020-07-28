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

        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);

        GameMap map = GameListener.getGameMap(gameID);
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
            if (map.getWinnerName()!=null){
                System.out.println("winner name is " + playerName);
                jsonObject.put("winner",map.getWinnerName());
                out.println("finished");
                result = (String) jsonObject.get("finished");
            }
        }

        out.println(result);
        out.close();
    }

    private boolean checkGameEnd(String result){
        if (result.equals("finished")){
            return true;
        }
        return false;
    }

}
