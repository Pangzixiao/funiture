package dao;

import org.junit.Test;

import bean.Favorite;


public class UtilsTest {
	FormsDAO formsdao = new FormsDAOImp();
	TypeDAO typedao = new TypeDAOImp();
	UserDAO userdao = new UserDAOImp();
	FavoriteDAO favoritedao = new FavoriteDAOImp();
	FurnitureDAO furnituredao = new FurnitureDAOImp();
	DetailDAO detaildao = new DetailDAOImp();

	

	@Test
	public void test() throws Exception {
//		List<Forms> list = Utils.getAllForms(0);
//		for (Forms f : list) {
//			System.out.println("����id:" + f.getC_id());
//			System.out.println("�����:" + f.getForm_name());
//		}
		
//		Forms forms = new Forms();
//		forms.setC_id(11);
//		forms.setForm_name("������");
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
//		furniture.setType("��");
//		furniture.setUid("123");
//		System.out.println(furnituredao.add(furniture));
		
//		Type type = new Type();
//		type.setC_name("�輸");
//		typedao.findTypeByName(type);
//		System.out.println("id:"+type.getC_id()+" name:"+type.getC_name());
		
//		Detail d = new Detail();
//		d.setDetail_id(1);
//		d.setBrand("��");
//		d.setForm("��");
//		d.setIntroduce("�������̰���ַ��ھӵķ��ɿ�ܷ����ϵĽ�����ʥ�����ַ��۰����˷ɻ��������󰺿���������������ɽ�ڷżٰ��յ��˿����Ͱ����˿��ȼ˹������");
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
//			System.out.println("û����ؼ�¼");
//		}else{
//			for(Shoppingcar car:list){
//				System.out.println("��Ʒid"+car.getFurniture_id());
//				System.out.println("�̼�id"+car.getUid());
//			}
//		}
		Favorite f = new Favorite();
		f.setFurniture_id(1);
		f.setShoper("0708");
		f.setUid("user");
//		System.out.println(favoritedao.add(f));
//		System.out.println(favoritedao.isExit("user"));
//		System.out.println(favoritedao.del(f));
		System.out.println(favoritedao.isExit("user"));
		
	}

}
