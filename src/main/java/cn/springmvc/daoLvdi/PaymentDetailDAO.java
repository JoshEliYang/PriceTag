package cn.springmvc.daoLvdi;

import java.util.List;

import cn.springmvc.model.PaymentDetail;

public interface PaymentDetailDAO {
	
	public List<PaymentDetail> getPaymentDetail();
	
	public List<PaymentDetail> getsPaymentDetail(String ORDER_CREATE_TIME);

}
