package pl.coalgroup.coalsupsys.services;

import pl.coalgroup.coalsupsys.model.Address;

public interface AddressService {
    void saveAddress(Address address);
    Address findAddressById(long id);
}
