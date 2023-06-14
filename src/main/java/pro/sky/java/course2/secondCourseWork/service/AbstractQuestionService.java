package pro.sky.java.course2.secondCourseWork.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.secondCourseWork.exception.IllegalQuestionException;
import pro.sky.java.course2.secondCourseWork.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public abstract class AbstractQuestionService implements QuestionService {

    private final Random random;

    private final QuestionRepository questionRepository;

    public AbstractQuestionService(@Qualifier("abstractQuestionRepository") QuestionRepository questionRepository) {
        this.random = new Random();
        this.questionRepository = questionRepository;
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
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> temp = getAll();
        int index = random.nextInt(temp.size());
        return new ArrayList<>(temp).get(index);
    }

}
