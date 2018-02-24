package com.per.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "ordered_product", schema = "public")
public class OrderedProduct extends BaseEntity {

    private Integer id;

    private Integer orderId;

    private Integer productId;

    private Integer amount;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id", nullable = false)
//    @ManyToOne
//    @JoinColumn(name = "order_id")
    @Column(nullable = false)
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

//    @ManyToOne
//    @JoinColumn(name = "product_id", nullable = false)
    @Column(nullable = false)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Column(nullable = false)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
