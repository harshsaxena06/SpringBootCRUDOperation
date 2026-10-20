package com.harsh.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotBlank(message = "Name must not be blank ")
    @Column(nullable = false)
    private String name ;

    @NotNull(message = "Quantity cannot be Null")
    @Column(nullable = false)
    @Min(value=0)
    private Integer quantity ;

    @NotNull(message = "Price cannot be Null")
    @Column(nullable=false , precision=10 , scale=2)
    @DecimalMin(value="0.00" , inclusive = false)
    private BigDecimal price ;

    public Product(){}
    public Product(Long id, String name, Integer quantity, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
