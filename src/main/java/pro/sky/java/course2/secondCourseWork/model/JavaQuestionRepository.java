package pro.sky.java.course2.secondCourseWork.model;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class JavaQuestionRepository extends AbstractQuestionRepository {

    @PostConstruct
    public void init(){
        add( new Question("question_text_1", "answer_text_1"));
        add( new Question("question_text_2", "answer_text_2"));
        add( new Question("question_text_3", "answer_text_3"));
        add( new Question("question_text_4", "answer_text_4"));
        add( new Question("question_text_5", "answer_text_5"));
    }

}
