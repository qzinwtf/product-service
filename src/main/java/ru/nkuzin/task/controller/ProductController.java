package ru.nkuzin.task.controller;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;
import ru.nkuzin.task.api.ProductApi;
import ru.nkuzin.task.api.dto.ProductDto;
import ru.nkuzin.task.api.dto.ProductRequest;
import ru.nkuzin.task.model.Product;
import ru.nkuzin.task.service.ProductService;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @Override
    public UUID create(final ProductRequest request) {
        final Product product = modelMapper.map(request, Product.class);
        return productService.save(product).getId();
    }

    @Override
    public ProductDto update(final UUID productId, final ProductRequest request) {
        final Product updated = productService.update(productId, request.getName(), request.getPrice());
        return modelMapper.map(updated, ProductDto.class);
    }

    @Override
    public ProductDto get(final UUID productId) {
        final Product product = productService
                .get(productId);
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public Page<ProductDto> getAll(Pageable pageable) {
        return productService
                .getAll(pageable)
                .map(item -> modelMapper.map(item, ProductDto.class));
    }

    @Override
    public void delete(final UUID productId) {
        productService.delete(productId);
    }
}
