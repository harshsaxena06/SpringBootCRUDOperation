package com.harsh.demo.service;

import com.harsh.demo.dto.ProductRequest;
import com.harsh.demo.dto.ProductResponse;
import com.harsh.demo.entity.Product;
import com.harsh.demo.exception.ProductNotFoundException;
import com.harsh.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //CREATE
    @Transactional
    public ProductResponse createProduct(ProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());

        Product saved = productRepository.save(product);
        return toResponse(saved);
    }

    //ReadById
    @Transactional(readOnly = true)
    public ProductResponse getProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()->
                        new ProductNotFoundException(id));

        return toResponse(product);
    }

    //READ ALL
    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }


    //UPDATE
    @Transactional
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException(id));

        product.setName(request.getName());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());

        Product updated = productRepository.save(product);
        return toResponse(updated);
    }

    //DELETE
    @Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException(id));

        productRepository.delete(product);
    }

    private ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getQuantity(),
                product.getPrice()
        );
    }
}