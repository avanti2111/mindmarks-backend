package com.mindmarks.mindmarks.dto;

public class BookMarkResponse {
    public Long id;
    public String title;
    public String url;
    public String notes;
    public Long collectionId;

    public BookMarkResponse(Long id, String title, String url, String notes, Long collectionId) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.notes = notes;
        this.collectionId = collectionId;
    }

    public Long setId() {
        return id;
    }
    public String setTitle() {
        return title;   
    }
    public String setUrl() {
        return url; 
    }
    public String setNotes() {
        return notes;   
    }
    public Long setCollectionId() {
        return collectionId;   
    }

    
}