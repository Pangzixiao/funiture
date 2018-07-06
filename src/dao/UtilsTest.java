package dao;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bean.Furniture;


public class UtilsTest {
	FormsDAO formsdao = new FormsDAOImp();
	BrandDAO branddao = new BrandDAOImp();
	TypeDAO typedao = new TypeDAOImp();
	UserDAO userdao = new UserDAOImp();
	FavoriteDAO favoritedao = new FavoriteDAOImp();
	FurnitureDAO furnituredao = new FurnitureDAOImp();
	DetailDAO detaildao = new DetailDAOImp();

	

	@Test
	public void test() throws Exception {
//		List<Forms> list = Utils.getAllForms(0);
//		for (Forms f : list) {
//			System.out.println("分类id:" + f.getC_id());
//			System.out.println("风格名:" + f.getForm_name());
//		}
		
//		Forms forms = new Forms();
//		forms.setC_id(11);
//		forms.setForm_name("风格测试");
//		System.out.println(formsdao.add(forms));
//		System.out.println(formsdao.del(forms));
		
//		User user = new User();
//		user.setUid("0700");
//		user.setPass("123");
//		System.out.println(userdao.addUser(user, "user"));
		
//		Favorite favorite = new Favorite();
//		favorite.setId(0);
//		favorite.setFurniture_id(0);
//		System.out.println(favoritedao.del(favorite));
		
//		Shoppingcar shoppingcar = new Shoppingcar();
//		shoppingcar.setCar_id(0);
//		shoppingcar.setFurniture_id(0);
//		shoppingcardao.del(shoppingcar);
//		Furniture furniture = new Furniture();
//		furniture.setDetail_id(1);
//		furniture.setFurniture_id(11);
//		furniture.setFurniture_name("nihao");
//		furniture.setPrice(111);
//		furniture.setSalevolume(0);
//		furniture.setType("床");
//		furniture.setUid("123");
//		System.out.println(furnituredao.add(furniture));
		
//		Type type = new Type();
//		type.setC_name("茶几");
//		typedao.findTypeByName(type);
//		System.out.println("id:"+type.getC_id()+" name:"+type.getC_name());
		
//		Detail d = new Detail();
//		d.setDetail_id(1);
//		d.setBrand("新");
//		d.setForm("红");
//		d.setIntroduce("烫烫烫烫阿里街坊邻居的法律框架发卡上的建安费圣诞快乐房价爱上了飞机撒赖扩大昂克赛拉发动机阿拉山口放假啊收到了开发就爱上了咖啡碱阿斯利康的");
//		System.out.println(detaildao.update(d));
		
//		List<Furniture> list = furnituredao.getAllFurniture("0708");
//		for(Furniture ff:list){
//			System.out.println(ff.getFurniture_name());
//		}
//		Detail detail = new Detail();
//		detail.setDetail_id(1);
//		System.out.println(detaildao.findById(detail));
//		System.out.println(detail.getIntroduce());
		
//		List<Shoppingcar> list = shoppingcardao.getCarsById(0);
//		if(list.isEmpty()){
//			System.out.println("没有相关记录");
//		}else{
//			for(Shoppingcar car:list){
//				System.out.println("商品id"+car.getFurniture_id());
//				System.out.println("商家id"+car.getUid());
//			}
//		}
//		Favorite f = new Favorite();
//		f.setFurniture_id(1);
//		f.setShoper("0708");
//		f.setUid("user");
//		System.out.println(favoritedao.add(f));
//		System.out.println(favoritedao.isExit("user"));
//		System.out.println(favoritedao.del(f));
//		System.out.println(favoritedao.isExit("user"));
//		List<Type> list = typedao.getAllTypes();
//		for (Type type : list){
//			System.out.println(type.getC_name());
//		}
		
//		List<String> forms = formsdao.getAllForms();
//		List<String> forms = branddao.getAllBrands();
//		for(String s:forms){
//			System.out.println(s);
//		}
		
//		System.out.println(furnituredao.getAllFurnitureByType("床").size());
//		System.out.println(detaildao.getAllDetailID("中式").size());
//		System.out.println(furnituredao.getAllFurnitureByDetail(1)==null);
//		List<Integer> ids = detaildao.getAllDetailID("brand","宜家");
//		List<Furniture>list = new ArrayList<Furniture>();
//		if (!ids.isEmpty()) {
//			for (int detail_id : ids) {
//				Furniture f = furnituredao.getAllFurnitureByDetail(detail_id);
//				if (f != null){
//					System.out.println(f.getFurniture_name());
//					list.add(f);
//				}
//			}
//		}
		
		
		List<Furniture> list = furnituredao.getAllFurnitureByPrice(0, 999);
		for(Furniture ff:list){
			System.out.println(ff.getFurniture_name());
		}
		
	}

}
