package com.d288.jgriffis.bootstrap;

import com.d288.jgriffis.dao.CartItemRepository;
import com.d288.jgriffis.dao.CustomerRepository;
import com.d288.jgriffis.dao.DivisionRepository;
import com.d288.jgriffis.dao.ExcursionRepository;
import com.d288.jgriffis.entities.Customer;
import com.d288.jgriffis.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final ExcursionRepository excursionRepository;
    private final DivisionRepository divisionRepository;
    private final CartItemRepository cartItemRepository;


    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository, CartItemRepository cartItemRepository, ExcursionRepository excursionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
        this.cartItemRepository = cartItemRepository;
        this.excursionRepository = excursionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Division in = new Division();
        in.setId(2L);
        Customer trevor = new Customer(in, "123 A Street", "Trevor", "Griffis", "555-5555", "12345");
        customerRepository.save(trevor);

        Customer eileen = new Customer(in, "123 Another Street", "Eileen", "Griffis", "123-4567", "23456");
        customerRepository.save(eileen);

        Customer heather = new Customer(in, "345 B Street", "Heather", "Lewis", "655-5555", "34567");
        customerRepository.save(heather);

        Customer annalyse = new Customer(in, "678 C Street", "Annalyse", "Garrett", "355-5555", "45678");
        customerRepository.save(annalyse);

        Customer melody = new Customer(in, "789 E Street", "Melody", "Garrett", "255-5555", "56789");
        customerRepository.save(melody);
    }
}
