package dao;

import java.util.List;

import bean.Detail;

public interface DetailDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	/**
	 * 生成一个含有细节标识的数据库记录
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	public boolean add(Detail detail)throws Exception;
	/**
	 * 将生成的标识返回回来
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	public int getDetailId()throws Exception;
	/**
	 * 
	 * 更新信息
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	public boolean update(Detail detail)throws Exception;
	/**
	 * 通过id查询
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	
	public boolean findById(Detail detail)throws Exception;
	/**
	 * 查询某个风格或品牌的所有细节id 其中key的取值为form 或  brand
	 * @param
	 * @return
	 * @throws Exception
	 */
	public List<Integer> getAllDetailID(String key ,String value)throws Exception;
}
