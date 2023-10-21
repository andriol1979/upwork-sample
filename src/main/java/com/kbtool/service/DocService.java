package com.kbtool.service;

import com.kbtool.entity.Doc;
import com.kbtool.repository.MongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocService {
    @Autowired
    private MongoRepository repository;

    public Doc create(Doc entity) {
        return repository.save(entity);
    }

    public Doc findById(String id) {
        return repository.loadById(Doc.class, id);
    }
}
