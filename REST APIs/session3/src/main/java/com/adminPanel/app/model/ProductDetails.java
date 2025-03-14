package com.adminPanel.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Table;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@javax.persistence.Table(name="product_details")
@Setter
@Getter
@NoArgsConstructor

public class ProductDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @NotEmpty(message = "cannot empty")
    @Column(name="name")
    private String name;

    @NotNull(message = "is required")
    @Positive(message = "Price must be a positive number")
    @Column(name="price")
     private double price;

    @NotNull(message = "is required")
    @Column(name="available")
    private boolean available;

    @NotEmpty(message = "cannot empty")
    @Column(name="manufacturer")
    private String manufacturer;


    @NotNull(message = "is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name="expiration_date")
    private Date expirationDate;

//    @OneToOne(cascade = CascadeType.ALL)
//   @JoinColumn(name="product_id")
//    //@Column(name="product_id")
//    private int productId;


// to make relation unidirectional
    @JsonIgnore
@OneToOne(mappedBy = "productDetailsId" ,cascade = CascadeType.ALL)
    private Product product;

    public ProductDetails(String tea, String date, String el3rosa, int i, boolean b) {
    }


    public void setAvailable(@NotNull(message = "is required") boolean available) {
        this.available = available;
    }


    public void set(ProductDetails productDetails)
    {
        System.out.println("hello from set ");
        System.out.println(productDetails);
        this.name=productDetails.name;
        this.manufacturer=productDetails.manufacturer;
        this.price=productDetails.price;
        this.available=productDetails.available;
        this.expirationDate=productDetails.expirationDate;


    }

    public ProductDetails(String name, double price, boolean available, String manufacturer, Date expirationDate) {
        this.name = name;
        this.price = price;
        this.available = available;
        this.manufacturer = manufacturer;
        this.expirationDate = expirationDate;
    }
}
