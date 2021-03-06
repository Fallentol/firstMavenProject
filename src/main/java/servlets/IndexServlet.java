package servlets;

import ru.strava.App;
import salesforce.SalesForceREST;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("Index Servlet got a POST request");

        SalesForceREST salesforceREST = new SalesForceREST();

        String result;
        String action = request.getParameter("action");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String userST = request.getParameter("userST");

        if (action.equals("logIn")) {
            result = salesforceREST.getAuthorizationCode(request);
        } else if (action.equals("logInWithPassword")) {
            result = salesforceREST.getAuthorizationCodeWithPassword(request, userName, userPassword, userST);
        } else if (action.equals("queryRequest")) {
            result = salesforceREST.getQueryRequest(request);
            App.test1(result);
        } else {
            result = salesforceREST.getAnonymousRequest(request);
        }
        PrintWriter pwList = response.getWriter();
        pwList.write(result);
        request.setAttribute("some", "anyParam");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String message = "Report data";
        request.setAttribute("message", message);
        request.setAttribute("adminName", "Serega");
        request.getRequestDispatcher("WEB-INF/layout/indexJSP.jsp").forward(request, response);
    }
}
