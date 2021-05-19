package edu.unbosque.JPATutorial.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AssociateEditionServlet", value = "/assos-edition")
public class AssoEditionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String editionId = request.getParameter("edition_id");
        String libraryId = request.getParameter("libraryId");
        System.out.println("aca el edition asso ----> " + request.getParameter("edition_id"));
        System.out.println("aca el library asso ----> " + libraryId);
        response.sendRedirect("./index.jsp");
    }

}
