package com.kbtool.entity;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity("docs")
public class Doc extends BaseDocument {
    @Id
    private ObjectId id;
    private int docIdSeq;
    private String title;
    private String slug;
    private String docContent;
    private String status;
    private String visibility;
    private String searchKeywords;
    private boolean favourite;
    private String previewUrl;
    private ObjectId folderId;
    private int folderIdSeq;
    private boolean active;
    private Date publishStartDate;
    private Date publishEndDate;
}
