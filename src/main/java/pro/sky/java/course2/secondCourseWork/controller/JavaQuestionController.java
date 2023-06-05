package pro.sky.java.course2.secondCourseWork.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.secondCourseWork.model.Question;
import pro.sky.java.course2.secondCourseWork.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping ("/exam")
public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/java/add")
    private Question add(@RequestParam("question") String question,
                         @RequestParam("answer") String answer){
        Question temp = javaQuestionService.add(question, answer);
        return javaQuestionService.add(temp);
    }

    @GetMapping(path = "/java/remove")
    private Question remove(@RequestParam("question") String question,
                         @RequestParam("answer") String answer){
        Question temp = javaQuestionService.add(question, answer);
        return javaQuestionService.remove(temp);
    }

    @GetMapping(path = "/java")
    private Collection<Question> getAll(){
        return javaQuestionService.getAll();
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String allMyException(RuntimeException e){
        return e.getMessage();
    }

}
