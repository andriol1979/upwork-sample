package com.kbtool.controller;

import com.kbtool.entity.Folder;
import com.kbtool.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/folders")
public class FolderController {
    @Autowired
    private FolderService folderService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createFolder(@RequestBody Folder entity) {
        return new ResponseEntity<>(folderService.create(entity), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findUserById(@PathVariable("id") String id) {
        return new ResponseEntity<>(folderService.findById(id), HttpStatus.OK);
    }
}
