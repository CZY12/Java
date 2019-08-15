package service.impl;

import dao.AddressDao;
import dao.impl.AddressDaoImpl;
import entity.Address;
import service.AddressService;

import java.util.List;

/**
 * @ClassName AddressServiceImpl
 * @Description TODO
 * @Author czy61
 * @Date 2019/8/12 16:01
 * @Version 1.0
 */
public class AddressServiceImpl implements AddressService {

    private AddressDao addressDao = new AddressDaoImpl();
    @Override
    public List<Address> queryByUserId(int id) {
        return addressDao.queryByUserId(id);
    }
}
