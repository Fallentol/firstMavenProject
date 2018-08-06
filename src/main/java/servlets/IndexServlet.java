package servlets;

import controllers.LogInController;
import enitity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class IndexServlet extends HttpServlet {

    public static void main(String[] x) {
        System.out.println("MAIN METHOD!");
        System.out.println("WORKED!");
        System.out.println("YEEEEE!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String test = "Only post";
        System.out.println(test);
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        User user = new User(name, password);
        String warningMessage = LogInController.verifyLogIn(user) ? "Log In Completed" : "Log In Fail";
        System.out.println(warningMessage);
        req.setAttribute("userName", name);
        req.setAttribute("userName2", name);
        req.setAttribute("warningMessage", warningMessage);

        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Get servlet");
        int ytv = 5;
        response.setContentType("text/html");
        String message = "From servlet";
        request.setAttribute("message", message);
        request.setAttribute("git", ytv);
        request.getRequestDispatcher("WEB-INF/layout/indexJSP.jsp").forward(request, response);
    }


}
