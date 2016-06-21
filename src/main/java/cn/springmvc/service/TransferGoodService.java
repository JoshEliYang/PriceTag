package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.TransferGood;

public interface TransferGoodService {
	
	public int insertTransferGood(List<TransferGood> transferGoods) throws Exception;
	
	public int deleteTransferGoodsByOrderId(int orderId) throws Exception;
	
	public int deleteTransferGoodById(int id) throws Exception;
	
	public int updateTransferGood(TransferGood transferGood) throws Exception;
	
	public List<TransferGood> getTransferGoodsByOrderId(int orderId) throws Exception;
	
	public TransferGood getTransferGoodById(int id) throws Exception;
	
}
