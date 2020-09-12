package ru.nkuzin.task.service;

import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.nkuzin.task.model.Product;

public interface ProductService {
    Product save(Product product);

    void delete(UUID id);

    Product update(UUID id, String name, Long price);

    Product get(UUID id);

    Page<Product> getAll(Pageable pageable);
}
