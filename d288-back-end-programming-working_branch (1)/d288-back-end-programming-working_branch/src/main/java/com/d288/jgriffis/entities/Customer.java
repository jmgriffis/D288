package com.d288.jgriffis.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    public Customer(Division division, String address, String firstName, String lastName, String phone, String postal_code) {
        this.division = division;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.postal_code = postal_code;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    @NonNull
    private Long id;

    @ManyToOne
    @JoinColumn(name = "division_id")
    @NonNull
    private Division division;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Cart> carts;

    public void add(Cart cart) {
        if (cart != null) {
            if (carts == null) {
                carts = new HashSet<>();
            }
            carts.add(cart);
            cart.setCustomer(this);
            }
        }

    @Column(name = "address")
    @NonNull
    private String address;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @Column(name = "customer_first_name")
    @NonNull
    private String firstName;

    @Column(name = "customer_last_name")
    @NonNull
    private String lastName;

    @Column(name = "postal_code")
    @NonNull
    private String postal_code;

    @Column(name = "phone")
    @NonNull
    private String phone;

}
