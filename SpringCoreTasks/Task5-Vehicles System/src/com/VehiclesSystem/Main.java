package com.VehiclesSystem;

import com.VehiclesSystem.config.Config;
import com.VehiclesSystem.controller.BikeController;
import com.VehiclesSystem.controller.CarController;
import com.VehiclesSystem.controller.PlaneController;
import com.VehiclesSystem.dao.DatabaseOperation;
import com.VehiclesSystem.model.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class Main {
    public static void main(String[] args) {


        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(Config.class);
        // test bike
      Bike bike= new Bike();
   bike.setId("1");
   bike.setBrand("bmw");
   bike.setType(Type.Bike);

        BikeController bikeController=container.getBean("bikeController",BikeController.class);
        bikeController.saveVehicle(bike);

        // test car
        Car car= new Car();
        car.setId("2");
        car.setBrand("Toyota");
        car.setType(Type.Car);
        CarController carController=container.getBean("carController",CarController.class);
        carController.saveVehicle(car);

        // test plane
        Plane plane= new Plane();
        plane.setId("5");
        plane.setBrand("Toyota");
        plane.setType(Type.Plane);
        PlaneController planeController=container.getBean("planeController",PlaneController.class);
         planeController.saveVehicle(plane);
        DatabaseOperation databaseOperation=container.getBean("databaseOperation",DatabaseOperation.class);


        // save test
        databaseOperation.save(plane);

        //delete test
        boolean isDeleted = databaseOperation.delete("id = '4'"); //
        if (isDeleted) {
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("Record not found or failed to delete.");
        }

        // update

       boolean isUpdated = databaseOperation.updateById("5", "bmw", "car");
        if (isUpdated) {
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("Record not found or failed to update.");
        }

         //search by id
        Vehicle vehicle = databaseOperation.searchById("4");
        if (vehicle != null) {
            System.out.println("Vehicle Details:");
            System.out.println("ID: " + vehicle.getId());
            System.out.println("Brand: " + vehicle.getBrand());
            System.out.println("Type: " + vehicle.getClass().getSimpleName());
        } else {
            System.out.println("Vehicle not found.");
        }


        //GET ALL
        List<Vehicle> vehicles = databaseOperation.getAllVehiclesDetails();
        if (!vehicles.isEmpty()) {
            for (Vehicle vehicle1 : vehicles) {
                System.out.println("ID: " + vehicle1.getId());
                System.out.println("Brand: " + vehicle1.getBrand());
                System.out.println("Type: " + vehicle1.getClass().getSimpleName());
                System.out.println("--------------------");
            }
        } else {
            System.out.println("No vehicles found.");
        }





        container.close();

    }}