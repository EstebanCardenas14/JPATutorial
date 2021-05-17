package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.BookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditBookServlet", value = "/edit-Book")
public class EditBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        String genre = request.getParameter("genre");
        Integer authorId = Integer.parseInt(request.getParameter("authorId"));
        Integer bookId = Integer.parseInt(request.getParameter("bookId"));



        BookService bookService = new BookService();
       bookService.editBook(bookId,title,isbn,authorId-1,genre);
        System.out.println("toca cambiar el primer authorid"+ title);

        response.sendRedirect("./index.jsp");

    }


}
