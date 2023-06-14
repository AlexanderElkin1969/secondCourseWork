package pro.sky.java.course2.secondCourseWork.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.secondCourseWork.exception.IllegalQuestionException;
import pro.sky.java.course2.secondCourseWork.model.JavaQuestionRepository;
import pro.sky.java.course2.secondCourseWork.model.Question;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
/*
    @Mock
    private  JavaQuestionRepository javaQuestionRepository;

    @InjectMocks
    private JavaQuestionService out;

    List<Question> testQuestions = new ArrayList<>(List.of(
            new Question("question_text_1", "answer_text_1"),
            new Question("question_text_2", "answer_text_2"),
            new Question("question_text_3", "answer_text_3"),
            new Question("question_text_4", "answer_text_4"),
            new Question("question_text_5", "answer_text_5")
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
        Question temp = testQuestions.get(4);
        Mockito.when(javaQuestionRepository.remove(temp)).thenReturn(temp);
        Assertions.assertEquals(temp, out.remove(temp));
        verify(javaQuestionRepository, times(1)).remove(temp);
        Mockito.when(javaQuestionRepository.add(temp)).thenReturn(temp);
        Assertions.assertEquals(temp, out.add(temp));
        verify(javaQuestionRepository, times(1)).add(temp);
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(testQuestions);
        Assertions.assertArrayEquals(testQuestions.toArray(), out.getAll().toArray());
        verify(javaQuestionRepository, times(1)).getAll();
    }
*/
}