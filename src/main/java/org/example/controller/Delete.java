package org.example.controller;

import org.example.controller.database.DBService;
import org.example.controller.model.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("delete.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int  id = Integer.parseInt(req.getParameter("id"));
        DBService service = new DBService();
        PrintWriter writer = resp.getWriter();
        Client client = service.delete(id);
        if (client == null){
            writer.write("<h1 style = 'text-align : center'>DELETE COMPANY</h1>");
        }else {
            writer.write("<h1 style = 'text-align : center'>ERROR</h1>");
        }
    }
}
