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
@Entity("folders")
public class Folder extends BaseDocument {
    @Id
    private ObjectId id;
    private String folderLabel;
    private String slug;
    private int folderOrder;
    private ObjectId parentFolderId;
    private ObjectId rootFolderId;
    private boolean active;
    private int fileCnt;
    private String descp;
    private String breadCrumb;
    private int contentType;
}
