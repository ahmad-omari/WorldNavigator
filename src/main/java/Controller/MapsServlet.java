package Controller;

import GameObjects.GameDriver;
import GameObjects.PlayersCounter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Controller.MapsServlet")
public class MapsServlet extends HttpServlet {
    private GameDriver gameDriver;

    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        request.getSession().setAttribute("numberofplayers", PlayersCounter.getCount());
        gameDriver = new GameDriver(session);
        gameDriver.createGame();
        response.sendRedirect("WorldNavigatorGame.jsp");
    }

}
