package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.SkuCheckDetailDAO;
import cn.springmvc.model.EquCheckDetail;
import cn.springmvc.model.SkuCheckDetail;
import cn.springmvc.model.Difference;
import cn.springmvc.service.SkuCheckDetailService;

@Service
public class SkuCheckDetailServiceImpl implements SkuCheckDetailService {

	@Autowired
	private SkuCheckDetailDAO skuCheckDetailDao;

	public List<SkuCheckDetail> getAllDetailsBySkuCheckId(String skuCheckId) throws Exception {
		return skuCheckDetailDao.getAllDetailsBySkuCheckId(skuCheckId);
	}

	public int insertSkuDetail(List<SkuCheckDetail> detail) throws Exception {
		return skuCheckDetailDao.insertSkuDetail(detail);
	}

	/**
	 * 比较两个skuCheck 的差异
	 * 
	 * @param id1,id2
	 *            sku_check表的ID
	 */
	public List<Difference> getSkuDifference(String id1, String id2) throws Exception {
		List<Difference> diffList = new ArrayList();
		List<SkuCheckDetail> detail1 = getAllDetailsBySkuCheckId(id1);
		List<SkuCheckDetail> detail2 = getAllDetailsBySkuCheckId(id2);

		boolean changeFlag = false;
		if (detail1.size() < detail2.size()) {
			changeFlag = true;
			List<SkuCheckDetail> changeDetail = detail1;
			detail1 = detail2;
			detail2 = changeDetail;
		}

		String goodNo1, goodNo2;
		int num1 = -1, num2 = -1;
		for (int i = 0; i < detail1.size(); i++) {
			goodNo1 = detail1.get(i).getGoodsNo();
			num1 = detail1.get(i).getNum();

			int j = 0;
			for (j = 0; j < detail2.size(); j++) {
				// 匹配两个表中相同的goods
				goodNo2 = detail2.get(j).getGoodsNo();
				if (goodNo1.equals(goodNo2)) {
					num2 = detail2.get(j).getNum();
					break;
				}
			}

			if (j < detail2.size()) {
				if (num1 == num2)
					continue;
			}

			Difference diff;
			if (changeFlag == false) {
				diff = new Difference(detail1.get(i).getGoodsName(), num1, num2);
			} else {
				diff = new Difference(detail1.get(i).getGoodsName(), num2, num1);
			}
			diffList.add(diff);

			// reset
			num1 = -1;
			num2 = -1;
		}

		return diffList;
	}

}
