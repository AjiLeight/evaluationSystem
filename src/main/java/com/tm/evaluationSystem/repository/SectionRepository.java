package com.tm.evaluationSystem.repository;

import com.tm.evaluationSystem.model.Section;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SectionRepository extends MongoRepository<Section, String> {
}
