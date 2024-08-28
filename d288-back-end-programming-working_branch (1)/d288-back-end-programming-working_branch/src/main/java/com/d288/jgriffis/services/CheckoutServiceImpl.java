package com.d288.jgriffis.services;

import com.d288.jgriffis.dao.CartItemRepository;
import com.d288.jgriffis.dao.CartRepository;
import com.d288.jgriffis.dao.CustomerRepository;
import com.d288.jgriffis.entities.Cart;
import com.d288.jgriffis.entities.CartItem;
import com.d288.jgriffis.entities.Customer;
import com.d288.jgriffis.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse checkout(Purchase purchase) {

        try {
            Cart cart = purchase.getCart();

            String orderTrackingNumber = generateOrderTrackingNumber();

            cart.setOrderTrackingNumber(orderTrackingNumber);
            Set<CartItem> cartItems = purchase.getCartItems();
            cartItems.forEach(item -> cart.add(item));

            cart.setStatus(StatusType.ordered);

            Customer customer = purchase.getCustomer();

            cartRepository.save(cart);

            customer.add(cart);
            return new PurchaseResponse(orderTrackingNumber);
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Cart is empty");
        }

    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
