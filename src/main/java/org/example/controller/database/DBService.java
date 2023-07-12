package org.example.controller.database;

import org.example.controller.ProductList;
import org.example.controller.model.Client;
import org.example.controller.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBService {
    private String URL = "jdbc:postgresql://localhost:5432/online";
    private String DBUser = "postgres";
    private String DBPassword = "1";

    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(URL, DBUser, DBPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Client login(String company_name, String password) {
        try {
            String query = "select * from company where company_name = ? and password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, company_name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String company_name1 = resultSet.getString("company_name");
                String password1 = resultSet.getString("password");
                String contract_year = resultSet.getString("contract_year");
                Client client = new Client(id, company_name1, password1, contract_year);
                return  client;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public List<Client> list() {

        try {
            String query = "select * from company";
            Statement statement = connection.createStatement();
            List<Client> clientList = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setCompany_name(resultSet.getString("company_name"));
                client.setPassword(resultSet.getString("password"));
                client.setContract_year(resultSet.getString("contract_year"));
               clientList.add(client);
            }
            return clientList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

// azizbek
    public Client registerCopm(String company_name, String password, String contract_year) {

        try {
            String query = "insert into company(company_name,password,contract_year) values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, company_name);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, contract_year);
            preparedStatement.executeUpdate();
            return new Client(company_name,password, contract_year);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Client update(Client client) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            String query = "update company set company_name = ?, password = ?, contract_year = ? where id = "+ client.getId();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, client.getCompany_name());
            preparedStatement.setString(2, client.getPassword());
            preparedStatement.setString(3, client.getContract_year());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Client delete(int id) {

        try {
            String query = "delete from company where id = " + id + ";";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Product add(String category, String type, String subType, String name, String description, int price) {

        try {
            String query = "insert into product(category, type, subType, name, description, price) values(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, category);
            preparedStatement.setString(2, type);
            preparedStatement.setString(3, subType);
            preparedStatement.setString(4, name);
            preparedStatement.setString(5, description);
            preparedStatement.setInt(6, price);
            preparedStatement.executeUpdate();
            return new Product(category, type, subType, name, description, price);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> listP() {

        try {
            String query = "select * from product";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> productList =  new ArrayList<>();
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setCategory(resultSet.getString("category"));
                product.setType(resultSet.getString("type"));
                product.setSubtype(resultSet.getString("subType"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getInt("price"));
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Product delete_p(int id) {

        try {
            String query = "delete from product where id = "+id+";";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Product update_p(Product product) {
        try {
            String query = "update product set category=?, type=?, subType=?, name=?, description=?, price=?  where id = "+product.getId();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getCategory());
            preparedStatement.setString(2, product.getType());
            preparedStatement.setString(3, product.getSubtype());
            preparedStatement.setString(4, product.getName());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
