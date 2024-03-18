package com.tm.evaluationsystem.repository;

import com.tm.evaluationsystem.model.Section;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SectionRepository extends MongoRepository<Section, String> {
}
