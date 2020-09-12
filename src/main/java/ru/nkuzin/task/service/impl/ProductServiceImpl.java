package ru.nkuzin.task.service.impl;

import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import ru.nkuzin.task.handler.exceptions.ProductNotFoundException;
import ru.nkuzin.task.model.Product;
import ru.nkuzin.task.repository.ProductRepository;
import ru.nkuzin.task.service.ProductService;

@Component
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public Product save(final Product product) {
        product.setCreateDateTime(ZonedDateTime.now());
        return repository.save(product);
    }

    @Override
    public void delete(final UUID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        throw new ProductNotFoundException(id);
    }

    @Override
    public Product update(final UUID id, final String name, final Long price) {
        return repository.findById(id).map(item -> {
            item.setName(name);
            item.setPrice(price);
            return repository.save(item);
        }).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Product get(final UUID id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
