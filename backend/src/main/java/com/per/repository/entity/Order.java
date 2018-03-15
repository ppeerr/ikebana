package com.per.repository.entity;

import com.per.repository.enums.StatusType;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "orders", schema = "public")
public class Order extends BaseEntity {

    private Integer id;

    @Length(min = 3)
    private String customerName;

    private String phoneNumber;

    private String comment;

    private String address;

    private Integer weeksCount;

    private String selectedDaysMask;

    @Min(value = 0)
    private Integer totalPrice;

    private LocalDate startDate;

    private Date lastStatusCheckDate;

//    private List<OrderedProduct> products;

    private StatusType status = StatusType.PROCESSING;

    @Id
    @SequenceGenerator(name="orders_sequence", sequenceName="orders_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_sequence") //TODO check SequenceStyleGenerator
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Column(nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(nullable = false)
    public Integer getWeeksCount() {
        return weeksCount;
    }

    public void setWeeksCount(Integer weeksCount) {
        this.weeksCount = weeksCount;
    }

    @Column(nullable = false)
    public String getSelectedDaysMask() {
        return selectedDaysMask;
    }

    public void setSelectedDaysMask(String selectedDaysMask) {
        this.selectedDaysMask = selectedDaysMask;
    }

    @Column(nullable = false)
    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Column(nullable = false)
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    //TODO cascade and proper bidirectional relationship
//    @OneToMany(mappedBy = "order")
//    public List<OrderedProduct> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<OrderedProduct> products) {
//        this.products = products;
//    }

    public Date getLastStatusCheckDate() {
        return lastStatusCheckDate;
    }

    public void setLastStatusCheckDate(Date lastStatusCheckDate) {
        this.lastStatusCheckDate = lastStatusCheckDate;
    }

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
}
