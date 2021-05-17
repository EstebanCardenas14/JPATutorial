package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.LibraryService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditLibraryServlet", value = "/edit-library")
public class EditLibraryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer idLibrary= Integer.parseInt(request.getParameter("libraryId"));
        String nameLibrary = request.getParameter("Lname");

        LibraryService libraryService = new LibraryService();
        libraryService.editLibrary(idLibrary,nameLibrary);

        response.sendRedirect("./index.jsp");

    }
}
