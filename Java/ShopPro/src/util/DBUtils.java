package util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DBUtils<T> {

	Connection connection = null;
	PreparedStatement pst = null;
	ResultSet resultSet = null;
	ResultSetMetaData metaData = null;

	/**
	 * 公共增删改的方法
	 */
	public int commonOper(String sql, Object... params) {
		// insert into t_student values(?,?,?)
		try {
			// 得到连接对象
			connection = DBManager.getConnection();
			// 开启事务
			connection.setAutoCommit(false);
			// 得到预编译对象
			pst = connection.prepareStatement(sql);
			// 给sql语句的参数赋值
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			}
			// 执行更新操作
			int result = pst.executeUpdate();
			System.out.println("受影响的行数: " + result);
			// 提交事务
			connection.commit();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			// 回滚事务
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			DBManager.closeAll(pst, connection);
		}
		return 0;
	}

	// 查询集合的方法
	public List<T> getList(String sql, Class<T> clazz, Object... params) {
		// select * from t_xx where limit 0,5
		List<T> list = new ArrayList<>();
		try {
			// 得到连接对象
			connection = DBManager.getConnection();
			// 得到预编译对象
			pst = connection.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			}
			// 执行查询
			resultSet = pst.executeQuery();
			// 得到ResultSetMetaData(包含查询到的结果集中字段的个数，字段的名称，字段的类型等)
			metaData = resultSet.getMetaData();
			// 获取到结果集中字段的个数
			int columnCount = metaData.getColumnCount();
			while (resultSet.next()) {
				// 创建对象
				T ins = clazz.newInstance();

				for (int i = 1; i <= columnCount; i++) {
					// 得到结果集中字段的名称
					String columnName = metaData.getColumnName(i);
					// 得到字段的值
					Object value = resultSet.getObject(i);

					// 找到指定名称的属性
					Field field = clazz.getDeclaredField(columnName);
					// 设置访问权限
					field.setAccessible(true);
					// 给属性赋值
					field.set(ins, value);
				}

				list.add(ins);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeAll(resultSet, pst, connection);
		}
		return list;
	}

	// 查询单个对象的方法
	public T getSingleInsatnce(String sql, Class<T> clazz, Object... params) {
		// select * from t_xx where id =?
		try {
			// 得到连接对象
			connection = DBManager.getConnection();
			// 得到预编译对象
			pst = connection.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			}
			// 执行查询
			resultSet = pst.executeQuery();
			// 得到ResultSetMetaData(包含查询到的结果集中字段的个数，字段的名称，字段的类型等)
			metaData = resultSet.getMetaData();
			// 获取到结果集中字段的个数
			int columnCount = metaData.getColumnCount();
			if (resultSet.next()) {
				// 创建对象
				T ins = clazz.newInstance();

				for (int i = 1; i <= columnCount; i++) {
					// 得到结果集中字段的名称
					String columnName = metaData.getColumnName(i);
					// 得到字段的值
					Object value = resultSet.getObject(i);

					// 找到指定名称的属性
					Field field = clazz.getDeclaredField(columnName);
					// 设置访问权限
					field.setAccessible(true);
					// 给属性赋值
					field.set(ins, value);
				}

				return ins;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeAll(resultSet, pst, connection);
		}
		return null;
	}

	//查询数据库中信息条数
	public int getCount(String sql,Object...params){
		int count = 0;
		try {
			// 得到连接对象
			connection = DBManager.getConnection();
			// 得到预编译对象
			pst = connection.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			}
			// 执行查询
			resultSet = pst.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeAll(resultSet, pst, connection);
		}
		return count;
	}

}
