package pl.coalgroup.coalsupsys.services;

import org.springframework.stereotype.Service;
import pl.coalgroup.coalsupsys.model.Supplier;
import pl.coalgroup.coalsupsys.repositories.SupplierRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SupplierService implements ServiceInterface{
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier save(Object supplier) {
        supplierRepository.save((Supplier) supplier);
        return (Supplier)supplier;
    }

    @Override
    public Supplier findById(Long id) {
        return supplierRepository.findById(id).get();
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier delete(Long id) {
        Supplier supplierToRemove = supplierRepository.findById(id).get();
        supplierRepository.delete(supplierToRemove);
        return supplierToRemove;
    }

    @Override
    public void update(Object supplier, Long id) {
        if(!supplierRepository.existsById(id)){
            throw new NoSuchElementException();
        } else {
            Supplier updateSupplier = (Supplier)  supplier;
            updateSupplier.setId(id);
            supplierRepository.save(updateSupplier);
        }
    }
}
