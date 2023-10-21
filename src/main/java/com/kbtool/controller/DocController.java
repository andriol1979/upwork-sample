package com.kbtool.controller;

import com.kbtool.entity.Doc;
import com.kbtool.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/docs")
public class DocController {
    @Autowired
    private DocService docService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Doc entity) {
        return new ResponseEntity<>(docService.create(entity), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findUserById(@PathVariable("id") String id) {
        return new ResponseEntity<>(docService.findById(id), HttpStatus.OK);
    }
}
