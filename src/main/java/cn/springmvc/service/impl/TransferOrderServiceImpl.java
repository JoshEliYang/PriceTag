package cn.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.utils.GLCPDateUtils;

import cn.springmvc.dao.EquCheckDAO;
import cn.springmvc.dao.EquCheckDetailDAO;
import cn.springmvc.dao.SkuCheckDAO;
import cn.springmvc.dao.SkuCheckDetailDAO;
import cn.springmvc.dao.TransferGoodDAO;
import cn.springmvc.dao.TransferOrderDAO;
import cn.springmvc.model.EquCheck;
import cn.springmvc.model.EquCheckDetail;
import cn.springmvc.model.SkuCheck;
import cn.springmvc.model.SkuCheckDetail;
import cn.springmvc.model.TransferGood;
import cn.springmvc.model.TransferOrder;
import cn.springmvc.service.TransferOrderService;

@Service
public class TransferOrderServiceImpl implements TransferOrderService {

	@Autowired
	private TransferOrderDAO transferOrderDao;

	@Autowired
	private TransferGoodDAO transferGoodDAO;

	@Autowired
	private SkuCheckDAO skuCheckDAO;

	@Autowired
	private SkuCheckDetailDAO skuCheckDetailDAO;

	@Autowired
	private EquCheckDAO equCheckDAO;

	@Autowired
	private EquCheckDetailDAO equCheckDetailDAO;

	public int insertTransferOrder(TransferOrder transferOrder) throws Exception {
		try {
			transferOrderDao.insertTransferOrder(transferOrder	);
		} catch (Exception e) {
			return -1;
		}
		return transferOrder.getId();
	}

	public int updateTransferOrder(TransferOrder transferOrder) throws Exception {

		return transferOrderDao.updateTransferOrder(transferOrder);
	}

	public TransferOrder getTransferOrderById(int id) throws Exception {

		return transferOrderDao.getTransferOrderById(id);
	}

	public List<TransferOrder> getTransferOrderListByDealShopId(String dealShopId) throws Exception {

		return transferOrderDao.getTransferOrderListByDealShopId(dealShopId);
	}

	public List<TransferOrder> getTransferOrderListByApplyShopId(String applyShopId) throws Exception {

		return transferOrderDao.getTransferOrderListByApplyShopId(applyShopId);
	}

	public int deleteOrder(int id) throws Exception {

		return transferOrderDao.deleteTransferOrder(id);
	}

	public List<TransferOrder> getUndealTransferOrderListByDealShopId(String dealShopId) throws Exception {

		return transferOrderDao.getUndealTransferOrderListByDealShopId(dealShopId);
	}

	public List<TransferOrder> getDealedTransferOrderListByDealShopId(String dealShopId) throws Exception {

		return transferOrderDao.getDealedTransferOrderListByDealShopId(dealShopId);
	}

	public List<TransferOrder> getUndealTransferOrderListByApplyShopId(String applyShopId) throws Exception {

		return transferOrderDao.getUndealTransferOrderListByApplyShopId(applyShopId);
	}

	public List<TransferOrder> getDealedTransferOrderListByApplyShopId(String applyShopId) throws Exception {

		return transferOrderDao.getDealedTransferOrderListByApplyShopId(applyShopId);
	}

	public int dealSkuTransferOrder(TransferOrder transferOrder) throws Exception {
		// 获取申请者最新的盘点单编号
		int applySkuCheckId = skuCheckDAO.getSkuCheckListByShopId(transferOrder.getApplyShopId()).get(0).getId();
		System.out.println(applySkuCheckId);
		// 获取处理者最新的盘点单编号
		int dealSkuCheckId = skuCheckDAO.getSkuCheckListByShopId(transferOrder.getDealShopId()).get(0).getId();
		System.out.println(dealSkuCheckId);
		//  创建新的盘点单（处理）
		SkuCheck skuCheckForDeal = new SkuCheck(0, transferOrder.getDealShopId(), transferOrder.getHandler(),
				GLCPDateUtils.getNowDate(), null, null);
		// 创建新的盘点单(申请)
		SkuCheck skuCheckForApply = new SkuCheck(0, transferOrder.getApplyShopId(), transferOrder.getActor(),
				GLCPDateUtils.getNowDate(), null, null);

		skuCheckDAO.saveOneSkuCheck(skuCheckForApply);
		skuCheckDAO.saveOneSkuCheck(skuCheckForDeal);

		// 获取申请者最新的盘点单编号
		int applySkuCheckId_now = skuCheckDAO.getSkuCheckListByShopId(transferOrder.getApplyShopId()).get(0).getId();
		// 获取处理者最新的盘点单编号
		int dealSkuCheckId_now = skuCheckDAO.getSkuCheckListByShopId(transferOrder.getDealShopId()).get(0).getId();

		List<SkuCheckDetail> ApplySkuCheckDetails = skuCheckDetailDAO
				.getAllDetailsBySkuCheckId(String.valueOf(applySkuCheckId));
		List<SkuCheckDetail> DealSkuCheckDetails = skuCheckDetailDAO
				.getAllDetailsBySkuCheckId(String.valueOf(dealSkuCheckId));

		for (int i = 0; i < ApplySkuCheckDetails.size(); i++) {
			ApplySkuCheckDetails.get(i).setSkuCheckId(applySkuCheckId_now);
		}
		skuCheckDetailDAO.insertSkuDetail(ApplySkuCheckDetails);

		for (int i = 0; i < DealSkuCheckDetails.size(); i++) {
			DealSkuCheckDetails.get(i).setSkuCheckId(dealSkuCheckId_now);
		}
		skuCheckDetailDAO.insertSkuDetail(DealSkuCheckDetails);

		// 获取调拨物品
		List<TransferGood> transferGoods = transferGoodDAO.getTransferGoodsByOrderId(transferOrder.getId());
		// System.out.println(transferGoods);
		int sizes = transferGoods.size();
		TransferGood transferGood = null;
		String applyId = String.valueOf(applySkuCheckId_now);// skucheckId
		String dealId = String.valueOf(dealSkuCheckId_now);
		//  处理提出申请的
		for (int i = 0; i < sizes; i++) {
			transferGood = transferGoods.get(i);
			String num = String.valueOf(transferGood.getNum());
			String goodNo = transferGood.getGoodNo();
			if(skuCheckDetailDAO.addSkuDetailNum(applyId, goodNo, num) == 0){
				List<SkuCheckDetail> details = new ArrayList<SkuCheckDetail>();
				SkuCheckDetail detail = new SkuCheckDetail(0, applySkuCheckId_now, goodNo, transferGood.getGoodName(), transferGood.getNum());
				details.add(detail);
				skuCheckDetailDAO.insertSkuDetail(details);
			}
			skuCheckDetailDAO.subSkuDetailNum(dealId, goodNo, num);
		}
		// skuCheckDetailDAO.updateSkuDetail(String.valueOf(applySkuCheckId_now),
		// "321", "1");
		return 1;
	}

	public int dealEquTransferOrder(TransferOrder transferOrder) throws Exception {
		// 获取申请者最新的盘点单编号
		int applyEquCheckId = equCheckDAO.getEquCheckListByShopId(transferOrder.getApplyShopId()).get(0).getId();
		//System.out.println(applyEquCheckId);
		// 获取处理者最新的盘点单编号
		int dealEquCheckId = equCheckDAO.getEquCheckListByShopId(transferOrder.getDealShopId()).get(0).getId();
		//System.out.println(dealEquCheckId);
		//  创建新的设备盘点单（处理）
		EquCheck equCheckforDeal = new EquCheck(0, transferOrder.getDealShopId(), transferOrder.getHandler(), 
				transferOrder.getDealDate(), null, null);
		equCheckDAO.saveOneEquCheck(equCheckforDeal);
		// 获取处理者最新的盘点单编号
		int dealEquCheckId_now = equCheckDAO.getEquCheckListByShopId(transferOrder.getDealShopId()).get(0).getId();
		List<EquCheckDetail> dealEquCheckDetails = equCheckDetailDAO.getAllDetailsBySkuCheckId(String.valueOf(dealEquCheckId));
		for(int i = 0; i < dealEquCheckDetails.size(); i ++){
			dealEquCheckDetails.get(i).setEquCheckId(dealEquCheckId_now);
		}
		equCheckDetailDAO.insertEquDetail(dealEquCheckDetails);
		
		// 创建新的设备盘点单(申请)
		EquCheck equCheckforApply = new EquCheck(0, transferOrder.getApplyShopId(), transferOrder.getActor(), 
				transferOrder.getApplyDate(), null, null);
		equCheckDAO.saveOneEquCheck(equCheckforApply);
		int applyEquCheckId_now = equCheckDAO.getEquCheckListByShopId(transferOrder.getApplyShopId()).get(0).getId();
		List<EquCheckDetail> applyEquCheckDetails = equCheckDetailDAO.getAllDetailsBySkuCheckId(String.valueOf(applyEquCheckId));
		for(int i = 0; i < applyEquCheckDetails.size(); i ++){
			applyEquCheckDetails.get(i).setEquCheckId(applyEquCheckId_now);
		}
		equCheckDetailDAO.insertEquDetail(applyEquCheckDetails);
		
		// 获取调拨物品
		List<TransferGood> transferGoods = transferGoodDAO.getTransferGoodsByOrderId(transferOrder.getId());
		// System.out.println(transferGoods);
		int sizes = transferGoods.size();
		TransferGood transferGood = null;
		String applyId = String.valueOf(applyEquCheckId_now);// skucheckId
		String dealId = String.valueOf(dealEquCheckId_now);
		String goodName  = null;
		String num = null;
		//  处理提出申请的
		for (int i = 0; i < sizes; i++) {
			transferGood = transferGoods.get(i);
			num = String.valueOf(transferGood.getNum());
			goodName = transferGood.getGoodName();
			equCheckDetailDAO.addEquDetailNum(applyId, goodName, num);
			equCheckDetailDAO.subEquDetailNum(dealId, goodName, num);
		}
		// skuCheckDetailDAO.updateSkuDetail(String.valueOf(applySkuCheckId_now),
		// "321", "1");
		return transferGoodDAO.updateTransferGood(transferGood);

	}

}
