package com.tm.evaluationsystem.service;

import com.tm.evaluationsystem.dao.QuestionsDao;
import com.tm.evaluationsystem.dto.QuestionsDTO;
import com.tm.evaluationsystem.exception.SectionNotFoundException;
import com.tm.evaluationsystem.mappers.QuestionMapper;
import com.tm.evaluationsystem.model.Question;
import com.tm.evaluationsystem.model.Section;
import com.tm.evaluationsystem.repository.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.tm.evaluationsystem.mappers.QuestionMapper.*;

@Service
@RequiredArgsConstructor
public class QuestionsService {
    //    TODO:make this a interface-impl

    private final QuestionsRepository questionsRepository;
    private final QuestionsDao questionsDao;
    private final MongoTemplate mongoTemplate;

    public List<QuestionsDTO> findAllQuestions(){
        List<Question> questionsDBInfo = questionsRepository.findAll();
        return questionsDBInfo.stream()
                .map(QuestionMapper::mapQuestionsToQuestionsDTO)
                .toList();
    }


    public List<QuestionsDTO> findAllQuestionsBySectionId(String sectionId) {
    List<Question> allQuestions = questionsDao.getAllQuestionsBySectionId(sectionId);
        if(allQuestions==null || allQuestions.isEmpty())
        {
            return new ArrayList<>();
        }
        return questionsDao.getAllQuestionsBySectionId(sectionId)
                .stream().map(QuestionMapper::mapQuestionsToQuestionsDTO)
                .toList();
    }

    public void createQuestionBySectionId(QuestionsDTO questionsDTO, String sectionId) throws SectionNotFoundException {
        Section section = mongoTemplate.findById(sectionId, Section.class);
        if(section!=null){
            Question question = mapQuestionsDTOToQuestions(questionsDTO, sectionId);
            question.setId(generateQuestionId(sectionId));
            if(section.getQuestions()==null) section.setQuestions(new ArrayList<>());
            section.getQuestions().add(question);
            mongoTemplate.save(section);
        }else {
            throw new SectionNotFoundException("no section with Id" + sectionId);
        }

    }

    private int generateQuestionId(String sectionId) {
        Section section = mongoTemplate.findById(sectionId, Section.class);
        return section.getQuestions().size();
    }

    public QuestionsDTO updateQuestionBySectionid(QuestionsDTO questionsDTO, String sectionId) {
        //TODO: logic
        return null;
    }

    public QuestionsDTO deleteQuestionBySectionid(String sectionId, String questionId) {
        //TODO: logic
        return null;
    }
}
