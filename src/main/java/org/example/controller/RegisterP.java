package org.example.controller;

import org.example.controller.database.DBService;
import org.example.controller.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("register_p.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        String type = req.getParameter("type");
        String subType = req.getParameter("subType");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int price = Integer.parseInt(req.getParameter("price"));
        DBService service = new DBService();
        PrintWriter writer = resp.getWriter();
        Product product = service.add(category, type, subType, name, description, price);
        if (product == null){
            writer.write("<h1 style = 'text-align: center'>ERROR</h1>");
        }else {
            writer.write("<h1 style = 'text-align: center'>CREATE PRODUCT</h1>");
        }
    }
}
