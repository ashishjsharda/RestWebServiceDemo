package controller;


import model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceController {

    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setId("1");
        product1.setPrice("100");
        productRepo.put(product1.getId(), product1);
        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setId("2");
        product2.setPrice("200");
        productRepo.put(product2.getId(), product2);
        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setId("3");
        product3.setPrice("300");
        productRepo.put(product3.getId(), product3);
    }

    @RequestMapping(value = "/products/" , method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct(String id) {
        return new ResponseEntity<>(productRepo.values(), null, 200);
    }

    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>(productRepo.values(), null, HttpStatus.CREATED);
    }
}
