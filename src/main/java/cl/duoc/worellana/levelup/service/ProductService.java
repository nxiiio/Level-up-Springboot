package cl.duoc.worellana.levelup.service;

import cl.duoc.worellana.levelup.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product create(Product product);
    Optional<Product> update(Long id, Product product);
    Optional<Product> delete(Long id);
}
