package com.clothing.entity;

import com.clothing.registration.code.ConfirmationCode;
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
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String address;
    private String phone;
    private Integer status;
    //    @Basic(optional = false)
    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    //    @Basic(optional = false)
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserRole> userRoleList;
    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Order> orderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<ConfirmationCode> confirmationCodes;
}
