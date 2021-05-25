package pl.coalgroup.coalsupsys.services;

import org.springframework.stereotype.Service;
import pl.coalgroup.coalsupsys.model.Customer;
import pl.coalgroup.coalsupsys.repositories.CustomerRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService implements ServiceInterface {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Object company) {
        customerRepository.save((Customer) company);
        return (Customer) company;
    }

    @Override
    public Customer findById(Long id) {

        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer delete(Long id) {
        Customer customerToRemove = customerRepository.findById(id).get();
        customerRepository.delete(customerToRemove);
        return customerToRemove;
    }

    @Override
    public void update(Object customer, Long id) {
        if(!customerRepository.existsById(id)){
            throw  new NoSuchElementException();
        } else {
            Customer updateCustomer = (Customer) customer;
            updateCustomer.setId(id);
            customerRepository.save(updateCustomer);
        }

    }
}
