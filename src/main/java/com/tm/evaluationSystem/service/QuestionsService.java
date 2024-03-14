package com.tm.evaluationSystem.service;

import com.tm.evaluationSystem.dao.QuestionsDao;
import com.tm.evaluationSystem.dto.AnswerOptionsDTO;
import com.tm.evaluationSystem.dto.QuestionsDTO;
import com.tm.evaluationSystem.exception.SectionNotFoundException;
import com.tm.evaluationSystem.mappers.QuestionMapper;
import com.tm.evaluationSystem.model.Question;
import com.tm.evaluationSystem.model.Section;
import com.tm.evaluationSystem.repository.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.tm.evaluationSystem.mappers.QuestionMapper.*;

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
            Question question = mapQuestionsDTOToQuestions(questionsDTO);
            section.getQuestions().add(question);
            mongoTemplate.save(section);
        }else {
            throw new SectionNotFoundException("no section with Id" + sectionId);
        }

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
