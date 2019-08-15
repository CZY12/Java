package dao;

import entity.Address;

import java.util.List;

public interface AddressDao {
    List<Address> queryByUserId(int id);
}
