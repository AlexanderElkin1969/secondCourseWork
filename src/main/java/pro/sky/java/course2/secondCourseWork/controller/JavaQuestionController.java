package pro.sky.java.course2.secondCourseWork.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.secondCourseWork.model.Question;
import pro.sky.java.course2.secondCourseWork.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String hello() {
        return "<h1 style = \" color: red \">Добро пожаловать.</h1> " +
                "Вы можете добавить или удалить экзаменационные вопросы по Java (по Математике), используя команды: " +
                "/exam/java (math)/add?question=QuestionText&answer=QuestionAnswer или  " +
                "/exam/java (math)/remove?question=QuestionText&answer=QuestionAnswer  " +
                "для просмотра всех вопросов: /exam/java  (/exam/math)";
    }

    @GetMapping(path = "/java/add")
    private Question add(@RequestParam("question") String question,
                         @RequestParam("answer") String answer) {
        Question temp = javaQuestionService.add(question, answer);
        return javaQuestionService.add(temp);
    }

    @GetMapping(path = "/java/remove")
    private Question remove(@RequestParam("question") String question,
                            @RequestParam("answer") String answer) {
        Question temp = javaQuestionService.add(question, answer);
        return javaQuestionService.remove(temp);
    }

    @GetMapping(path = "/java")
    private Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String allMyException(RuntimeException e) {
        return e.getMessage();
    }

}
