package service.impl;

import dao.GoodTypeDao;
import dao.impl.GoodTypeDaoImpl;
import entity.GoodType;
import entity.Page;
import service.GoodTypeService;

import java.util.List;

/**
 * @ClassName GoodTypeServiceImpl
 * @Description TODO
 * @Author czy61
 * @Date 2019/8/10 16:40
 * @Version 1.0
 */
public class GoodTypeServiceImpl implements GoodTypeService {

    private GoodTypeDao goodTypeDao = new GoodTypeDaoImpl();
    @Override
    public List<GoodType> queryAll() {
        return goodTypeDao.queryAll();
    }

    @Override
    public List<GoodType> queryByBigType(Integer id) {
        return goodTypeDao.queryByBigType(id);
    }

    @Override
    public Page queryAllType(Page page) {
        int totalCount = goodTypeDao.getCount();
        int totalPage = totalCount%page.getPageSize()==0?totalCount/page.getPageSize():totalCount/page.getPageSize()+1;
        List<GoodType> list = goodTypeDao.getList((page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());
        page.setTotalPage(totalPage);
        page.setTotalCount(totalCount);
        page.setList(list);
        return page;
    }

    @Override
    public List<GoodType> quertSamllType() {
        return goodTypeDao.querySmallType();
    }

    @Override
    public int add(GoodType goodType) {
        return goodTypeDao.add(goodType);
    }

    @Override
    public int update(GoodType goodType) {
        return goodTypeDao.update(goodType);
    }

    @Override
    public int delete(Integer id) {
        return goodTypeDao.delete(id);
    }

    @Override
    public GoodType queryallById(Integer id) {
        return goodTypeDao.queryById(id);
    }
}
