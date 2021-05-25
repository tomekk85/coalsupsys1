package pl.coalgroup.coalsupsys.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.coalgroup.coalsupsys.model.Customer;
import pl.coalgroup.coalsupsys.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping(CustomerController.BASE_URL)

public class CustomerController {
    public static final String BASE_URL = "api/v1/customers";
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.findAll();
    }

    @ApiOperation(value = "",
            notes = "Provide an id to look up specific customer")

    @GetMapping("/{id}")
    Customer getCustomerById(@ApiParam(value = "ID value for the Customer you need to retrieve", readOnly = true)
            @PathVariable long id){
        return customerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public void updateCustomerById(@RequestBody Customer customer,
                                   @PathVariable long id){
        customerService.update(customer, id);
    }

    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable long id){
        return customerService.delete(id);
    }
}
