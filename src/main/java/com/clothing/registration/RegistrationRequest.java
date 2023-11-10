package com.clothing.registration;

import com.clothing.entity.User;
import lombok.*;

@Data
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class RegistrationRequest {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private Integer status;

    public RegistrationRequest(String email, String password, String firstName, String lastName, String address, String phone, Integer status) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.status = status;
    }

    public void loadFromUser(User user){
        this.id = user.getUserId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.address = user.getAddress();
        this.phone = user.getPhone();
        this.status = user.getStatus();
    }

    public User toUserEntity(){
        User user = new User();
        user.setEmail(this.email);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setAddress(this.address);
        user.setPhone(this.phone);
        user.setStatus(this.status);
        return user;
    }

}
