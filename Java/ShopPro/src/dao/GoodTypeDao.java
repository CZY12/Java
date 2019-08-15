package dao;

import entity.GoodType;

import java.util.List;

public interface GoodTypeDao {
    List<GoodType> queryAll();

    List<GoodType> queryByBigType(Integer id);

    int getCount();

    List<GoodType> getList(int currentPage, int pageSize);

    List<GoodType> querySmallType();

    int add(GoodType goodType);

    int update(GoodType goodType);

    int delete(Integer id);

    GoodType queryById(Integer id);
}
