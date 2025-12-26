package com.mindmarks.mindmarks.controller;


import com.mindmarks.mindmarks.entity.Collection;
import com.mindmarks.mindmarks.services.CollectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1/collections")
public class CollectionController {

    private final CollectionService collectionService;

    // Constructor Injection
    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    // Create a new collection
    @PostMapping
    public Collection createCollection(@RequestBody Collection collection) {
        return collectionService.saveCollection(collection);
    }

    // Get all collections
    @GetMapping
    public List<Collection> getAllCollections() {
        return collectionService.getAllCollections();
    }
}

