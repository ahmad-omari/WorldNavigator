package Controller;

import GameObjects.GameListener;
import GameObjects.GameMap;
import GameObjects.PlayerInfo;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/EndGameServlet")
public class EndGameServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Game ended !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        JSONObject jsonObject = PlayerInfo.getJSONObject(request.getSession().getId());
        if (jsonObject.get("winner")!=null) {
            request.getSession().setAttribute("usename", jsonObject.get("winner"));
            response.sendRedirect("GameEnd.jsp");
        }
    }
}
