package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.opensymphony.xwork2.ActionContext;

public class test {

	@Test
	public void test() {
//		List<Furniture> list = new ArrayList<Furniture>();
//		Furniture f1 = new Furniture();
//		Furniture f2 = new Furniture();
//		f1.setPrice(100);
//		f1.setSalevolume(1);
//		f2.setPrice(200);
//		f2.setSalevolume(2);
//		list.add(f1);
//		list.add(f2);
//		ComparatorByPrice c = new ComparatorByPrice();
//		ComparatorByPrice2 c2 = new ComparatorByPrice2();
//		ComparatorBySalevolume c3 = new ComparatorBySalevolume();
//		ComparatorBySalevolume2 c4 = new ComparatorBySalevolume2();
//		System.out.println("���ռ۸�˳������");
//		list.sort(c);
//		for(Furniture f : list){
//			System.out.println("price:"+f.getPrice());
//		}
//		System.out.println("���ռ۸���������");
//		list.sort(c2);
//		for(Furniture f : list){
//			System.out.println("price:"+f.getPrice());
//		}
//		System.out.println("��������˳������");
//		list.sort(c3);
//		for(Furniture f : list){
//			System.out.println("salevolume:"+f.getSalevolume());
//		}
//		System.out.println("����������������");
//		list.sort(c4);
//		for(Furniture f : list){
//			System.out.println("salevolume:"+f.getSalevolume());
//		}
		Map session = ActionContext.getContext().getSession();
		Object o = session.get("user");
		if (2>1) {
			System.out.println("�û�û�е�¼");
		} else {
			System.out.println("�û���¼");
		}
	}

}
