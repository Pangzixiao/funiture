package dao;

import java.util.List;

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
	/**
	 * ͨ��id��ѯ
	 * @param detail
	 * @return
	 * @throws Exception
	 */
	
	public boolean findById(Detail detail)throws Exception;
	/**
	 * ��ѯĳ����������ϸ��id
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public List<Integer> getAllDetailID(String form)throws Exception;
}
