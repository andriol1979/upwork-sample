package com.kbtool.repository;

import org.bson.Document;

import java.util.Date;

public class DocumentBuilder {
    public static Document addInsertData(Document doc) {
        return doc.append("createdOn", new Date());
    }

    public static Document addUpdateData(Document doc) {
        return doc.append("updatedOn", new Date());
    }
}
