package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.BookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "cretateBookServlet", value = "/create-book")
public class CreateBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        String genre = request.getParameter("genre");
        String date2 = request.getParameter("release_year");
        Integer authorId = Integer.parseInt(request.getParameter("authorId"));

        BookService bookService = new BookService();
        bookService.saveBook(title, isbn, authorId,genre);

        response.sendRedirect("./index.jsp");

    }

}
