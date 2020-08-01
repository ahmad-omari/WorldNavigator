package Controller;

import Database.MySqlDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Controller.LoginServlet")
public class LoginServlet extends HttpServlet {
    private MySqlDB database;

    @Override
    public void init() throws ServletException {
        database = new MySqlDB();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("uname");
        String password = request.getParameter("pass");
        boolean result = database.isValidPlayer(user,password);
        PrintWriter writer = response.getWriter();
        if (result){
            HttpSession session=request.getSession();
            session.setAttribute("name",user);
            writer.print("True");
        }else {
            writer.println("Invalid User");
        }
        writer.close();
    }

}
