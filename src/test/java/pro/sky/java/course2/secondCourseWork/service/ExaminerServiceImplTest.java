package pro.sky.java.course2.secondCourseWork.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.secondCourseWork.exception.IllegalAmountException;
import pro.sky.java.course2.secondCourseWork.model.Question;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
/*
    @Mock
    private JavaQuestionService javaQuestionService;

    @Mock
    private MathQuestionService mathQuestionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    List<Question> testQuestions = new ArrayList<>(List.of(
            new Question("question_text_1", "answer_text_1"),
            new Question("question_text_2", "answer_text_2"),
            new Question("question_text_3", "answer_text_3"),
            new Question("question_text_4", "answer_text_4"),
            new Question("question_text_5", "answer_text_5")
    ));

    @Test
    void getQuestionsShouldThrow() {
        when(javaQuestionService.getAll()).thenReturn(testQuestions);
        Assertions.assertThrows(IllegalAmountException.class, () -> out.getQuestions(0));
        Assertions.assertThrows(IllegalAmountException.class, () -> out.getQuestions(6));
        verify(javaQuestionService, times(2)).getAll();
    }
/*
    @Test
    void getQuestionsShouldReturnList() {
        when(javaQuestionService.getAll()).thenReturn(testQuestions);
        Assertions.assertTrue(out.getQuestions(5).equals(testQuestions));
        verify(javaQuestionService, times(2)).getAll();
    }

    @Test
    void getQuestionsShouldReturnSet() {
        when(javaQuestionService.getAll()).thenReturn(testQuestions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(testQuestions.get(4)).
                thenReturn(testQuestions.get(0)).thenReturn(testQuestions.get(4)).thenReturn(testQuestions.get(1)).
                thenReturn(testQuestions.get(0)).thenReturn(testQuestions.get(4)).thenReturn(testQuestions.get(2));
        Assertions.assertTrue(out.getQuestions(1).size() == 1);
        verify(javaQuestionService, times(1)).getAll();
        verify(javaQuestionService, times(1)).getRandomQuestion();
        Assertions.assertTrue(out.getQuestions(4).size() == 4);
        verify(javaQuestionService, times(2)).getAll();
        verify(javaQuestionService, times(7)).getRandomQuestion();
    }
*/
}