package models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_filter_names")
public class FilterNames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected boolean isDeleted;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date DateCreated;
    @Column(length = 500, nullable = false)
    private String name;
    public FilterNames() {}
    public FilterNames(boolean isDeleted, Date dateCreated, String name) {
        this.isDeleted = isDeleted;
        DateCreated = dateCreated;
        this.name = name;
    }
}
