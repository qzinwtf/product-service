package ru.nkuzin.task.handler;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class AbstractRestHandleableException extends RuntimeException implements HttpStatusCodeContainer {
    private static final long serialVersionUID = -3416823984750319182L;

    private final HttpStatus httpStatus;
    private final List<TaskErrors> errorCodes;

    public AbstractRestHandleableException(String message, List<TaskErrors> errorCodes, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorCodes = errorCodes;
    }

    public AbstractRestHandleableException(List<TaskErrors> errorCodes, HttpStatus httpStatus) {
        this(String.valueOf(errorCodes.stream().map(TaskErrors::getMessage).collect(Collectors.toList())), errorCodes, httpStatus);
    }

    public AbstractRestHandleableException(List<TaskErrors> errorCodes, Throwable throwable, HttpStatus httpStatus) {
        super(String.valueOf(errorCodes.stream().map(TaskErrors::getMessage).collect(Collectors.toList())), throwable);
        this.httpStatus = httpStatus;
        this.errorCodes = errorCodes;
    }
}
