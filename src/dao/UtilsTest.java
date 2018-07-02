package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import bean.Forms;

public class UtilsTest {
	FormsDAO formsdao = new FormsDAOImp();
	TypeDAO typedao = new TypeDAOImp();

	@Test
	public void test() throws Exception {
//		List<Forms> list = Utils.getAllForms(0);
//		for (Forms f : list) {
//			System.out.println("分类id:" + f.getC_id());
//			System.out.println("风格名:" + f.getForm_name());
//		}
		
		Forms forms = new Forms();
		forms.setC_id(11);
		forms.setForm_name("风格测试");
//		System.out.println(formsdao.add(forms));
		System.out.println(formsdao.del(forms));
	}

}
