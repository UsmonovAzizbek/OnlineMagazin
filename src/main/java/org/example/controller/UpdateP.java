package org.example.controller;

import org.example.controller.database.DBService;
import org.example.controller.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateP extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("update_p.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String category = req.getParameter("category");
        String type = req.getParameter("type");
        String subType = req.getParameter("subType");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int price = Integer.parseInt(req.getParameter("price"));
        DBService service = new DBService();
        PrintWriter writer = resp.getWriter();
        Product product = new Product(id, category, type, subType, name, description, price);
        Product product1 = service.update_p(product);
        if (product1 == null){
            writer.write("<h1 style = 'text-align : center'>UPDATE PRODUCT</h1>");
        }else {
            writer.write("<h1 style = 'text-align : center'>ERROR</h1>");
        }
    }
}
