package ru.nkuzin.task.api.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;

    private Long price;
}
