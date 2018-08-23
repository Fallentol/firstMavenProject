package servlets;

import salesforce.SalesforceREST;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Index Servlet got a POST request");

        SalesforceREST salesforceREST = new SalesforceREST();

        String result = "";
        String token = request.getParameter("token");
        System.out.println("token is " + token);
        if (token.equals("first")) {
            result = salesforceREST.getAutorizationCode(request);
        } else {
            result = salesforceREST.secondRequest(request);
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
