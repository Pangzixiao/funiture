package controller;

import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

public class FileUpload extends ActionSupport {
	File image;
	String realpath;
	String imageContentType;
	String imageFileName;

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getRealpath() {
		return realpath;
	}

	public void setRealpath(String realpath) {
		this.realpath = realpath;
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

	public String execute() throws IOException {
		realpath = ServletActionContext.getServletContext().getRealPath("/upload");
		File destFile = new File(realpath, imageFileName);
		Files.copy(image.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		return SUCCESS;
	}
}
