package pro.sky.java.course2.secondCourseWork.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NotFoundQuestionException extends RuntimeException {

    public NotFoundQuestionException() {
    }

    public NotFoundQuestionException(String message) {
        super(message);
    }
}
