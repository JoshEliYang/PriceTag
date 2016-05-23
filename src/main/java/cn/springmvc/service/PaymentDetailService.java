package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.PaymentDetail;
import cn.springmvc.model.SkuCheckDetail;

public interface PaymentDetailService {
	public List<PaymentDetail> getPaymentDetail(String date) throws Exception;
	public List<PaymentDetail> getAllDetailsByOrdtime(String date) throws Exception;
}
