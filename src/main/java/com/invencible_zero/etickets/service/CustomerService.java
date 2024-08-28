package com.invencible_zero.etickets.service;

import com.invencible_zero.etickets.repository.CustomerRepository;
import com.invencible_zero.etickets.model.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> findAll() {
        log.info("Finding all customers");
        return customerRepository.findAll();
    }

    public Customer findById(Integer id) {
        log.info("Finding customer by id: {}", id);
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> findByName(String name) {
        log.info("Finding customers by name: {}", name);
        return customerRepository.findByName(name);
    }

    public List<Customer> findByEmail(String email) {
        log.info("Finding customers by email: {}", email);
        return customerRepository.findByEmail(email);
    }

    public Customer save(Customer customer) {
        log.info("Saving customer: {}", customer);
        return customerRepository.save(customer);
    }

    public void delete(Integer id) {
        log.info("Deleting customer by id: {}", id);
        customerRepository.deleteById(id);
    }
}
