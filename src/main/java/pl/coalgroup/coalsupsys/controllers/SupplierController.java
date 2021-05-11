package pl.coalgroup.coalsupsys.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.coalgroup.coalsupsys.model.Customer;
import pl.coalgroup.coalsupsys.model.Supplier;
import pl.coalgroup.coalsupsys.services.SupplierService;

import java.util.List;

@RestController
@RequestMapping(SupplierController.BASE_URL)

public class SupplierController {
    public static final String BASE_URL = "api/v1/suppliers";
    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<Supplier> getAllSuppliers(){
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    Supplier getSupplierById(@PathVariable long id){
        return supplierService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Supplier saveSupplier(@RequestBody Customer customer){
        return supplierService.save(customer);
    }

    @PutMapping("/{id}")
    public void updateSupplierById(@RequestBody Supplier supplier,
                              @PathVariable long id){
        supplierService.update(supplier, id);
    }

    @DeleteMapping("/{id}")
    public Supplier deleteSupplier(@PathVariable long id){
        return supplierService.delete(id);
    }
}
