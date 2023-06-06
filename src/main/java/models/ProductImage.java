package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_product_images")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(length = 500, nullable = false)
    String name;
    private int priority;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date DateCreate;
    protected boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public ProductImage(Date dateCreated, boolean isDelete, String name, int priority, Product product) {
        this.DateCreate = dateCreated;
        this.isDeleted = isDelete;
        this.name = name;
        this.priority = priority;
        this.product = product;
    }
}
