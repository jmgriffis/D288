package com.d288.jgriffis.controllers;

import com.d288.jgriffis.services.CheckoutService;
import com.d288.jgriffis.services.Purchase;
import com.d288.jgriffis.services.PurchaseResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse checkout(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.checkout(purchase);

        return purchaseResponse;
    }
}
