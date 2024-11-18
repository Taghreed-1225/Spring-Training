package com.VehiclesSystem.model;

import lombok.Setter;


public interface Vehicle {
    String getId();
    String getBrand();
    Type getType();
    void setId(String x);
    void setBrand(String x);
    void setType(Type x );

}
