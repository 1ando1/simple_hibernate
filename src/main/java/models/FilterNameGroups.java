package models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_filter_name_groups")
@IdClass(FilterNameGroupsPK.class)
public class FilterNameGroups {
    @Id
    @ManyToOne
    @JoinColumn(name = "filter_name_id", nullable = false)
    private FilterNames fn;
    @Id
    @ManyToOne
    @JoinColumn(name = "filter_values_id", nullable = false)
    private FilterValues fv;
}
