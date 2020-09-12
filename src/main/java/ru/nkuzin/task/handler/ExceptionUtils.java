package ru.nkuzin.task.handler;


import static java.util.Collections.singletonList;
import static org.apache.commons.lang3.exception.ExceptionUtils.throwableOfType;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static ru.nkuzin.task.handler.TaskErrors.INTERNAL;


import lombok.experimental.UtilityClass;
import ru.nkuzin.task.handler.exceptions.CommonInternalException;

@UtilityClass
public class ExceptionUtils {

    /**
     * Returns an abstract rest handleable exception or common internal exception.
     */
    public static AbstractRestHandleableException convertToAbstractRestHandleableException(Exception ex) {
        AbstractRestHandleableException abstractRestHandleableException =
                throwableOfType(ex, AbstractRestHandleableException.class);
        if (abstractRestHandleableException == null) {
            return new CommonInternalException(singletonList(INTERNAL), ex, INTERNAL_SERVER_ERROR);
        }
        return abstractRestHandleableException;
    }
}
