package com.VehiclesSystem.model;

import com.VehiclesSystem.dao.DatabaseOperation;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import lombok.Setter;

@Component
@Scope("prototype")
@Setter
@Getter
@ToString
public class Bike implements Vehicle{





    private String Id;
    private String brand;
    private Type type;

}
