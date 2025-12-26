package com.mindmarks.mindmarks.repository;


import com.mindmarks.mindmarks.entity.Collection;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mindmarks.mindmarks.entity.User;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {

    List<Collection> findByUser(User user);
}

