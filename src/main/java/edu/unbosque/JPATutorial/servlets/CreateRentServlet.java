package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.EditionService;
import edu.unbosque.JPATutorial.services.RentService;
import edu.unbosque.JPATutorial.servlets.pojos.EditionPOJO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "createRentServlet", value = "/create-Rent")
public class CreateRentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        EditionService editionService = new EditionService();
        List<EditionPOJO> edition  = editionService.listEditions();

        RentService rentService = new RentService();

        String email = request.getParameter("email");
        String book = request.getParameter("books_view");






    }
}
