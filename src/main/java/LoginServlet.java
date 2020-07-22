import Database.MySqlDB;
import GameObjects.PlayersWaiting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private MySqlDB database;
    private Set<String> names;
    private PlayersWaiting waiting;

    public LoginServlet(){
        database = new MySqlDB();
        names = new HashSet<>();
        waiting = new PlayersWaiting();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Obtain parameters from the client
        String user = request.getParameter("uname");
        String password = request.getParameter("password");
        boolean result = database.isValidPlayer(user,password);

        if (result){

            if (PlayersWaiting.getTimerSeconds()==0) {
                waiting = new PlayersWaiting();
                names.clear();
            }

            HttpSession session=request.getSession(true);

            names.add(user);
            session.setAttribute("name",user);
            session.setAttribute("names",names);
            response.sendRedirect("PrepareGame.jsp");
        }else {
            String message="Invalid user.";
            request.setAttribute("invalid", message);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
