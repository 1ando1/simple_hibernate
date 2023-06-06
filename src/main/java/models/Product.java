package models;

import lombok.Data;
import org.hibernate.annotations.common.reflection.XProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date DateCreated;
    protected boolean isDeleted;
    @Column(length = 500, nullable = false)
    private String name;
    @Column(length = 4000)
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    public Product() {
        productImages = new ArrayList<>();
        //orderItems = new ArrayList<>();
    }
    public Product(Date dateCreate, boolean isDeleted, String name, String description, Category category) {
        super();
        this.DateCreated = dateCreate;
        this.isDeleted = isDeleted;
        this.name = name;
        this.description = description;
        this.category = category;
    }
}
