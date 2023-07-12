package org.example.controller;

import org.example.controller.database.DBService;
import org.example.controller.model.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {

    private String company_name = "azizbek";
    private String password = "125";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String company_name = req.getParameter("company_name");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        DBService service = new DBService();
        Client client = service.login(company_name, password);
        if (client != null){
            if (client.getCompany_name().equals("azizbek") && client.getPassword().equals("125")){
                resp.sendRedirect("admin.html");
            }else if (client.getCompany_name().equals(company_name) && client.getPassword().equals(password)){
                resp.sendRedirect("category.html");
            }
        }else {
            writer.write("<h1 style = 'text-align: center'>NOT FOUND COMPANY</h1>");
        }

    }
}
