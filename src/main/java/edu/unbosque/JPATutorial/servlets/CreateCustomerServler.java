package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cretateCustomerServlet", value = "/create-customer")
public class CreateCustomerServler  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String email = request.getParameter("email");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String gender = request.getParameter("gender");
        Integer age = Integer.valueOf(request.getParameter("age"));

        CustomerService customerService = new CustomerService();
        customerService.saveCustomer(email,first_name,last_name,gender,age);

        response.sendRedirect("./index.jsp");
    }


}
