package com.api.documentsproject.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DocumentsEntity {
    private String documentId;
    private String title;
    private String author;
    private String description;

    public DocumentsEntity(String documentId, String title, String author, String description) {
        this.documentId = documentId;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public DocumentsEntity() {

    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}