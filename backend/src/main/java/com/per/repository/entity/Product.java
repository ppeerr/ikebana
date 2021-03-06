package com.per.repository.entity;

import com.per.repository.enums.FlowersType;
import com.per.repository.enums.ProductType;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "products", schema = "public")
public class Product extends BaseEntity {

    private Integer id;

    private ProductType type;

    private FlowersType flowersType;

    @Length(min = 3)
    private String name;

    private String description;

    @Min(value = 0)
    private Integer quantity;

    @Min(value = 0)
    private Integer price;


    @Id
    @SequenceGenerator(name="products_sequence", sequenceName="products_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_sequence")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    public FlowersType getFlowersType() {
        return flowersType;
    }

    public void setFlowersType(FlowersType flowersType) {
        this.flowersType = flowersType;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Column(nullable = false)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
