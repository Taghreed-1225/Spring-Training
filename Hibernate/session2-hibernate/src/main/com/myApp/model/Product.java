package main.com.myApp.model;

import lombok.*;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Setter
@Getter
@ToString

@NoArgsConstructor

@Entity
@Table(name="products")
public class Product   {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private int id;
    @Column(name ="name" , nullable = false)
    private String name;
    @Column(name ="description")
    private String description;
    @Column(name ="price", nullable = false)
    private double price;
    @Column(name ="stock_quantity", nullable = false)
    private int stockQuantity;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "production_date")
    private Date productionDate;
    @Transient
    private SimpleDateFormat dateFormat;

    public Product(String name, String description, int price, int stockQuantity, String manufacturer, String productionDate) throws ParseException {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.manufacturer = manufacturer;
        dateFormat=new SimpleDateFormat("yyyy-MM-dd");

        this.productionDate =dateFormat.parse(productionDate);
    }
}
