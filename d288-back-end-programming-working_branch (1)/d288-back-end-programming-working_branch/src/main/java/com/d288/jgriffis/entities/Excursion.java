package com.d288.jgriffis.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="excursions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    @NonNull
    private Long id;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartitems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id")
    @NonNull
    private Vacation vacation;

    @Column(name = "excursion_title")
    @NonNull
    private String excursion_title;

    @Column(name = "excursion_price")
    @NonNull
    private BigDecimal excursion_price;

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
