package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.RentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CreateRentServlet", value ="/create-rent")

public class CreateRentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String email = request.getParameter("email");
        Integer id_edition = Integer.parseInt(request.getParameter("id_edition"));
        Date date2 = ParseFecha(request.getParameter("release_year"));

        RentService rentService = new RentService();
        rentService.saveRent(email, date2, id_edition);

        response.sendRedirect("./index.jsp");
    }

    public static Date ParseFecha(String fecha)
    {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaConvertida = format.parse(fecha);
            System.out.println("La fecha convertida es: "+fechaConvertida);
            return fechaConvertida;
        } catch (Exception e) {
            System.err.println("No se ha podido convertir la fecha");
        }
        return null;
    }

}
