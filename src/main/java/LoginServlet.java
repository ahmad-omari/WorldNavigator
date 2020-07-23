import Database.MySqlDB;
import GameObjects.PlayersWaiting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private MySqlDB database;

    @Override
    public void init() throws ServletException {
        database = new MySqlDB();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtain parameters from the client
        String user = request.getParameter("uname");
        String password = request.getParameter("password");
        boolean result = database.isValidPlayer(user,password);

        if (result){
            HttpSession session=request.getSession();
            session.setAttribute("name",user);
            response.sendRedirect("GameLoaderServlet");
        }else {
            String message="Invalid user.";
            request.setAttribute("invalid", message);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }

}
