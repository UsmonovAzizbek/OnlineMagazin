package org.example.controller.model;

public class Client {
    private Integer id;
    private String company_name;
    private String password;
    private String contract_year;


    public Client(Integer id, String company_name, String password, String contract_year) {
        this.id = id;
        this.company_name = company_name;
        this.password = password;
        this.contract_year = contract_year;
    }


    public Client() {

    }

    public Client(String companyName, String password, String contractYear) {

    }

    public String getContract_year() {
        return contract_year;
    }

    public void setContract_year(String contract_year) {
        this.contract_year = contract_year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
