package dao;

import java.util.List;
import java.util.Set;

import bean.Brand;

public interface BrandDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	public boolean del(Brand brand)throws Exception;
	public boolean add(Brand brand)throws Exception;
	//��ȡƷ�Ƶļ���
	public List<String> getAllBrands()throws Exception;
	//�ж�ĳ��������Ʒ���Ƿ����
	public boolean isExit(int c_id,String brand_name)throws Exception;
}
