package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.CustomerService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditBookServlet", value = "/edit-customer")
public class EditCustomerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String Email = request.getParameter("email");
        String First_Name = request.getParameter("first_name");
        String Last_Name = request.getParameter("last_name");
        String Gender = request.getParameter("gender");
        Integer age = Integer.parseInt(request.getParameter("age"));

        CustomerService customerService = new CustomerService();
        customerService.editCustomer(Email,First_Name,Last_Name,Gender,age);

        response.sendRedirect("./index.jsp");


}

}
