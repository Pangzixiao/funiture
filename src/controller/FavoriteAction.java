package controller;

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
    List<Furniture>list;
    FurnitureDAO furnituredao = new FurnitureDAOImp();
    FavoriteDAO dao = new FavoriteDAOImp();
    
    private List<Favorite> getAllFavorite() throws Exception{
    	Map session = ActionContext.getContext().getSession();
    	String uid = (String)session.get("user");
    	List<Favorite> lists = dao.getAllFavorite(uid);
    	return lists;
    }
    
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
}
