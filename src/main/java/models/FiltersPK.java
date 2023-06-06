package models;

import lombok.Data;

import java.io.Serializable;

@Data
public class FiltersPK implements Serializable {
    private FilterNames fn;
    private FilterValues fv;
    private Product product;
}
