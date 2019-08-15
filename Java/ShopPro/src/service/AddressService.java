package service;

import entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> queryByUserId(int id);
}
