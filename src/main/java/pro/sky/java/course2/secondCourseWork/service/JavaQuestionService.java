package pro.sky.java.course2.secondCourseWork.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.secondCourseWork.exception.*;
import pro.sky.java.course2.secondCourseWork.model.Question;

import java.util.*;

@Service
public class JavaQuestionService  implements QuestionService{

    private static final List<Question> javaQuestions =  new ArrayList<>(List.of(
            new Question("question_text_1", "answer_text_1"),
            new Question("question_text_2", "answer_text_2"),
            new Question("question_text_3", "answer_text_3"),
            new Question("question_text_4", "answer_text_4"),
            new Question("question_text_5", "answer_text_5")
    ));

    @Override
    public Question add(String question, String answer) {
        if (StringUtils.isEmpty(question)||StringUtils.isEmpty(answer)){
            throw new IllegalQuestionException("Question or answer should be not empty");
        }
        return new Question(question, answer);
    }

    @Override
    public Question add(Question question) {
        if (javaQuestions.contains(question)){
            throw new QuestionAlreadyExistException("Question Already Exist.");
        }
        javaQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!javaQuestions.contains(question)){
            throw new NotFoundQuestionException("Question not found.");
        }
        javaQuestions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return  List.copyOf(javaQuestions);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt (javaQuestions.size());
        return javaQuestions.get(index);
    }
}
