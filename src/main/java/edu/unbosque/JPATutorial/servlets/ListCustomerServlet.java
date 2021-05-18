package edu.unbosque.JPATutorial.servlets;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.CustomerService;
import edu.unbosque.JPATutorial.servlets.pojos.CustomerPOJO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listCustomersServlet", value = "/list-customers")
public class ListCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        CustomerService customerService = new CustomerService();
        List<CustomerPOJO> customers = customerService.listCustomer();

        String customersJson = new Gson().toJson(customers);

        PrintWriter out = response.getWriter();
        out.print(customersJson);
        out.flush();
    }
}
