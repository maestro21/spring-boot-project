package ru.geekbrains.boot.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.boot.model.Product;
import lombok.RequiredArgsConstructor;
import ru.geekbrains.boot.repositories.ProductRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @PostConstruct
    public void init() {
        create("Пиво", 0.7);
        create("Шашлык", 5.5);
        create("Джинсы", 99.9);
        create("Iphone", 999.9);
        create("Машина", 19999.9);

    }

    public boolean del(Long id) {
        return this.productRepository.remove(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product create(String title, Double cost) {
        return productRepository.save(new Product(title, cost));
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Product find(Long id) {
        return productRepository.get(id);
    }

    public Product createEmptyProduct() {
        return new Product();
    }

}
