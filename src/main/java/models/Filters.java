package models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_filters")
@IdClass(FiltersPK.class)
public class Filters {
    @Id
    @ManyToOne
    @JoinColumn(name = "filter_name_id", nullable = false)
    private FilterNames fn;
    @Id
    @ManyToOne
    @JoinColumn(name = "filter_value_id", nullable = false)
    private FilterValues fv;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
