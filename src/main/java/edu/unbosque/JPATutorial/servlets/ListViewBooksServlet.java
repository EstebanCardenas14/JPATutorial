package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.servlets.pojos.BookPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listViewBooksServlet", value = "/list-viewBooks")
public class ListViewBooksServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        BookService bookService = new BookService();
        List<BookPOJO> books =  bookService.listBooks();

        String booksJSONString = new Gson().toJson(books);
        System.out.println("LIBROOOOOOOOOS "+booksJSONString);
        PrintWriter out = response.getWriter();
        out.print(booksJSONString);
        out.flush();
    }
}
