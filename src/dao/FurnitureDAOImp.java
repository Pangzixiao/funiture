package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Furniture;
import bean.Type;

public class FurnitureDAOImp implements FurnitureDAO {

	@Override
	public boolean add(bean.Furniture furniture) throws Exception {
		String sql = "insert into furnitures(furniture_id,uid,furniture_name,detail_id,price,type,salesvolume)values(?,?,?,?,?,?,?)";
		boolean istrue = false;
		jdbcUtils.getConnection();
		List params = new ArrayList();
		params.add(furniture.getFurniture_id());
		params.add(furniture.getUid());
		params.add(furniture.getFurniture_name());
		params.add(furniture.getDetail_id());
		params.add(furniture.getPrice());
		params.add(furniture.getType());
		params.add(furniture.getSalevolume());
		istrue = jdbcUtils.updateByPreparedStatement(sql, params);
		jdbcUtils.releaseConn();
		return istrue;
	}

	@Override
	public List<Furniture> getAllFurniture(String uid) throws Exception {
		jdbcUtils.getConnection();
		String sql = "select * from furnitures where uid = ?";
		List params = new ArrayList();
		params.add(uid);
		List<Furniture> list = new ArrayList<Furniture>();
		List<Map<String, Object>> furnitures = new ArrayList<Map<String, Object>>();
		furnitures = jdbcUtils.findMoreResult(sql, params);
		for (Map<String, Object> map : furnitures) {
			Furniture f = new Furniture();
			f.setDetail_id((int) map.get("detail_id"));
			f.setFurniture_id((int) map.get("furniture_id"));
			f.setFurniture_name((String) map.get("furniture_name"));
			f.setPrice((double) map.get("price"));
			f.setSalevolume((int) map.get("salesvolume"));
			f.setType((String) map.get("type"));
			f.setUid((String) map.get("uid"));
			String src = (String) map.get("pic_src");
			if (src.isEmpty()) {
				f.setPic_src("empty.png");
			} else {
				f.setPic_src((String) map.get("pic_src"));
			}
			list.add(f);
		}
		jdbcUtils.releaseConn();
		return list;
	}

	@Override
	public Furniture getFurniture(String uid, int furniture_id) throws Exception {
		jdbcUtils.getConnection();
		String sql = "select * from furnitures where uid = ? and furniture_id = ? ";
		List params = new ArrayList();
		params.add(uid);
		params.add(furniture_id);
		Map<String, Object> map = jdbcUtils.findSimpleResult(sql, params);
		if(map.isEmpty()){
			return null;
		}
		Furniture f = new Furniture();
		f.setDetail_id((int) map.get("detail_id"));
		f.setFurniture_id((int) map.get("furniture_id"));
		f.setFurniture_name((String) map.get("furniture_name"));
		f.setPrice((double) map.get("price"));
		f.setSalevolume((int) map.get("salesvolume"));
		f.setType((String) map.get("type"));
		f.setUid((String) map.get("uid"));
		String src = (String) map.get("pic_src");
		if (src.isEmpty()) {
			f.setPic_src("empty.png");
		} else {
			f.setPic_src((String) map.get("pic_src"));
		}

		jdbcUtils.releaseConn();
		return f;
	}
}
