package main.com.myApp.dao;

import main.com.myApp.model.UserModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
@Scope("singleton")
public class DAO {
    @Value("${database.url}")
    private String url;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;
    private Connection con = null;
    @PostConstruct
    private void connectToDatabase()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");// load version of driver
            con= DriverManager.getConnection(url,username,password);// make java connection object

            if (con != null) {
                System.out.println("Connection established successfully.");
            } else {
                System.out.println("Connection failed, no connection returned.");
            }

        }catch(Exception e){

            System.out.println(e);
        }

    }

    @PreDestroy
    private void disconnectToDatabase() {
        try {

            if (con != null) {
                con.close();
                System.out.println("the connection is ended");
            } else {
                System.out.println("No connection to close");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    // insert into database
    public void save(UserModel userModel)
    {
        String sql = "INSERT INTO emp (username,email,password,confirmrpassword) VALUES (?,?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            // Set the values for the placeholders
            stmt.setString(1, userModel.getUsername());
            stmt.setString(2, userModel.getEmail());
            stmt.setString(3, userModel.getPassword());
            stmt.setString(4, userModel.getConfirmrpassword());

            // Execute the insert statement
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User inserted successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error while saving user: " + e.getMessage());
        }


        }}
