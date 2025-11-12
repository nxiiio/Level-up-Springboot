package cl.duoc.worellana.levelup.service.impl;

import cl.duoc.worellana.levelup.model.Product;
import cl.duoc.worellana.levelup.repository.ProductRepository;
import cl.duoc.worellana.levelup.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product create(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> update(Long id, Product product) {
        return productRepository.findById(id).map(existing -> {
            existing.setName(product.getName());
            existing.setShortDescription(product.getShortDescription());
            existing.setDescription(product.getDescription());
            existing.setPrice(product.getPrice());
            existing.setStock(product.getStock());
            return productRepository.save(existing);
        });
    }

    @Override
    public Optional<Product> delete(Long id) {
        return productRepository.findById(id).map(existing -> {
            productRepository.delete(existing);
            return existing;
        });
    }
}

