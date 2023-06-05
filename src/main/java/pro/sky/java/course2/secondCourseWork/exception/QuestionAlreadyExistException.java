package pro.sky.java.course2.secondCourseWork.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class QuestionAlreadyExistException extends RuntimeException {

    public QuestionAlreadyExistException() {
    }

    public QuestionAlreadyExistException(String message) {
        super(message);
    }
}
