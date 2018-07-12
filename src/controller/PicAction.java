package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bean.Furniture;
import dao.FurnitureDAO;
import dao.FurnitureDAOImp;

public class PicAction extends ActionSupport {
    Furniture f;
    String path;
    File image;
	String imageContentType;
	String imageFileName;
	FurnitureDAO dao = new FurnitureDAOImp();

	public Furniture getF() {
		return f;
	}

	
	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public void setF(Furniture f) {
		this.f = f;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}


	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	
	
	public String selectPic() throws Exception {
		f = dao.getFurniture(f.getUid(), f.getFurniture_id());
		return SUCCESS;
	}
	//添加图片
	public String addPic() throws Exception {
		boolean isTrue = false;
		//获取路径
		String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
		File destFile = new File(realpath, imageFileName);
		//复制
		Files.copy(image.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		//更新数据库中的图片名
		isTrue = dao.updatePic(f.getFurniture_id(), f.getUid(), imageFileName);
		return isTrue?"success":"fail";
	}
    
	
	
	public String showPic() throws Exception {
		//通过家具id和用户名获得图片名
		path = dao.findPicName(f.getFurniture_id(), f.getUid());
		if(path.isEmpty()){
			return "fail";
		}
		return "success";
	}
	
}
