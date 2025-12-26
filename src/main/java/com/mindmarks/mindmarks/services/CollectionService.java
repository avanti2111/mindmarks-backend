package com.mindmarks.mindmarks.services;


import com.mindmarks.mindmarks.entity.Collection;
import com.mindmarks.mindmarks.repository.CollectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {

    private final CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public Collection saveCollection(Collection collection) {
        return collectionRepository.save(collection);
    }

    public List<Collection> getAllCollections() {
        return collectionRepository.findAll();
    }

    public Collection getCollectionById(Long id) {
        return collectionRepository.findById(id).orElse(null);
    }

    public void deleteCollection(Long id) {
        collectionRepository.deleteById(id);
    }
}
