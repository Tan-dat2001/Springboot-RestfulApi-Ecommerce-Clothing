package com.clothing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Momo, Thẻ ngân hàng, COD(thanh toán khi nhận hàng)

    private Integer status; //0: disable. 1: enabled

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentMethod")
    private List<OrderDetail> orderDetailList;
}
