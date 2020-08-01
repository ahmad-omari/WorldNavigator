package Controller;

import Database.MySqlDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        String password = request.getParameter("pass");
        if (username!=null && password!=null) {
            result =database.addPlayer(username, password);
        }
        PrintWriter writer = response.getWriter();
        if (result)
            writer.println("Successfully registered.");
        else
            writer.println("Registration failed.");
        writer.close();

    }

}
