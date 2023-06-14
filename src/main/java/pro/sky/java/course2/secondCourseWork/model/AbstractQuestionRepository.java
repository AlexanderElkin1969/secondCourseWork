package pro.sky.java.course2.secondCourseWork.model;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.secondCourseWork.exception.NotFoundQuestionException;
import pro.sky.java.course2.secondCourseWork.exception.QuestionAlreadyExistException;

import java.util.*;

@Repository
public abstract class AbstractQuestionRepository implements QuestionRepository {

    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExistException("Question Already Exist.");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new NotFoundQuestionException("Question not found.");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

}
