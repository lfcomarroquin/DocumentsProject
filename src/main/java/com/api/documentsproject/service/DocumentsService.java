package com.api.documentsproject.service;

import com.api.documentsproject.dto.DocumentsDto;
import com.api.documentsproject.entity.DocumentsEntity;
import com.api.documentsproject.repository.DocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentsService {

    @Autowired
    private DocumentsRepository documentRepository;

    public List<DocumentsDto> getAll() {
        return documentRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public DocumentsDto getById(String id) {
        return documentRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    public DocumentsDto save(DocumentsDto newDocument) {
        DocumentsEntity entity = new DocumentsEntity();
        entity.setTitle(newDocument.getTitle());
        entity.setAuthor(newDocument.getAuthor());
        entity.setDescription(newDocument.getDescription());
        DocumentsEntity documentsSaved = this.documentRepository.save(entity);
        DocumentsDto saved = this.toDto(documentsSaved);
        return saved;
    }

    public DocumentsDto update(DocumentsDto updatedDocument, String id) {
        DocumentsEntity entity = this.documentRepository.findById(id)
                .orElse(null);
        entity.setTitle(updatedDocument.getTitle());
        entity.setAuthor(updatedDocument.getAuthor());
        entity.setDescription(updatedDocument.getDescription());
        DocumentsEntity documentsUpdated = this.documentRepository.save(entity);
        DocumentsDto updated = this.toDto(documentsUpdated);
        return updated;
    }

    public void delete(String id) {
        DocumentsEntity entity = this.documentRepository.findById(id)
                .orElse(null);
        this.documentRepository.delete(entity);
    }

    private DocumentsDto toDto(DocumentsEntity entity) {
        return new DocumentsDto(entity.getDocumentId(), entity.getTitle(), entity.getAuthor(), entity.getDescription());
    }
}
