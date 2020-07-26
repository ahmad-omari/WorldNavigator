import GameObjects.GameListener;
import GameObjects.GameMap;
import GameObjects.MapController;
import GameObjects.PlayerInfo;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CommandRequestServlet")
public class CommandRequestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int gameID = Integer.parseInt(request.getParameter("gameID"));
        String playerID = request.getParameter("IDPlayer");
        String command = request.getParameter("command");

        GameMap map = GameListener.getGameMap(gameID);
        MapController controller = new MapController(map);
        controller.makeAction(command,playerID);
        JSONObject jsonObject = PlayerInfo.getJSONObject(playerID);
        PrintWriter out = response.getWriter();
        out.println(jsonObject.get("result"));
    }
}
