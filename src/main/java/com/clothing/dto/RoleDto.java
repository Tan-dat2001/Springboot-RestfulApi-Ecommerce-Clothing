package com.clothing.dto;

import com.clothing.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private Long id;
    private String name;

    public RoleDto(Role role){
        this.id = role.getRoleId();
        this.name = role.getRoleName();
    }

    public Role toEntity(){
        return new Role(this.getId(), this.getName(), null);
    }
}
