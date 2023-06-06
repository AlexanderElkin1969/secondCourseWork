package pro.sky.java.course2.secondCourseWork.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.secondCourseWork.exception.IllegalQuestionException;
import pro.sky.java.course2.secondCourseWork.exception.NotFoundQuestionException;
import pro.sky.java.course2.secondCourseWork.exception.QuestionAlreadyExistException;
import pro.sky.java.course2.secondCourseWork.model.Question;

import java.util.ArrayList;
import java.util.List;

class JavaQuestionServiceTest {

    private final JavaQuestionService out = new JavaQuestionService();

    List<Question> testQuestions = new ArrayList<>(List.of(
            new Question("question_text_1", "answer_text_1"),
            new Question("question_text_2", "answer_text_2"),
            new Question("question_text_3", "answer_text_3"),
            new Question("question_text_4", "answer_text_4"),
            new Question("question_text_5", "answer_text_5"),
            new Question("TEST_question_text_6", "TEST_answer_text_6")
    ));

    @Test
    void addTest() {
        Question temp = out.add("question_text_1", "answer_text_1");
        Assertions.assertTrue(temp.equals(testQuestions.get(0)));
        Assertions.assertThrows(IllegalQuestionException.class, () -> out.add("TEST_1", ""));
        Assertions.assertThrows(IllegalQuestionException.class, () -> out.add("TEST_2", null));
        Assertions.assertThrows(IllegalQuestionException.class, () -> out.add("", "TEST_3"));
        Assertions.assertThrows(IllegalQuestionException.class, () -> out.add(null, "TEST_4"));
    }

    @Test
    void addAndGetAllAndRemoveTest() {
        Question temp = out.add("TEST_question_text_6", "TEST_answer_text_6");
        Assertions.assertTrue(temp.equals(out.add(temp)));
        Assertions.assertArrayEquals(testQuestions.toArray(), out.getAll().toArray());
        Assertions.assertThrows(QuestionAlreadyExistException.class, () -> out.add(temp));
        Assertions.assertTrue(temp.equals(out.remove(temp)));
        Assertions.assertThrows(NotFoundQuestionException.class, () -> out.remove(temp));
    }

}