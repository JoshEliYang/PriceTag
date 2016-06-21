package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.TransferOrder;

public interface TransferOrderService {
	
	public int insertTransferOrder(TransferOrder transferOrder) throws Exception;

	public int updateTransferOrder(TransferOrder transferOrder) throws Exception;
	
	public int deleteOrder(int id) throws Exception;
	
	public int dealSkuTransferOrder(TransferOrder transferOrder) throws Exception;
	
	public int dealEquTransferOrder(TransferOrder transferOrder) throws Exception;

	public TransferOrder getTransferOrderById(int id) throws Exception;

	public List<TransferOrder> getTransferOrderListByDealShopId(String dealShopId) throws Exception;

	public List<TransferOrder> getTransferOrderListByApplyShopId(String applyShopId) throws Exception;
	
	public List<TransferOrder> getUndealTransferOrderListByDealShopId(String dealShopId) throws Exception;
	
	public List<TransferOrder> getDealedTransferOrderListByDealShopId(String dealShopId) throws Exception;
	
	public List<TransferOrder> getUndealTransferOrderListByApplyShopId(String applyShopId) throws Exception;
	
	public List<TransferOrder> getDealedTransferOrderListByApplyShopId(String applyShopId) throws Exception;

}
