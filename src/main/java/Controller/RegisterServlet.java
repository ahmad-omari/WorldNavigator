package Controller;

import Database.MySqlDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Controller.RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private MySqlDB database;
    private boolean result;

    public RegisterServlet(){
        database = new MySqlDB();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        result=false;
        String username = request.getParameter("uname");
        String password = request.getParameter("password");
        if (username!=null && password!=null) {
            result =database.addPlayer(username, password);
        }
        String message="";
        if (result)
            message = "Successfully registered.";
        else
            message = "Registration failed.";

        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
