package controller;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bean.Detail;
import bean.Furniture;
import bean.Type;
import dao.DetailDAO;
import dao.DetailDAOImp;
import dao.TypeDAO;
import dao.TypeDAOImp;

public class DetailAction extends ActionSupport {
	Detail detail = new Detail();
	List<Type> types;
	Furniture furniture = new Furniture();
	DetailDAO detaildao = new DetailDAOImp();

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public Furniture getFurniture() {
		return furniture;
	}

	public void setFurniture(Furniture furniture) {
		this.furniture = furniture;
	}

	public String addFuniturePre() throws Exception {
		// ���ؼҾ�����
		TypeDAO dao = new TypeDAOImp();
		this.types = dao.getAllTypes();
		// ����һ���յ�detail��
		detail.setBrand("-1");
		detaildao.add(detail);
		// �����ɵ�detail���detail_id�����Ҿ߶��󴫵���һ�ű�
		furniture.setDetail_id(detaildao.getDetailId());
		// ��sessionȡ���̼���������һ�ű�
		Map session = ActionContext.getContext().getSession();
		String uid = (String) session.get("shoper");
		furniture.setUid(uid);
		return SUCCESS;
	}

	public String addDetail() throws Exception {
		boolean isTrue = false;
		System.out.println(detail.getDetail_id());
		isTrue = detaildao.update(detail);
		return isTrue ? "suc" : "fail";
	}

	public String findById() throws Exception{
		boolean isNull = false;
		isNull = detaildao.findById(detail);
		return isNull?"success":"fail";
	}
}