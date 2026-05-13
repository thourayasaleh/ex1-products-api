package com.thouraya.ex1_products_api;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.thouraya.ex1_products_api.model.Product;
import com.thouraya.ex1_products_api.repository.ProductRepository;
import com.thouraya.ex1_products_api.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductServicesTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productServices;

    @Test
    void getAllProducts_shouldReturnProducts() {

        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setPrice(50000.0);

        Product p2 = new Product();
        p2.setName("Phone");
        p2.setPrice(30000.0);

        when(productRepository.findAll())
                .thenReturn(Arrays.asList(p1, p2));

        List<Product> products
                = productServices.getAllProducts();

        assertEquals(2, products.size());

        verify(productRepository, times(1))
                .findAll();
    }
}
