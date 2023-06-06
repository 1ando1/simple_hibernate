package models;

import lombok.Data;

import java.io.Serializable;

@Data
public class FilterNameGroupsPK implements Serializable {
    private FilterNames fn;
    private FilterValues fv;
}
