package pro.sky.java.course2.secondCourseWork.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.secondCourseWork.exception.NotFoundQuestionException;
import pro.sky.java.course2.secondCourseWork.exception.QuestionAlreadyExistException;

import java.util.ArrayList;
import java.util.List;

class MathQuestionRepositoryTest {
/*
    private final MathQuestionRepository out = new MathQuestionRepository();

    List<Question> testQuestions = new ArrayList<>(List.of(
            new Question("math_question_text_1", "answer_text_1"),
            new Question("math_question_text_2", "answer_text_2"),
            new Question("math_question_text_3", "answer_text_3"),
            new Question("math_question_text_4", "answer_text_4"),
            new Question("math_question_text_5", "answer_text_5"),
            new Question("TEST_question_text_6", "TEST_answer_text_6")
    ));

    @Test
    void addAndGetAllAndRemove() {
        Question temp = new Question ("TEST_question_text_6", "TEST_answer_text_6");
        Assertions.assertEquals(5, out.getAll().size());
        Assertions.assertTrue(temp.equals(out.add(temp)));
        Assertions.assertEquals(6,  out.getAll().size());
        Assertions.assertThrows(QuestionAlreadyExistException.class, () -> out.add(temp));
        Assertions.assertTrue(temp.equals(out.remove(temp)));
        Assertions.assertEquals(5,  out.getAll().size());
        Assertions.assertThrows(NotFoundQuestionException.class, () -> out.remove(temp));
    }

*/
}