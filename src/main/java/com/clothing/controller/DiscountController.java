package com.clothing.controller;

import com.clothing.entity.Discount;
import com.clothing.response.GeneralApiResponse;
import com.clothing.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @GetMapping("/{id}")
    public GeneralApiResponse<?> getDiscountById(@PathVariable Long id){
        return new GeneralApiResponse<>("200", HttpStatus.OK, discountService.findById(id));
    }

    @PostMapping
    public GeneralApiResponse<?> createDiscount(@RequestBody Discount discount){
        return new GeneralApiResponse<>("", HttpStatus.OK, discountService.createDiscount(discount));
    }
}
