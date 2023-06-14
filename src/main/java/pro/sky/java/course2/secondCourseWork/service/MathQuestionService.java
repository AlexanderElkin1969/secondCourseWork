package pro.sky.java.course2.secondCourseWork.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.secondCourseWork.model.QuestionRepository;


@Service
public class MathQuestionService extends AbstractQuestionService {

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
        super(questionRepository);
    }

}
