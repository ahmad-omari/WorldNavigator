package Controller;

import GameObjects.PlayersCounter;
import GameObjects.PlayersWaiting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet("/GameLoaderServlet")
public class GameLoaderServlet extends HttpServlet {
    private Set<String> names;
    private Map<String,Integer> players;
    private PlayersWaiting waiting;

    @Override
    public void init() throws ServletException {
        names = new HashSet<>();
        players = new HashMap<>();
        waiting = new PlayersWaiting();
    }

    protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("the waiting time is "+PlayersWaiting.getTimerSeconds());
        if (PlayersWaiting.getTimerSeconds()<=1) {
            waiting = new PlayersWaiting();
            names.clear();
            PlayersCounter.setCount(0);
        }
        HttpSession session = request.getSession();
        if(players.get(session.getId())==null){
            players.put(session.getId(),1);
            PlayersCounter.incrementCount();
        }
        String user = (String) session.getAttribute("name");
        names.add(user);
        request.getSession().setAttribute("numberofplayers",names.size());
        session.setAttribute("names",names);
        response.sendRedirect("PrepareGame.jsp");
    }
}
