package com.api.documentsproject.controller;

import com.api.documentsproject.dto.DocumentsDto;
import com.api.documentsproject.service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DocumentsProject")
public class DocumentsController {
    @Autowired
    private DocumentsService documentsService;

    @GetMapping("/")
    public ResponseEntity<List<DocumentsDto>> findAllDocuments() {
        List<DocumentsDto> listDocuments = documentsService.getAll();
        return ResponseEntity.ok(listDocuments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentsDto> findById(@PathVariable ("id") String id) {
        DocumentsDto document = documentsService.getById(id);
        return ResponseEntity.ok(document);
    }

    @PostMapping("/")
    public ResponseEntity<DocumentsDto> createDocument(@RequestBody DocumentsDto documentDto) {
        DocumentsDto savedDocument = this.documentsService.save(documentDto);
        return ResponseEntity.ok(savedDocument);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentsDto> updateDocument(@RequestBody  DocumentsDto documentDto, @PathVariable ("id") String id) {
        DocumentsDto updatedDocument = this.documentsService.update(documentDto, id);
        return ResponseEntity.ok(updatedDocument);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable ("id") String id) {
        this.documentsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}