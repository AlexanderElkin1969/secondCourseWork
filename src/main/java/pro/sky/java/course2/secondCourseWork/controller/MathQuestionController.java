package pro.sky.java.course2.secondCourseWork.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.secondCourseWork.model.Question;
import pro.sky.java.course2.secondCourseWork.service.MathQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/")
public class MathQuestionController {

    private final MathQuestionService mathQuestionService;

    public MathQuestionController(MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String hello() {
        return "<h1 style = \" color: red \">Добро пожаловать.</h1> " +
                "Вы можете добавить или удалить экзаменационные вопросы по Java (по Математике), используя команды: " +
                "/exam/java (math)/add?question=QuestionText&answer=QuestionAnswer или  " +
                "/exam/java (math)/remove?question=QuestionText&answer=QuestionAnswer  " +
                "для просмотра всех вопросов: /exam/java  (/exam/math)";
    }

    @GetMapping(path = "math/add")
    private Question add(@RequestParam("question") String question,
                         @RequestParam("answer") String answer) {
        Question temp = mathQuestionService.add(question, answer);
        return mathQuestionService.add(temp);
    }

    @GetMapping(path = "math/remove")
    private Question remove(@RequestParam("question") String question,
                            @RequestParam("answer") String answer) {
        Question temp = mathQuestionService.add(question, answer);
        return mathQuestionService.remove(temp);
    }

    @GetMapping(path = "math")
    private Collection<Question> getAll() {
        return mathQuestionService.getAll();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String allMyException(RuntimeException e) {
        return e.getMessage();
    }

}
