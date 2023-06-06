package pro.sky.java.course2.secondCourseWork.service;

import pro.sky.java.course2.secondCourseWork.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
