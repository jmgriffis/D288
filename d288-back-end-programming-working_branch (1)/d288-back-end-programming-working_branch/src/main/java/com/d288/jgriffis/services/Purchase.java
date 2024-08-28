package com.d288.jgriffis.services;

import com.d288.jgriffis.entities.Cart;
import com.d288.jgriffis.entities.CartItem;
import com.d288.jgriffis.entities.Customer;
import com.d288.jgriffis.entities.StatusType;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
    private StatusType status;
}
