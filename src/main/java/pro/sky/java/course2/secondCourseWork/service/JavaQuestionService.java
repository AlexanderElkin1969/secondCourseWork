package pro.sky.java.course2.secondCourseWork.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.secondCourseWork.model.*;

@Service
public class JavaQuestionService extends AbstractQuestionService {

    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
        super(questionRepository);
    }

}
