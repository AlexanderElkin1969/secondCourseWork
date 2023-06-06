package pro.sky.java.course2.secondCourseWork.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.secondCourseWork.model.Question;
import pro.sky.java.course2.secondCourseWork.exception.IllegalAmountException;
import pro.sky.java.course2.secondCourseWork.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount){
        return examinerService.getQuestions(amount);
    }

    @ExceptionHandler(IllegalAmountException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String getException(IllegalAmountException e){
        return e.getMessage();
    }

}
