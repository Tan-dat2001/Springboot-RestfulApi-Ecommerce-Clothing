package com.clothing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
@Table(name = "[order]")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Double total;

    private LocalDateTime orderDate;

    private Integer paymentStatus; // 0: chưa thanh toán, 1: Đã thanh toán.

    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus; // Đang xử lý, Đã xác nhận, Đang giao hàng, Hoàn thành, Đã hủy.

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderDetail> orderDetailList;


    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
