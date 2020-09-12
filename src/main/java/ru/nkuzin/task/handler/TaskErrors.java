package ru.nkuzin.task.handler;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@ApiModel(
        value = "TaskErrors",
        description = "Enumeration of error codes")
@Getter
@RequiredArgsConstructor
public enum TaskErrors {

    @ApiModelProperty("Internal error")
    INTERNAL("Internal error"),

    @ApiModelProperty("Product not found")
    PRODUCT_NOT_FOUND("Product not found");

    private final String message;
}
