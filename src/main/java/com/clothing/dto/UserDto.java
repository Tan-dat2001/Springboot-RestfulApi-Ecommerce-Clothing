package com.clothing.dto;

import com.clothing.common.Function;
import com.clothing.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    // todo : Shouldn't convert 'password' from entity to dto

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private Integer status;
    private long createdAt;
    private long updatedAt;

    public UserDto(User user){
        this.id = user.getUserId();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.address = user.getAddress();
        this.phone = user.getPhone();
        this.status = user.getStatus();
        this.createdAt = null != user.getCreatedAt() ? Function.toLongFromTimeStamp(user.getCreatedAt()) : 0;
        this.updatedAt = null != user.getUpdatedAt() ? Function.toLongFromTimeStamp(user.getUpdatedAt()) : 0;

    }
}
