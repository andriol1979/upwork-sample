package com.kbtool.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BaseDocument implements Serializable {
    protected Date createdOn;
    protected Date updatedOn;
    protected ObjectId createdBy;
    protected ObjectId updatedBy;

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
