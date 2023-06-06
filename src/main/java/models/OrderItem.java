package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected boolean isDeleted;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date DateCreated;
    protected int priceBuy;
    protected int count;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    public OrderItem() {}

    public OrderItem(boolean isDeleted, Date dateCreated, int priceBuy, int count) {
        this.isDeleted = isDeleted;
        this.DateCreated = dateCreated;
        this.priceBuy = priceBuy;
        this.count = count;
    }
}
