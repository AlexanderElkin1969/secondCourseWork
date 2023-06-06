package pro.sky.java.course2.secondCourseWork.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.secondCourseWork.exception.IllegalAmountException;
import pro.sky.java.course2.secondCourseWork.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService javaQuestionService) {
        this.questionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = questionService.getAll().size();
        if (amount <= 0 || amount > size) {
            throw new IllegalAmountException("Illegal amount.");
        }
        if (amount == size) {
            return questionService.getAll();
        }
        int i = 0;
        Set<Question> questionSet = new HashSet<>();
        while (i < amount) {
            questionSet.add(questionService.getRandomQuestion());
            i = questionSet.size();
        }
        return questionSet;
    }
}
