package com.kbtool.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FolderDto {
    private String folderLabel;
    private String slug;
    private int folderOrder;
    private String parentFolderId;
    private String rootFolderId;
    private boolean active;
    private int fileCnt;
    private String descp;
    private String breadCrumb;
    private int contentType;
}
