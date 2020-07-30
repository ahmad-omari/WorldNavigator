package Controller;

import GameObjects.GameDriver;
import GameObjects.PlayerInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
  //  private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session=request.getSession();
        PlayerInfo.removeJSONObject(session.getId());
        GameDriver.removePlayer(session.getId());
        session.invalidate();
        response.sendRedirect("index.jsp");;
    }
}
