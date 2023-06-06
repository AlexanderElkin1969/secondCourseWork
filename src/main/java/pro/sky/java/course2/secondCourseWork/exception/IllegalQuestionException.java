package pro.sky.java.course2.secondCourseWork.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IllegalQuestionException extends RuntimeException {

    public IllegalQuestionException() {
    }

    public IllegalQuestionException(String message) {
        super(message);
    }
}
