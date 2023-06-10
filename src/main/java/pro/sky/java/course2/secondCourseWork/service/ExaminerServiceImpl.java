package pro.sky.java.course2.secondCourseWork.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.secondCourseWork.exception.IllegalAmountException;
import pro.sky.java.course2.secondCourseWork.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;

    private final MathQuestionService mathQuestionService;

    private final Random random;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
        this.random = new Random();
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<QuestionService> questionServices = List.of(javaQuestionService, mathQuestionService);
        int size = javaQuestionService.getAll().size() + mathQuestionService.getAll().size();
        if (amount <= 0 || amount > size) {
            throw new IllegalAmountException("Illegal amount.");
        }
        Set<Question> questionSet = new HashSet<>();
        while (questionSet.size() < amount) {
            questionSet.add(questionServices.get(random.nextInt(2)).getRandomQuestion());           // 2 число сервисов
        }
        return questionSet;
    }
}
