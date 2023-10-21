package com.kbtool.service;

import com.kbtool.entity.Company;
import com.kbtool.repository.MongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private MongoRepository repository;

    public Company create(Company entity) {
        return repository.save(entity);
    }

    public Company findById(String id) {
        return repository.loadById(Company.class, id);
    }
}
