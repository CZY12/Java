package dao.impl;

import dao.GoodInfoDao;
import entity.GoodInfo;
import util.DBUtils;

import java.util.List;

/**
 * @ClassName GoodInfoDaoImpl
 * @Description TODO
 * @Author czy61
 * @Date 2019/8/10 16:45
 * @Version 1.0
 */
public class GoodInfoDaoImpl extends DBUtils<GoodInfo> implements GoodInfoDao {
    @Override
    public List<GoodInfo> queryAll() {
        String sql = "select * from t_goods_info";
        return super.getList(sql, GoodInfo.class);
    }

    @Override
    public GoodInfo queryById(Integer id) {
        String sql = "select * from t_goods_info where id = ?";
        return super.getSingleInsatnce(sql, GoodInfo.class, id);
    }

    @Override
    public int getGoodsCount() {
        String sql = "select count(*) from t_goods_info where isdelete = '否'";
        return super.getCount(sql);
    }

    @Override
    public List<GoodInfo> getList(int i, int pagSize) {
        String sql = "select * from t_goods_info limit ?,?";
        return super.getList(sql, GoodInfo.class, i, pagSize);
    }

    @Override
    public int add(GoodInfo goodInfo) {
        String sql = "insert into t_goods_info values(null,?,?,?,?,?,?,?,?,?,?)";
        return super.commonOper(sql, goodInfo.getGoods_name(), goodInfo.getGoods_description(), goodInfo.getGoods_pic(), goodInfo.getGoods_price(), goodInfo.getGoods_stock(), goodInfo.getGoods_price_off(), goodInfo.getGoods_discount(), goodInfo.getGoods_fatherid(), goodInfo.getGoods_parentid(), "否");
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from t_goods_info where id = ?";
        return super.commonOper(sql, id);
    }

    @Override
    public int update(GoodInfo goodInfo) {
        String sql = "update t_goods_info set goods_name = ? ,goods_parentid = ?,goods_fatherid = ?,goods_price = ?,goods_pic= ?,goods_description = ?,goods_stock = ? where id = ?";
        return super.commonOper(sql,goodInfo.getGoods_name(),goodInfo.getGoods_parentid(),goodInfo.getGoods_fatherid(),goodInfo.getGoods_price(),goodInfo.getGoods_pic(),goodInfo.getGoods_description(),goodInfo.getGoods_stock(),goodInfo.getId());
    }

    @Override
    public void updateStock(Integer id, Integer stock) {
        String sql = "update t_goods_info set goods_stock = goods_stock - ? where id = ?";
        super.commonOper(sql,stock,id);
    }

}
