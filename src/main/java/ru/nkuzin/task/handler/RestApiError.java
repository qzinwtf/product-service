package ru.nkuzin.task.handler;


import io.swagger.annotations.ApiModel;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.ServletWebRequest;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(
        value = "RestApiError",
        description = "An object that stores error information"
)
public class RestApiError {
    private Integer status;
    private HttpStatus error;
    private String path;
    private String message;
    private Date timestamp;
    private List<TaskErrors> errorCodes;

    public RestApiError(Exception exception, HttpStatus status, ServletWebRequest webRequest, List<TaskErrors> errorCodes) {
        this.status = status.value();
        this.error = status;
        this.message = exception.getMessage();
        this.timestamp = new Date();
        this.path = webRequest.getRequest().getRequestURI();
        this.errorCodes = errorCodes;
    }
}
