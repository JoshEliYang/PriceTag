package cn.springmvc.dao;

import java.util.List;
import cn.springmvc.model.Equipment;

public interface EquDAO {

	public List<Equipment> getAllEquipments()
			throws Exception;
}
