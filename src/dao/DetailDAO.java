package dao;

import bean.Detail;

public interface DetailDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	/**
	 * ����һ������ϸ�ڱ�ʶ�����ݿ��¼
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	public boolean add(Detail detail)throws Exception;
	/**
	 * �����ɵı�ʶ���ػ���
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	public int getDetailId()throws Exception;
	/**
	 * 
	 * ������Ϣ
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	public boolean update(Detail detail)throws Exception;
	
	public boolean findById(Detail detail)throws Exception;
}
