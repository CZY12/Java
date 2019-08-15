package dao;

import entity.GoodInfo;

import java.util.List;

public interface GoodInfoDao {
    List<GoodInfo> queryAll();

    GoodInfo queryById(Integer id);

    int getGoodsCount();

    List<GoodInfo> getList(int i, int pagSize);

    int add(GoodInfo goodInfo);

    int delete(Integer id);

    int update(GoodInfo goodInfo);

    void updateStock(Integer id, Integer stock);
}
