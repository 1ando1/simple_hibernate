package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column(length = 200)
    String image;
    @Column(length = 500, nullable = false)
    String name;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date DateCreate;
    protected boolean isDeleted;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
    public Category() { }
    //конструктор
    public Category(String image, String name, Date dateCreate, boolean isDeleted) {
        super();
        this.image = image;
        this.name = name;
        this.DateCreate = dateCreate;
        this.isDeleted = isDeleted;
    }
}
