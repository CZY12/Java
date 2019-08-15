package service;

import entity.GoodType;
import entity.Page;

import java.util.List;

public interface GoodTypeService {
    List<GoodType> queryAll();

    List<GoodType> queryByBigType(Integer id);

    Page queryAllType(Page page);

    List<GoodType> quertSamllType();

    int add(GoodType goodType);

    int update(GoodType goodType);

    int delete(Integer id);

    GoodType queryallById(Integer id);
}
