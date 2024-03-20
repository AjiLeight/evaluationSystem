package com.tm.evaluationsystem.mappers;

import com.tm.evaluationsystem.dto.AnswerOptionsResponseDTO;
import com.tm.evaluationsystem.dto.QuestionsRequestDTO;
import com.tm.evaluationsystem.dto.QuestionsResponseDTO;
import com.tm.evaluationsystem.model.Answer;
import com.tm.evaluationsystem.model.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionMapper {

    public static QuestionsResponseDTO mapQuestionsToQuestionsDTO(Question question){
        List<AnswerOptionsResponseDTO> answers = question.getAnswerOptions()
                .stream()
                .map( answer -> AnswerOptionsResponseDTO.builder()
                        .answer(answer.getAnswer())
                        .id(answer.getId())
                        .build()
                ).toList();
        return QuestionsResponseDTO.builder()
                .id(question.getId())
                .question(question.getQuestion())
                .answerOptions(answers)
                .build();
    }

    public static Question mapQuestionsDTOToQuestions(QuestionsRequestDTO question, String sectionid){
        IntegerHolder answerId = new IntegerHolder(0);
        List<Answer> answers = question.getAnswerOptions()
                .stream()
                .map( answer -> Answer.builder()
                        .answer(answer.getAnswer())
                        .id(generateAnswerId(answerId))
                        .isRight(answer.getIsRight())
                        .build()
                ).toList();
        return Question.builder()
                .question(question.getQuestion())
                .answerOptions(answers)
                .build();
    }


    private static int generateAnswerId(IntegerHolder answerId) {
        answerId.setId(answerId.getId()+1);
        return answerId.getId();
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class IntegerHolder{
    private int id;
}
