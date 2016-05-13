package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.EquCheckDetailDAO;
import cn.springmvc.model.EquCheckDetail;
import cn.springmvc.model.Difference;
import cn.springmvc.service.EquCheckDetailService;

@Service
public class EquCheckDetailServiceImpl implements EquCheckDetailService {

	@Autowired
	private EquCheckDetailDAO equCheckDetailDao;

	public List<EquCheckDetail> getAllDetailsBySkuCheckId(String skuCheckId) throws Exception {

		return equCheckDetailDao.getAllDetailsBySkuCheckId(skuCheckId);
	}

	public int insertEquDetail(List<EquCheckDetail> detail) throws Exception {
		return equCheckDetailDao.insertEquDetail(detail);
	}

	/**
	 * 比较两个equCheck 的差异
	 * 
	 * @param id1,id2
	 *            equ_check表的ID
	 */
	public List<Difference> getEquDifference(String id1, String id2) throws Exception {
		List<Difference> diffList = new ArrayList();
		List<EquCheckDetail> detail1 = getAllDetailsBySkuCheckId(id1);
		List<EquCheckDetail> detail2 = getAllDetailsBySkuCheckId(id2);

		boolean changeFlag = false;
		if (detail1.size() < detail2.size()) {
			changeFlag = true;
			List<EquCheckDetail> changeDetail = detail1;
			detail1 = detail2;
			detail2 = changeDetail;
		}

		String equ1, equ2;
		int param1 = -1, param2 = -1;
		for (int i = 0; i < detail1.size(); i++) {
			equ1 = detail1.get(i).getEquName();
			param1 = detail1.get(i).getNum();

			int j=0;
			for (j = 0; j < detail2.size(); j++) {
				equ2 = detail2.get(j).getEquName();
				if (equ1.equals(equ2)) {
					param2 = detail2.get(j).getNum();
					break;
				}
			}

			if (j < detail2.size()) {
				if (param1 == param2)
					continue;
			}

			Difference diff;
			if (changeFlag == false) {
				diff = new Difference(detail1.get(i).getEquName(), param1, param2);
			} else {
				diff = new Difference(detail1.get(i).getEquName(), param2, param1);
			}
			diffList.add(diff);

			// reset
			param1 = -1;
			param2 = -1;
		}

		return diffList;
	}
}
