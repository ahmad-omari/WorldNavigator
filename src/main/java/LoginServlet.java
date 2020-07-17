import Database.MySqlDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private MySqlDB database;

    public LoginServlet(){
        database = new MySqlDB();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();

        // Obtain parameters from the client
        String username = request.getParameter("uname");
        String password = request.getParameter("password");
        boolean result = database.isValidPlayer(username,password);

        out.print("<html>");
        out.print("<body>");
        out.print("<p>");
        out.print(username +" and "+password +" is valid "+result);
        out.print("</p>");
        out.print("</body>");
        out.print("</html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
