package com.adminPanel.app.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@javax.persistence.Table(name = "product")
@Setter
@Getter
@NoArgsConstructor
@ApiModel(value = "this is the model of the product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "this is the id of the product")
    private int id;


    @NotEmpty(message = "cannot empty")
    @Column(name = "name")
    @ApiModelProperty(value = "this is the name of the product")
    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_details_id")
    @JsonIgnore
    private ProductDetails productDetailsId;


//@JsonIgnore
//@OneToOne(cascade = CascadeType.ALL  )
//@JoinColumn(name = "product_details_id")
//private ProductDetails productDetails;productDetails

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productDetailsId=" + productDetailsId +
                '}';
    }
}
