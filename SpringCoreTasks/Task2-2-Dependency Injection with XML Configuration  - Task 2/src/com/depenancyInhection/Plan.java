package com.depenancyInhection;

public class Plan implements Vehicle{
DatabaseOperation dbo;
 // constructor injection


    public Plan(DatabaseOperation dbo) {
        this.dbo = dbo;
    }

    @Override
    public void savaData(Vehicle vehicle) {
        dbo.savedb(vehicle);

    }
}
