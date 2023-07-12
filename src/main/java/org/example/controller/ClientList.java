package org.example.controller;

import org.example.controller.database.DBService;
import org.example.controller.model.Client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ClientList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBService service = new DBService();
        List<Client> list = service.list();
        PrintWriter writer = resp.getWriter();
        writer.write("<h1 style = 'text-align: center'>COMPANY INFORMATION FORM</h1>");
        String royxat = "<table border=\"2px solid black\">\n" +
                "    <tr>\n" +
                "        <th>Id</th>\n" +
                "        <th>Company_name</th>\n" +
                "        <th>Password</th>\n" +
                "        <th>Contract_year</th>\n" +
                "        <th>Action</th>\n" +
                "    </tr>\n" ;

        for(int i = 0; i < list.size(); i++){
            royxat += " "+ "  <tr>\n" +
                    "        <td>"+ list.get(i).getId()+"</td>\n" +
                    "        <td>"+ list.get(i).getCompany_name() +"</td>\n" +
                    "        <td>"+ list.get(i).getPassword()+"</td>\n" +
                    "        <td>"+ list.get(i).getContract_year()+"</td>\n" +
                    "        <td><a href=\"/update\">Update</a>|<a href=\"/delete\" onclick=\"if (!(confirm('Are you sure you want to delete this customer?'))) return false\">Delete</a></td>\n" +

                    "    </tr>\n" ;
        }
        royxat += " "+ "</table>";
        writer.write(royxat);
        writer.write("<a href = '/register'>Register</a>");
    }

}
