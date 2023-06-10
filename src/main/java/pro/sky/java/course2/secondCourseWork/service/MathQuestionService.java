package pro.sky.java.course2.secondCourseWork.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.secondCourseWork.exception.IllegalQuestionException;
import pro.sky.java.course2.secondCourseWork.model.MathQuestionRepository;
import pro.sky.java.course2.secondCourseWork.model.Question;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final MathQuestionRepository mathQuestionRepository;

    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
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
        return mathQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(mathQuestionRepository.getSize());
        return mathQuestionRepository.find(index);
    }

}
