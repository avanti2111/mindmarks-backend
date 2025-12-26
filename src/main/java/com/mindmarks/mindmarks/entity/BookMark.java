package com.mindmarks.mindmarks.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity              // tells Spring: this is a DB table
@Table(name = "bookmarks")
public class BookMark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(nullable = false)
    private String url;

    @Column(length = 2000)
    private String notes;

    @ManyToOne
    @JoinColumn(name = "collection_id", nullable = true)
    private Collection collection;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDateTime createdAt = LocalDateTime.now();

    // getters & setters
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;   
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url; 
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getNotes() {
        return notes; 
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public Collection getCollection() {
        return collection; 
    }
    public void setCollection(Collection collection) {
        this.collection = collection;
    }
    public User getUser() {
        return user; 
    }
    public void setUser(User user) {
        this.user = user;
    }               

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}