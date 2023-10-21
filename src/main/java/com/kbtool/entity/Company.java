package com.kbtool.entity;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@NoArgsConstructor
@Entity("companies")
public class Company extends BaseDocument {
    @Id
    private ObjectId id;
    private int companyIdSeq;
    private String name;
    private String address;
    private String phone;
    private String website;
    private boolean active;
    private ObjectId rootFolderId;
}
