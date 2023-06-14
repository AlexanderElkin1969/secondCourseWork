package pro.sky.java.course2.secondCourseWork.model;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class MathQuestionRepository  extends AbstractQuestionRepository{

    @PostConstruct
    public void init(){
        add( new Question("math_question_1", "answer_1"));
        add( new Question("math_question_2", "answer_2"));
        add( new Question("math_question_3", "answer_3"));
        add( new Question("math_question_4", "answer_4"));
        add( new Question("math_question_5", "answer_5"));
    }

}
