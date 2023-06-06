package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected boolean isDeleted;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date DateCreated;

    @ManyToOne
    @JoinColumn(name = "order_status_id", nullable = false)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
    public Order() {}
    public Order(boolean isDeleted, Date dateCreated) {
        this.isDeleted = isDeleted;
        this.DateCreated = dateCreated;
    }
}
