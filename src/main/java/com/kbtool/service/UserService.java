package com.kbtool.service;

import com.kbtool.dto.UserDto;
import com.kbtool.entity.User;
import com.kbtool.repository.MongoRepository;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private MongoRepository repository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    public User create(UserDto dto) {
        User entity = modelMapper.map(dto, User.class);
        if(StringUtils.isNotBlank(dto.getPassword())) {
            String encryptedPassword = passwordEncoder.encode(dto.getPassword());
            entity.setPassword(encryptedPassword);
        }

        return repository.save(entity);
    }

    public User findById(String id) {
        return repository.loadById(User.class, id);
    }

    public List findAll() {
        return repository.loadAll(User.class);
    }
}
