package service.impl;

import dao.GoodInfoDao;
import dao.impl.GoodInfoDaoImpl;
import entity.GoodInfo;
import entity.Page;
import service.GoodInfoService;

import java.util.List;

/**
 * @ClassName GoodInfoServiceImpl
 * @Description TODO
 * @Author czy61
 * @Date 2019/8/10 16:41
 * @Version 1.0
 */
public class GoodInfoServiceImpl implements GoodInfoService {

    private GoodInfoDao goodInfoDao = new GoodInfoDaoImpl();

    @Override
    public List<GoodInfo> queryAll() {
        return goodInfoDao.queryAll();
    }

    @Override
    public GoodInfo queryById(Integer id) {
        return goodInfoDao.queryById(id);
    }

    @Override
    public Page queryAllGoodsInfo(Page page) {
        int totalCount = goodInfoDao.getGoodsCount();
        int totalPage = totalCount%page.getPageSize()==0?totalCount/page.getPageSize():totalCount/page.getPageSize()+1;
        List<GoodInfo> list = goodInfoDao.getList((page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());
        page.setList(list);
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
        return page;
    }

    @Override
    public int add(GoodInfo goodInfo) {
        return goodInfoDao.add(goodInfo);
    }

    @Override
    public int delete(Integer id) {
        return goodInfoDao.delete(id);
    }

    @Override
    public int update(GoodInfo goodInfo) {
        return goodInfoDao.update(goodInfo);
    }

    @Override
    public void updateStock(Integer id, Integer stock) {
        goodInfoDao.updateStock(id,stock);
    }

}
