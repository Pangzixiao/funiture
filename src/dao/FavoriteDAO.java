package dao;

import bean.Favorite;

public interface FavoriteDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	public boolean del(Favorite favorite)throws Exception;
	public boolean add(Favorite favorite)throws Exception;
	//�ж��Ƿ��Ѿ�����ĳ�û����ղؼ�
	public boolean isExit(String uid) throws Exception;
}
