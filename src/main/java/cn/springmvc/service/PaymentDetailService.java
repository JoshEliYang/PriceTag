package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.PaymentDetail;

public interface PaymentDetailService {
	public List<PaymentDetail> getPaymentDetail() throws Exception;
	public List<PaymentDetail> getsPaymentDetail(String ORDER_CREATE_TIME) throws Exception;
}
