package com.d288.jgriffis.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    @NonNull
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NonNull
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartItem> cartItems = new HashSet<>();

    public void add(CartItem item) {

        if (item != null) {
            if (cartItems == null) {
                cartItems = new HashSet<>();
            }
            cartItems.add(item);
            item.setCart(this);
        }
    }

    @Column(name = "package_price")
    @NonNull
    private BigDecimal package_price;

    @Column(name = "party_size")
    @NonNull
    private int party_size;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @NonNull
    private StatusType status;

    @Column(name = "order_tracking_number")
    @NonNull
    private String orderTrackingNumber;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

}
