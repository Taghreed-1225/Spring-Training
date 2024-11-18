package com.VehiclesSystem.dao;

import com.VehiclesSystem.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
@Component
@Scope("singleton")
public class DatabaseOperation {
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
        public Vehicle save(Vehicle vehicle)
    {
        String sql = "INSERT INTO taskvehicle (id, brand, type) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            // Set the values for the placeholders
            pstmt.setString(1, vehicle.getId());      // Set the vehicle's ID
            pstmt.setString(2, vehicle.getBrand()); // Set the vehicle's brand
            pstmt.setString(3, vehicle.getType().name());  // Set the vehicle's type

            // Execute the insert statement
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data is saved successfully.");
            } else {
                System.out.println("Failed to save data.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle;
    }
    //delete
    public boolean delete(String conditions) {
        //
        String sql = "DELETE FROM taskvehicle WHERE " + conditions;

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            //
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record(s) deleted successfully with conditions: " + conditions);
                return true; // Successfully deleted
            } else {
                System.out.println("No records found matching the conditions: " + conditions);
                return false; // No record found
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Deletion failed due to an exception
        }
    }


    // update
    public boolean updateById(String id, String newBrand, String newType) {
        String sql = "UPDATE taskvehicle SET brand = ?, type = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            // Set the new values for the placeholders
            pstmt.setString(1, newBrand); // Update the vehicle's brand
            pstmt.setString(2, newType); // Update the vehicle's type
            pstmt.setString(3, id); // Identify the vehicle by ID

            // Execute the update statement
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Vehicle with ID " + id + " is updated successfully.");
                return true; // Successfully updated
            } else {
                System.out.println("No vehicle found with ID " + id + ".");
                return false; // No record found to update
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Update failed due to an exception
        }
    }

    // search by id
    public Vehicle searchById(String id) {
        String sql = "SELECT * FROM taskvehicle WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, id);
            System.out.println("Executing query: " + pstmt);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Record found!");

                String brand = rs.getString("brand");
                String type = rs.getString("type");

                Vehicle vehicle;
                switch (type.toUpperCase()) {
                    case "CAR":
                        vehicle = new Car();
                        break;
                    case "BIKE":
                        vehicle = new Bike();
                        break;
                    case "PLANE":
                        vehicle = new Plane();
                        break;
                    default:
                        System.out.println("Unknown vehicle type: " + type);
                        return null;
                }

                vehicle.setId(id);
                vehicle.setBrand(brand);
                return vehicle;
            } else {
                System.out.println("No record found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    //
    public List<Vehicle> getAllVehiclesDetails() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM taskvehicle"; // تأكد من أن اسم الجدول صحيح

        try (PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // Process each record in the result set
            while (rs.next()) {
                String id = rs.getString("id");
                String brand = rs.getString("brand");
                String type = rs.getString("type");

                Vehicle vehicle;
                switch (type.toUpperCase()) {
                    case "CAR":
                        vehicle = new Car();
                        break;
                    case "BIKE":
                        vehicle = new Bike();
                        break;
                    case "PLANE":
                        vehicle = new Plane();
                        break;
                    default:
                        System.out.println("Unknown vehicle type: " + type);
                        continue; // Skip unknown vehicle types
                }

                vehicle.setId(id);
                vehicle.setBrand(brand);
                vehicles.add(vehicle); // Add the vehicle to the list
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }




}
