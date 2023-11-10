package com.clothing.controller;

import com.clothing.entity.Product;
import com.clothing.response.GeneralApiResponse;
import com.clothing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productService.findAll();
        if(productList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public GeneralApiResponse<?> getProductById(@PathVariable Long id){
        Optional<Product> product = productService.findById(id);
        if(product.isPresent()){
            return new GeneralApiResponse<>("",HttpStatus.OK,product);
        }
        return new GeneralApiResponse<>("200",HttpStatus.NOT_FOUND,null);
    }


    @PostMapping
    public GeneralApiResponse<?> createProduct(@RequestBody Product product){
        return new GeneralApiResponse<>("200", HttpStatus.OK, productService.createProduct(product));
    }

//
//    @ExceptionHandler
//    public ResponseEntity<ProductsErrorResponse> handelException(ProductNotFoundException exception){
//        ProductsErrorResponse errorResponse = new ProductsErrorResponse();
//
//        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//        errorResponse.setMessage(exception.getMessage());
//        errorResponse.setTimeStamp(System.currentTimeMillis());
//        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//    }

}
