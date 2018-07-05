package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Brand;
import bean.Forms;

public class Utils {
	/**
	 * 
	 * 通过分类号显示所有的风格
	 * 
	 * @throws SQLException
	 */

	public static List<Forms> getAllForms(int c_id) throws SQLException {
		JdbcUtils jdbcUtils = new JdbcUtils();
		jdbcUtils.getConnection();
		List<Forms> list = new ArrayList<Forms>();
		String sql = "select * from forms where c_id = ?";
		List params = new ArrayList();
		params.add(c_id);
		List<Map<String, Object>> fls = jdbcUtils.findMoreResult(sql, params);
		for (Map<String, Object> map : fls) {
			Forms forms = new Forms();
			forms.setC_id(c_id);
			forms.setForm_name((String) map.get("form_name"));
			list.add(forms);
		}
		return list;
	}

	/**
	 * 通过分类号查询所有的品牌
	 * @param c_id
	 * @return
	 * @throws SQLException
	 */
	public static List<Brand> getAllBrands(int c_id) throws SQLException {
		JdbcUtils jdbcUtils = new JdbcUtils();
		jdbcUtils.getConnection();
		List<Brand> list = new ArrayList<Brand>();
		String sql = "select * from brand where c_id = ?";
		List params = new ArrayList();
		params.add(c_id);
		List<Map<String, Object>> fls = jdbcUtils.findMoreResult(sql, params);
		for (Map<String, Object> map : fls) {
			Brand brand = new Brand();
			brand.setC_id(c_id);
			brand.setBrand_name((String) map.get("brand_name"));
			list.add(brand);
		}
		return list;
	}
	
	/**
	 * 向购物车和用户对应关系中添加记录
	 * 并返回新添加的购物车的标识
	 * 
	 */
	
	public static int addCarUser(String uid)throws Exception{
		int carid = 0;
		String sql = "insert into car_user(uid) values(?)";
		boolean istrue = false;
		JdbcUtils jdbcUtils = new JdbcUtils();
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(uid);
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	if(istrue){
    		String sql2 ="select car_id from car_user where uid = ?";
    		Map<String, Object> map = jdbcUtils.findSimpleResult(sql2, params);
    		carid = (int)map.get("car_id");
    	}
    	jdbcUtils.releaseConn();
		return carid;
	}
	
	
	/**
	 * 向收藏夹和用户对应关系中添加记录
	 * 并返回新添加的收藏夹的标识
	 * 
	 */
	
	public static int addFavoriteUser(String uid)throws Exception{
		int favoriteid = 0;
		String sql = "insert into favorite_user(uid) values(?)";
		boolean istrue = false;
		JdbcUtils jdbcUtils = new JdbcUtils();
		jdbcUtils.getConnection();
    	List params = new ArrayList();
    	params.add(uid);
    	istrue = jdbcUtils.updateByPreparedStatement(sql, params);
    	if(istrue){
    		String sql2 ="select favorite_id from favorite_user where uid = ?";
    		Map<String, Object> map = jdbcUtils.findSimpleResult(sql2, params);
    		favoriteid = (int)map.get("favorite_id");
    	}
    	jdbcUtils.releaseConn();
		return favoriteid;
	}
}
