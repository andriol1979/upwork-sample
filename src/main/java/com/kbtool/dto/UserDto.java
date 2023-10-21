package com.kbtool.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private int userIdSeq;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String role;
    private String password;
    private String profilePhoto;
    private boolean active;
    private String companyId;
    private String group;
}
