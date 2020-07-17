import Database.MySqlDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private MySqlDB database;
    private boolean result;

    public RegisterServlet(){
        database = new MySqlDB();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        result=false;
        // Obtain parameters from the client
        String username = request.getParameter("uname");
        String password = request.getParameter("password");
        if (username!=null && password!=null) {
            result =database.addPlayer(username, password);
        }
        out.print("<html>");
        out.print("<body>");
        out.print("<p>");
        out.print(username +" and "+password +" is registed "+result);
        out.print("</p>");
        out.print("</body>");
        out.print("</html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
