package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.EditionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "EditEditionSerlvlet", value = "/edit-edition")
public class EditEditIonServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer editionId = Integer.parseInt(request.getParameter("editionId"));
        Integer bookId = Integer.parseInt(request.getParameter("bookId"));
        String description = request.getParameter("description");
        Date date2 = ParseFecha(request.getParameter("release_year"));

        EditionService editionService = new EditionService();
        editionService.editEdition(editionId,description,date2,bookId);

        response.sendRedirect("./index.jsp");

    }

    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");

        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
        }
        return fechaDate;
    }

}
