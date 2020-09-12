package ru.nkuzin.task.handler.exceptions;

import static java.util.Collections.singletonList;


import java.util.UUID;
import org.springframework.http.HttpStatus;
import ru.nkuzin.task.handler.AbstractRestHandleableException;
import ru.nkuzin.task.handler.TaskErrors;

public class ProductNotFoundException extends AbstractRestHandleableException {
    public ProductNotFoundException(UUID uuid) {
        super("Product with uuid " + uuid.toString() + " not found", singletonList(TaskErrors.PRODUCT_NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
