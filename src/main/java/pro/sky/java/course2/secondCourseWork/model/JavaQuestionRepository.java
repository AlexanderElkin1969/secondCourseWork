package pro.sky.java.course2.secondCourseWork.model;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.secondCourseWork.exception.NotFoundQuestionException;
import pro.sky.java.course2.secondCourseWork.exception.QuestionAlreadyExistException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private static final List<Question> javaQuestions = new ArrayList<>(List.of(
            new Question("question_text_1", "answer_text_1"),
            new Question("question_text_2", "answer_text_2"),
            new Question("question_text_3", "answer_text_3"),
            new Question("question_text_4", "answer_text_4"),
            new Question("question_text_5", "answer_text_5")
    ));

    @Override
    public Question add(Question question) {
        if (javaQuestions.contains(question)) {
            throw new QuestionAlreadyExistException("Question Already Exist.");
        }
        javaQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!javaQuestions.contains(question)) {
            throw new NotFoundQuestionException("Question not found.");
        }
        javaQuestions.remove(question);
        return question;
    }

    public Question find(int index){
        return javaQuestions.get(index);
    }

    public int getSize(){
        return javaQuestions.size();
    }

    @Override
    public Collection<Question> getAll() {
        return List.copyOf(javaQuestions);
    }

}
