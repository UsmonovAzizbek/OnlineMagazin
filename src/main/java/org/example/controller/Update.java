package org.example.controller;

import org.example.controller.database.DBService;
import org.example.controller.model.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.sendRedirect("update.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int  id = Integer.parseInt(req.getParameter("id"));
        String company_name = req.getParameter("company_name");
        String password = req.getParameter("password");
        String contract_year = req.getParameter("contract_year");
        DBService service = new DBService();
        PrintWriter writer = resp.getWriter();
        Client client = new Client(id, company_name, password, contract_year);
        Client update = service.update(client);
        if (update == null){
            writer.write("<h1 style = 'text-align : center'>UPDATE COMPANY</h1>");
        }else {
            writer.write("<h1 style = 'text-align : center'>ERROR</h1>");
        }
    }
}
