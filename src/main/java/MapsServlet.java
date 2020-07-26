import GameObjects.GameCreation;
import GameObjects.GameListener;
import GameObjects.GameMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/MapsServlet")
public class MapsServlet extends HttpServlet {
   // private GameListener gameListener;
    private GameCreation gameCreation;

    @Override
    public void init() throws ServletException {
        //gameListener = new GameListener();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
       // gameListener.setNumberOfPlayers((Integer) session.getAttribute("numberofplayers"));
       // GameMap gameMap = gameListener.createMap();


        gameCreation = new GameCreation(session);
        gameCreation.createGame();

        //session.setAttribute("mapid",gameMap.getMapID());
        //session.setAttribute("roomsnumber",gameMap.getRoomsNumber());
        getServletContext().getRequestDispatcher("/WorldNavigatorGame.jsp").forward(request, response);
    }

}
