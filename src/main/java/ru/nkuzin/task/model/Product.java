package ru.nkuzin.task.model;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    /**
     * Price in minor units
     */
    private Long price;

    private ZonedDateTime createDateTime;
}
