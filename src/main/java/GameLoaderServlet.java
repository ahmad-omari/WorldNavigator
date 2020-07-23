import GameObjects.PlayersWaiting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/GameLoaderServlet")
public class GameLoaderServlet extends HttpServlet {
    private Set<String> names;
    private PlayersWaiting waiting;

    @Override
    public void init() throws ServletException {
        names = new HashSet<>();
        waiting = new PlayersWaiting();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (PlayersWaiting.getTimerSeconds()==0) {
            waiting = new PlayersWaiting();
            names.clear();
        }
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("name");
        names.add(user);
        session.setAttribute("names",names);
        response.sendRedirect("PrepareGame.jsp");
    }
}
