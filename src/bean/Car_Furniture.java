package bean;

public class Car_Furniture {
    int f_id;
    String shoper;
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getShoper() {
		return shoper;
	}
	public void setShoper(String shoper) {
		this.shoper = shoper;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Car_Furniture) ){
			return false;
		} 
		Car_Furniture f = (Car_Furniture)obj;
		return f.getF_id()== this.f_id && f.getShoper().equals(this.shoper);
	}
    
}
