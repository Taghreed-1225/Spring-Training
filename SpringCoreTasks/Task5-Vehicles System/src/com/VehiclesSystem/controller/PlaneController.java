package com.VehiclesSystem.controller;

import com.VehiclesSystem.dao.DatabaseOperation;
import com.VehiclesSystem.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PlaneController implements VehicleController{
    @Override
    public void saveVehicle(Vehicle vehicle) {
        System.out.println(vehicle);

    }
    DatabaseOperation databaseOperation;

    @Autowired
    public void setDatabaseOperation(DatabaseOperation databaseOperation) {
        this.databaseOperation = databaseOperation;
    }
}
