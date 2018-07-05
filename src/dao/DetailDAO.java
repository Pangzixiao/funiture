package dao;

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
	
	public boolean findById(Detail detail)throws Exception;
}
