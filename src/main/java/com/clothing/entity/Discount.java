package com.clothing.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discount_id;
    private String discountName;
    private String discountCode;
    private int quantity;
    private float discountPrice;
    private String status;
    private LocalDateTime discountStart;
    private LocalDateTime discountEnd;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discount")
    private List<Product> productList;

}
