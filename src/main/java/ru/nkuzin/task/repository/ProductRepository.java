package ru.nkuzin.task.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.nkuzin.task.model.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
