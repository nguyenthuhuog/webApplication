package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class controller {
    public class Employee{
        public Integer id;
        public String name;
        public Integer salary;
        public String department;
    }

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        List<Employee> employees = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        
        String jdbcUrl = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "root";

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            if(connection == null) System.out.println("Cannot connect to database");
            else System.out.println("Connected to database");
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from employees");

            while (rs.next()) {  
                Employee tempEmployee = new Employee();  
                tempEmployee.id = rs.getInt(1);
                tempEmployee.name = rs.getString(2);
                tempEmployee.salary = rs.getInt(3);
                tempEmployee.department = rs.getString(4);
                employees.add(tempEmployee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        model.addAttribute("employees", employees);
        return "index";
    }
}