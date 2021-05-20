package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.EditionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DesasociateEditionServlet", value = "/TERCERO-edition")
public class DesassoEditionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Integer editionId = Integer.parseInt(request.getParameter("edition_id"));
        Integer libraryId = Integer.parseInt(request.getParameter("libraryId"));
        System.out.println("aca el library tercero ----> "  + libraryId);
        System.out.println("aca el edition tercero ----> " + request.getParameter("edition_id"));
          EditionService editionService= new EditionService();
          editionService.disassociate(libraryId,editionId);
        response.sendRedirect("./index.jsp");
    }

}
