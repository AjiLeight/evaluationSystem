package com.tm.evaluationsystem.service;

import com.tm.evaluationsystem.dao.QuestionsDao;
import com.tm.evaluationsystem.dto.QuestionsRequestDTO;
import com.tm.evaluationsystem.dto.QuestionsResponseDTO;
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

    public List<QuestionsResponseDTO> findAllQuestions(){
        List<Question> questionsDBInfo = questionsRepository.findAll();
        return questionsDBInfo.stream()
                .map(QuestionMapper::mapQuestionsToQuestionsDTO)
                .toList();
    }


    public List<QuestionsResponseDTO> findAllQuestionsBySectionId(String sectionId) {
    List<Question> allQuestions = questionsDao.getAllQuestionsBySectionId(sectionId);
        if(allQuestions==null || allQuestions.isEmpty())
        {
            return new ArrayList<>();
        }
        return questionsDao.getAllQuestionsBySectionId(sectionId)
                .stream().map(QuestionMapper::mapQuestionsToQuestionsDTO)
                .toList();
    }

    public void createQuestionBySectionId(QuestionsRequestDTO requestDTO, String sectionId) throws SectionNotFoundException {
        Section section = mongoTemplate.findById(sectionId, Section.class);
        if(section!=null){
            Question question = mapQuestionsDTOToQuestions(requestDTO, sectionId);
            question.setId(generateQuestionId(section));
            if(section.getQuestions()==null) section.setQuestions(new ArrayList<>());
            section.getQuestions().add(question);
            mongoTemplate.save(section);
        }else {
            throw new SectionNotFoundException("no section with Id" + sectionId);
        }

    }

    private int generateQuestionId(Section section) {
        if(section.getQuestions()!=null)return section.getQuestions().size();
        return 0;
    }

    public QuestionsResponseDTO updateQuestionBySectionid(QuestionsRequestDTO requestDTO, String sectionId) {
        //TODO: logic
        return null;
    }

    public QuestionsResponseDTO deleteQuestionBySectionid(String sectionId, String questionId) {
        //TODO: logic
        return null;
    }
}
