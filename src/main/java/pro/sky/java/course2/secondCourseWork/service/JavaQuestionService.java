package pro.sky.java.course2.secondCourseWork.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.secondCourseWork.exception.*;
import pro.sky.java.course2.secondCourseWork.model.JavaQuestionRepository;
import pro.sky.java.course2.secondCourseWork.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        if (StringUtils.isEmpty(question) || StringUtils.isEmpty(answer)) {
            throw new IllegalQuestionException("Question or answer should be not empty");
        }
        return new Question(question, answer);
    }

    @Override
    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(javaQuestionRepository.getSize());
        return javaQuestionRepository.find(index);
    }

}
