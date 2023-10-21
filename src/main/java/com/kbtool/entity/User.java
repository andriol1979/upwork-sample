package com.kbtool.entity;

import dev.morphia.annotations.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@NoArgsConstructor
@Entity("users")
public class User extends BaseDocument {
    @Id
    private ObjectId id;
    private int userIdSeq;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String role;
    private String password;
    private String profilePhoto;
    private boolean active;
    private ObjectId companyId;
    private String group;
}
