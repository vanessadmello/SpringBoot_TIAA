package com.api.controller;

import com.api.Exception.HnDBankException;
import com.api.dto.product.ProductDTO;
import com.api.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hndbank")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private Environment environment;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() throws HnDBankException{
        List<ProductDTO> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<ProductDTO> getProductById(@RequestParam Integer productId) throws HnDBankException{
        ProductDTO product = productService.getProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO) throws HnDBankException{
        int productId = productService.addProduct(productDTO);
        String message = environment.getProperty("API.INSERT_SUCCESS") + productId;
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/product")
    public ResponseEntity<String> updateProduct(@RequestParam Integer productId, @RequestBody ProductDTO productDTO) throws HnDBankException{
        productService.updateProduct(productId, productDTO);
        String message = environment.getProperty("API.UPDATE_SUCCESS");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/product")
    public ResponseEntity<String> deleteProduct(@RequestParam Integer productId) throws HnDBankException{
        productService.deleteProduct(productId);
        String message = environment.getProperty("API.DELETE_SUCCESS");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
