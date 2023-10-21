package com.kbtool.service;

import com.kbtool.entity.Folder;
import com.kbtool.repository.MongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FolderService {
    @Autowired
    private MongoRepository repository;

    public Folder create(Folder entity) {
        return repository.save(entity);
    }

    public Folder findById(String id) {
        return repository.loadById(Folder.class, id);
    }
}
