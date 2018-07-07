package dao;

import java.util.List;

import bean.Favorite;

public interface FavoriteDAO {
	JdbcUtils jdbcUtils = new JdbcUtils();
	public boolean del(Favorite favorite)throws Exception;
	public boolean add(Favorite favorite)throws Exception;
	//判断是否已经存在某用户的收藏夹
	public boolean isExit(String uid) throws Exception;
	//根据用户名查找收藏夹中所有的收藏
	public List<Favorite> getAllFavorite(String uid) throws Exception;
}
