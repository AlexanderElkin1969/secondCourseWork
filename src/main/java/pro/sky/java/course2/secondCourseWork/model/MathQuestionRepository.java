package pro.sky.java.course2.secondCourseWork.model;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.secondCourseWork.exception.NotFoundQuestionException;
import pro.sky.java.course2.secondCourseWork.exception.QuestionAlreadyExistException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class MathQuestionRepository  implements QuestionRepository{

    private static final List<Question> mathQuestions = new ArrayList<>(List.of(
            new Question("math_question_text_1", "answer_text_1"),
            new Question("math_question_text_2", "answer_text_2"),
            new Question("math_question_text_3", "answer_text_3"),
            new Question("math_question_text_4", "answer_text_4"),
            new Question("math_question_text_5", "answer_text_5")
    ));

    @Override
    public Question add(Question question) {
        if (mathQuestions.contains(question)) {
            throw new QuestionAlreadyExistException("Question Already Exist.");
        }
        mathQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!mathQuestions.contains(question)) {
            throw new NotFoundQuestionException("Question not found.");
        }
        mathQuestions.remove(question);
        return question;
    }

    public Question find(int index){
        return mathQuestions.get(index);
    }

    public int getSize(){
        return mathQuestions.size();
    }

    @Override
    public Collection<Question> getAll() {
        return List.copyOf(mathQuestions);
    }

}
