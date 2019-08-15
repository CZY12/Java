package service;

import entity.GoodInfo;
import entity.Page;

import java.util.List;

public interface GoodInfoService {
    List<GoodInfo> queryAll();

    GoodInfo queryById(Integer id);

    Page queryAllGoodsInfo(Page page);

    int add(GoodInfo goodInfo);

    int delete(Integer id);

    int update(GoodInfo goodInfo);

    void updateStock(Integer id, Integer stock);
}
