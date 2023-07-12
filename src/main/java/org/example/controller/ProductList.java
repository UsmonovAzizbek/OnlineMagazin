package org.example.controller;

import org.example.controller.database.DBService;
import org.example.controller.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProductList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        DBService service = new DBService();
        List<Product> plist = service.listP();
        writer.write("<h1 style = 'text-align: center'>PRODUCT INFORMATION FORM</h1>");
        String royxat = "<table border=\"2px solid black\">\n" +
                "    <tr>\n" +
                "        <th>Id</th>\n" +
                "        <th>Category</th>\n" +
                "        <th>Type</th>\n" +
                "        <th>SubType</th>\n" +
                "        <th>Name</th>\n" +
                "        <th>Description</th>\n" +
                "        <th>Price</th>\n" +
                "        <th>Action</th>\n" +
                "    </tr>\n" ;

        for(int i = 0; i < plist.size(); i++){
            royxat += " "+ "  <tr>\n" +
                    "        <td>"+ plist.get(i).getId()+"</td>\n" +
                    "        <td>"+ plist.get(i).getCategory() +"</td>\n" +
                    "        <td>"+ plist.get(i).getType()+"</td>\n" +
                    "        <td>"+ plist.get(i).getSubtype()+"</td>\n" +
                    "        <td>"+ plist.get(i).getName()+"</td>\n" +
                    "        <td>"+ plist.get(i).getDescription()+"</td>\n" +
                    "        <td>"+ plist.get(i).getPrice()+"</td>\n" +
                    "        <td><a href=\"/update_p\">Update</a>|<a href=\"/delete_p\" onclick=\"if (!(confirm('Are you sure you want to delete this customer?'))) return false\">Delete</a></td>\n" +

                    "    </tr>\n" ;
        }
        royxat += " "+ "</table>";
        writer.write(royxat);
        writer.write("<a href = '/register_p'>Register</a>");
    }

}

