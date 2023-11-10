package com.clothing.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_desc")
    private String productDesc;
    @Column(name = "product_price")
    private Double productPrice;
    @Column(name = "sold_quantity")
    private Integer soldQuantity;
    @Column(name = "quantity")
    private Integer inventoryQuantity;
    @Column(name = "status")
    private String status;

//    @Basic(optional = true)
    @Column(name = "create_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createAt;

//    @Basic(optional = true)
    @Column(name = "update_at")
    @UpdateTimestamp
    private LocalDateTime updateAt;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "product")
    private List<ProductImage> productImageList;

    @OneToOne(mappedBy = "product")
    private CartItem cartItem;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<OrderDetail> orderDetailList;

}
