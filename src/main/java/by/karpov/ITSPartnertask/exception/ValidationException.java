package by.karpov.ITSPartnertask.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ValidationException extends Exception {

    private String message;

    public ValidationException(String message) {
        this.message = System.currentTimeMillis() + ": " + message;
    }
}
