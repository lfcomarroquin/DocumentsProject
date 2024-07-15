package com.api.documentsproject.repository;

import com.api.documentsproject.entity.DocumentsEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsRepository extends MongoRepository<DocumentsEntity, String> {
}