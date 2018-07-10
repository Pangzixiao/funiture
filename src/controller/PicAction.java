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
    File image;
	String imageContentType;
	String imageFileName;
	FurnitureDAO dao = new FurnitureDAOImp();

	public Furniture getF() {
		return f;
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
		System.out.println("id:"+f.getFurniture_id());
		System.out.println("shoper:"+f.getUid());
		f = dao.getFurniture(f.getUid(), f.getFurniture_id());
		System.out.println("f.uid:"+f.getUid());
		System.out.println("f.f_id:"+f.getFurniture_id());
		return SUCCESS;
	}
	
	public String addPic() throws Exception {
		boolean isTrue = false;
		String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
		File destFile = new File(realpath, imageFileName);
//		File destFile1 = new File("",imageFileName);
		Files.copy(image.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//		Files.copy(image.toPath(), destFile1.toPath(),StandardCopyOption.REPLACE_EXISTING);
		System.out.println("·þÎñÆ÷Â·¾¶:"+realpath);
		isTrue = dao.updatePic(f.getFurniture_id(), f.getUid(), imageFileName);
		return isTrue?"success":"fail";
	}
    
}
