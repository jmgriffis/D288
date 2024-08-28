package com.d288.jgriffis.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "divisions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    @NonNull
    private Long id;

    //private Long country_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_ID", nullable = false, insertable = false, updatable = false)
    private Country country;

    @Column(name = "division")
    @NonNull
    private String division_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

   /* public void setCountry(Country country) {
      setCountry_id(country.getId());
      this.country = country;
    }

    @OneToMany(mappedBy = "division")
    private Set<Customer> customers; */
}
