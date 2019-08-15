package dao.impl;

import dao.GoodTypeDao;
import entity.GoodType;
import util.DBUtils;

import java.util.List;

/**
 * @ClassName GoodTypeDaoImpl
 * @Description TODO
 * @Author czy61
 * @Date 2019/8/10 16:46
 * @Version 1.0
 */
public class GoodTypeDaoImpl extends DBUtils<GoodType> implements GoodTypeDao {
    @Override
    public List<GoodType> queryAll() {
        String sql = "select * from t_goods_type";
        return super.getList(sql,GoodType.class);
    }

    @Override
    public List<GoodType> queryByBigType(Integer id) {
        String sql = "select * from t_goods_type where gtype_parentid = ?";
        return super.getList(sql,GoodType.class,id);
    }

    @Override
    public int getCount() {
//        String sql = "select count(*) from t_goods_type where gtype_parentid = 0";
        String sql = "select count(*) from t_goods_type";
        return super.getCount(sql);
    }

    @Override
    public List<GoodType> getList(int currentPage, int pageSize) {
//        String sql = "select * from t_goods_type where gtype_parentid = 0 limit ?,?";
        String sql = "select * from t_goods_type limit ?,?";
        return super.getList(sql,GoodType.class,currentPage,pageSize);
    }

    @Override
    public List<GoodType> querySmallType() {
        String sql = "select * from t_goods_type where gtype_parentid != 0";
        return super.getList(sql,GoodType.class);
    }

    @Override
    public int add(GoodType goodType) {
        String sql = "insert into t_goods_type values (null,?,?,null)";
        return super.commonOper(sql,goodType.getGtype_name(),goodType.getGtype_parentid());
    }

    @Override
    public int update(GoodType goodType) {
        String sql = "update t_goods_type set gtype_name = ? ,gtype_parentid = ? where id =?";
        return super.commonOper(sql,goodType.getGtype_name(),goodType.getGtype_parentid(),goodType.getId());
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from t_goods_type where id =?";
        return super.commonOper(sql,id);
    }

    @Override
    public GoodType queryById(Integer id) {
        String sql = "select * from t_goods_type where id = ?";
        return super.getSingleInsatnce(sql,GoodType.class,id);
    }
}

