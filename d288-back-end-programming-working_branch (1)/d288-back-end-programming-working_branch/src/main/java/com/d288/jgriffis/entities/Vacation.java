package com.d288.jgriffis.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "vacations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    @NonNull
    private Long id;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL)
    private Set<Excursion> excursions;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL)
    private Set<CartItem> cartItems;

    @Column(name = "vacation_title")
    @NonNull
    private String vacation_title;

    @Column(name = "description")
    @NonNull
    private String description;

    @Column(name = "travel_fare_price")
    @NonNull
    private BigDecimal travel_price;

    @Column(name = "image_url")
    @NonNull
    private String image_URL;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;


}
