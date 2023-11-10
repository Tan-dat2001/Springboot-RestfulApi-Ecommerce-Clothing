package com.clothing.service;

import com.clothing.entity.Discount;

import java.util.List;
import java.util.Optional;

public interface DiscountService {

    List<Discount> findAll();

    Optional<Discount> findById(Long id);

    Discount createDiscount(Discount discount);

    Discount editDiscount(Discount discount);

    void deleteDiscount(Long id);
}
