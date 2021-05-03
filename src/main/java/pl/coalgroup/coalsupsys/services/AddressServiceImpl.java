package pl.coalgroup.coalsupsys.services;

import pl.coalgroup.coalsupsys.model.Address;
import pl.coalgroup.coalsupsys.repositories.AddressRepository;

public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Address findAddressById(long id) {
        return addressRepository.getOne(id);
    }
}
