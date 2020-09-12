package ru.nkuzin.task.api;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.nkuzin.task.api.dto.ProductDto;
import ru.nkuzin.task.api.dto.ProductRequest;
import springfox.documentation.annotations.ApiIgnore;

public interface ProductApi {

    @ApiOperation(value = "Create")
    @PostMapping("/product/")
    UUID create(@ApiParam(value = "Product info", required = true) @RequestBody ProductRequest request);

    @ApiOperation(value = "Update")
    @PutMapping("/product/{productId}")
    ProductDto update(@ApiParam(value = "Product Id", required = true) @PathVariable("productId") UUID productId,
                @ApiParam(value = "Product info") @RequestBody ProductRequest productRequest);

    @GetMapping("/product/{productId}")
    @ApiOperation(value = "Get single product")
    ProductDto get(@ApiParam(value = "Product Id") @PathVariable("productId") UUID productId);

    @GetMapping("/product/")
    @ApiOperation(value = "Get all products")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "int", paramType = "query",
                    value = "Results page you want to retrieve (0..N)", defaultValue = "0"),
            @ApiImplicitParam(name = "size", dataType = "int", paramType = "query",
                    value = "Number of records per page.", defaultValue = "5"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). "
                            +
                            "Default sort order is ascending. "
                            +
                            "Multiple sort criteria are supported.")
    })
    Page<ProductDto> getAll(@ApiIgnore Pageable pageable);

    @DeleteMapping("/product/{productId}")
    @ApiOperation(value = "Delete single product")
    void delete(@ApiParam("Product Id") @PathVariable("productId") UUID productId);
}
