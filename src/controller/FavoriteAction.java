package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.Favorite;
import bean.Furniture;
import dao.FavoriteDAO;
import dao.FavoriteDAOImp;
import dao.FurnitureDAO;
import dao.FurnitureDAOImp;

public class FavoriteAction extends ActionSupport {
	List<Furniture> list = new ArrayList<Furniture>();
	Favorite favorite;
	int id;
    FurnitureDAO furnituredao = new FurnitureDAOImp();
    FavoriteDAO dao = new FavoriteDAOImp();
    
    
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFavorite(Favorite favorite) {
		this.favorite = favorite;
		System.out.println();
	}

	public List<Furniture> getList() {
		return list;
	}

	private List<Favorite> getAllFavorite() throws Exception{
    	Map session = ActionContext.getContext().getSession();
    	String uid = (String)session.get("user");
    	List<Favorite> lists = dao.getAllFavorite(uid);
    	return lists;
    }
    //获取收藏夹
    public String execute() throws Exception{
    	List<Favorite> fs = getAllFavorite();
		if(fs.isEmpty()){
			return "empty";
		}else{
			for(Favorite f : fs ){
				Furniture ftemp = furnituredao.getFurniture(f.getShoper(), f.getFurniture_id());
				if(ftemp != null ){
					list.add(ftemp);
				}
			}
			if(list.isEmpty())
				return "empty";
			else
				return "success";
		}
    }
    
    //收藏
    public String addInFavorite() throws Exception{
    	boolean isTrue = false;
    	Map session = ActionContext.getContext().getSession();
    	String uid = (String)session.get("user");
    	if(uid != null){
    		favorite.setUid(uid);
    		favorite.setFurniture_id(id);
    		if(!dao.isInFavorite(favorite)){
    			isTrue = dao.add(favorite);
    		}
    	}
    	return isTrue?"success":"fail";
    }
    
  //取消收藏
    public String removeFromFavorite() throws Exception{
    	boolean isTrue = false;
    	Map session = ActionContext.getContext().getSession();
    	String uid = (String)session.get("user");
    	if(uid != null){
    		favorite.setUid(uid);
    		favorite.setFurniture_id(id);
    		isTrue = dao.del(favorite);
    	}
    	return isTrue?"success":"fail";
    }
    
}
