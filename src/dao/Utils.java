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
}
