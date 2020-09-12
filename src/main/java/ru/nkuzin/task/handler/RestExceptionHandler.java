package ru.nkuzin.task.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<RestApiError> buildErrorResponse(
            AbstractRestHandleableException exc,
            ServletWebRequest webRequest
    ) {
        return new ResponseEntity<>(new RestApiError(exc, exc.getHttpStatus(), webRequest, exc.getErrorCodes()),
                exc.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestApiError> handleException(
            ServletWebRequest webRequest,
            Exception exc) {
        log.error("Exception: ", exc);
        return buildErrorResponse(ExceptionUtils.convertToAbstractRestHandleableException(exc), webRequest);
    }

    @ExceptionHandler(AbstractRestHandleableException.class)
    public ResponseEntity<RestApiError> handlePrintException(
            ServletWebRequest webRequest,
            AbstractRestHandleableException exc
    ) {
        log.error("Exception: ", exc);
        return buildErrorResponse(exc, webRequest);
    }
}
