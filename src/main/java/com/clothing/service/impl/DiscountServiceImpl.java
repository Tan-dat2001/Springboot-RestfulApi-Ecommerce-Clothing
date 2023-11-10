package com.clothing.service.impl;

import com.clothing.entity.Discount;
import com.clothing.repository.DiscountRepository;
import com.clothing.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;


    @Override
    public List<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public Optional<Discount> findById(Long id) {
        return discountRepository.findById(id);
    }

    @Override
    public Discount createDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public Discount editDiscount(Discount discount) {
        try {
            Discount existingDiscount = discountRepository.getReferenceById(discount.getDiscount_id());
            existingDiscount.setDiscountName(discount.getDiscountName());
            existingDiscount.setDiscountCode(discount.getDiscountCode());
            existingDiscount.setQuantity(discount.getQuantity());
            existingDiscount.setDiscountStart(discount.getDiscountStart());
            existingDiscount.setDiscountEnd(discount.getDiscountEnd());
            existingDiscount.setDiscountPrice(discount.getDiscountPrice());
            existingDiscount.setStatus(discount.getStatus());
            return discountRepository.save(existingDiscount);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteDiscount(Long id) {
        try {
            discountRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
