package com.codeclan.example.filofax.controllers;

import com.codeclan.example.filofax.models.File;
import com.codeclan.example.filofax.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepository;

    //GET ALL
    @GetMapping(value = "/files")
    public ResponseEntity <List<File>> getAllFiles(){
        return  new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    //GET ONE
    @GetMapping(value = "/files/{id}")
    public ResponseEntity getFile(@PathVariable Long id){
        return new ResponseEntity(fileRepository.findById(id), HttpStatus.OK);
    }

    //CREATE ONE
    @PostMapping(value = "/files")
    public ResponseEntity<File> postFile(@RequestBody File file) {
        fileRepository.save(file);
        return new ResponseEntity(file, HttpStatus.CREATED);
    }
}
