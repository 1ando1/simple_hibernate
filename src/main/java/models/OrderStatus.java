package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_order_status")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected boolean isDeleted;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date DateCreated;
    @Column(length = 500, nullable = false)
    private String name;
    /*@OneToMany(mappedBy = "orderStatus")
    private List<Order> orders;*/
    @OneToMany(mappedBy = "orderStatus")
    private List<Order> orders;
    public OrderStatus() {}
    public OrderStatus(boolean isDeleted, Date dateCreated, String name) {
        this.isDeleted = isDeleted;
        DateCreated = dateCreated;
        this.name = name;
    }
}
