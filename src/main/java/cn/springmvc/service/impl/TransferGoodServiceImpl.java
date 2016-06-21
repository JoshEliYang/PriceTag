package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.TransferGoodDAO;
import cn.springmvc.model.TransferGood;
import cn.springmvc.service.TransferGoodService;

@Service
public class TransferGoodServiceImpl implements TransferGoodService {
	
	@Autowired
	private TransferGoodDAO transferGoodDao;
	
	public int insertTransferGood(List<TransferGood> transferGoods) throws Exception {
		
		return transferGoodDao.insertTransferGood(transferGoods);
	}
	
	public int deleteTransferGoodsByOrderId(int orderId) throws Exception {
		
		return transferGoodDao.deleteTransferGoodsByOrderId(orderId);
	}

	public int deleteTransferGoodById(int id) throws Exception {
		
		return transferGoodDao.deleteTransferGoodById(id);
	}

	public int updateTransferGood(TransferGood transferGood) throws Exception {
		
		return transferGoodDao.updateTransferGood(transferGood);
	}

	public List<TransferGood> getTransferGoodsByOrderId(int orderId) throws Exception {
		
		return transferGoodDao.getTransferGoodsByOrderId(orderId);
	}

	public TransferGood getTransferGoodById(int id) throws Exception {
		
		return transferGoodDao.getTransferGoodById(id);
	}

}
