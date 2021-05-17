package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.EditionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditEditionSerlvlet", value = "/edit-edition")
public class EditEditIonServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer editionId = Integer.parseInt(request.getParameter("editionId"));
        Integer bookId = Integer.parseInt(request.getParameter("bookId"));
        String description = request.getParameter("description");
        String date2 = request.getParameter("release_year");

        EditionService editionService = new EditionService();
        editionService.editEdition(editionId,description,date2,bookId);

        response.sendRedirect("./index.jsp");

    }

}
