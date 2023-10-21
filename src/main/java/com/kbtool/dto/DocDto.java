package com.kbtool.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class DocDto {
    private int docIdSeq;
    private String title;
    private String slug;
    private String docContent;
    private String status;
    private String visibility;
    private String searchKeywords;
    private boolean favourite;
    private String previewUrl;
    private String folderId;
    private int folderIdSeq;
    private boolean active;
    private Date publishStartDate;
    private Date publishEndDate;
}
