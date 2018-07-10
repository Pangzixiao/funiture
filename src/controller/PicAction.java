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
	
	public String addPic() throws Exception {
		boolean isTrue = false;
		String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
		File destFile = new File(realpath, imageFileName);
//		File destFile1 = new File("",imageFileName);
		Files.copy(image.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//		Files.copy(image.toPath(), destFile1.toPath(),StandardCopyOption.REPLACE_EXISTING);
		System.out.println("服务器路径:"+realpath);
		isTrue = dao.updatePic(f.getFurniture_id(), f.getUid(), imageFileName);
		return isTrue?"success":"fail";
	}
    
	
	
	public String showPic() throws Exception {
		System.out.println("服务器路径:"+path);
		path = dao.findPicName(f.getFurniture_id(), f.getUid());
		if(path.isEmpty()){
			return "fail";
		}
		return "success";
	}
	
}
