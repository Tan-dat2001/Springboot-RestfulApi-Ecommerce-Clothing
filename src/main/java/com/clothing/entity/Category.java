package com.clothing.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;
    private String categoryName;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Product> productList;
}
