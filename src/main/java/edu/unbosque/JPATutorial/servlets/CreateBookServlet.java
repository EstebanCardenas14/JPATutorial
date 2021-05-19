package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.services.EditionService;
import edu.unbosque.JPATutorial.servlets.pojos.BookPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "cretateBookServlet", value = "/create-book")
public class CreateBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        String genre = request.getParameter("genre");
        Date date2 = ParseFecha(request.getParameter("release_year"));
        String description = request.getParameter("description");
        Integer authorId = Integer.parseInt(request.getParameter("authorId"));
        Integer bookID = 0;
        BookService bookService = new BookService();
        bookService.saveBook(title, isbn, authorId,genre);
        List<BookPOJO> list = bookService.listBooks();
        for (int i = 0; i < list.size();i++){
            if(title.equals(list.get(i).getTitle())){
                bookID = list.get(i).getBook_id();
                break;
            }
        }
        EditionService editionService = new EditionService();
        editionService.saveEdition(description,date2,bookID);
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
