package ru.nkuzin.task.handler.exceptions;

import java.util.List;
import org.springframework.http.HttpStatus;
import ru.nkuzin.task.handler.AbstractRestHandleableException;
import ru.nkuzin.task.handler.TaskErrors;

public class CommonInternalException extends AbstractRestHandleableException {

    public CommonInternalException(List<TaskErrors> errorCodes) {
        this(errorCodes, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public CommonInternalException(String message, List<TaskErrors> errorCodes, HttpStatus httpStatus) {
        super(message, errorCodes, httpStatus);
    }

    public CommonInternalException(List<TaskErrors> errorCodes, HttpStatus httpStatus) {
        super(errorCodes, httpStatus);
    }

    public CommonInternalException(List<TaskErrors> errorCodes, Throwable throwable, HttpStatus httpStatus) {
        super(errorCodes, throwable, httpStatus);
    }
}
