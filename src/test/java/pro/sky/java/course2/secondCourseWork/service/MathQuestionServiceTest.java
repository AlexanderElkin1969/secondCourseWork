package pro.sky.java.course2.secondCourseWork.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.secondCourseWork.exception.IllegalQuestionException;
import pro.sky.java.course2.secondCourseWork.model.MathQuestionRepository;
import pro.sky.java.course2.secondCourseWork.model.Question;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    private MathQuestionRepository mathQuestionRepository;

    @InjectMocks
    private MathQuestionService out;

    List<Question> testQuestions = new ArrayList<>(List.of(
            new Question("math_question_text_1", "answer_text_1"),
            new Question("math_question_text_2", "answer_text_2"),
            new Question("math_question_text_3", "answer_text_3"),
            new Question("math_question_text_4", "answer_text_4"),
            new Question("math_question_text_5", "answer_text_5")
    ));

    @Test
    void addTest() {
        Question temp = out.add("math_question_text_1", "answer_text_1");
        Assertions.assertTrue(temp.equals(testQuestions.get(0)));
        Assertions.assertThrows(IllegalQuestionException.class, () -> out.add("TEST_1", ""));
        Assertions.assertThrows(IllegalQuestionException.class, () -> out.add("TEST_2", null));
        Assertions.assertThrows(IllegalQuestionException.class, () -> out.add("", "TEST_3"));
        Assertions.assertThrows(IllegalQuestionException.class, () -> out.add(null, "TEST_4"));
    }

    @Test
    void addAndGetAllAndRemoveTest() {
        Question temp = testQuestions.get(4);
        Mockito.when(mathQuestionRepository.remove(temp)).thenReturn(temp);
        Assertions.assertEquals(temp, out.remove(temp));
        verify(mathQuestionRepository, times(1)).remove(temp);
        Mockito.when(mathQuestionRepository.add(temp)).thenReturn(temp);
        Assertions.assertEquals(temp, out.add(temp));
        verify(mathQuestionRepository, times(1)).add(temp);
        Mockito.when(mathQuestionRepository.getAll()).thenReturn(testQuestions);
        Assertions.assertArrayEquals(testQuestions.toArray(), out.getAll().toArray());
        verify(mathQuestionRepository, times(1)).getAll();
    }

}