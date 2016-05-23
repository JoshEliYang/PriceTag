package cn.springmvc.daoLvdi;

import java.util.List;

import cn.springmvc.model.PaymentDetail;

public interface PaymentDetailDAO {
	
	public List<PaymentDetail> getPaymentDetail(String date);
	
	public List<PaymentDetail> getAllDetailsByOrdtime(String date) throws Exception;

}
