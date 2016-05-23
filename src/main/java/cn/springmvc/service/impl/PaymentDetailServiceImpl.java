package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.daoLvdi.PaymentDetailDAO;
import cn.springmvc.model.PaymentDetail;
import cn.springmvc.service.PaymentDetailService;


@Service
public class PaymentDetailServiceImpl implements PaymentDetailService {

	@Autowired
	private PaymentDetailDAO paymentDetailDAO;
	
	public List<PaymentDetail> getPaymentDetail(String date) throws Exception {
		
		return paymentDetailDAO.getPaymentDetail(date);
		
	}
	
	public List<PaymentDetail> getAllDetailsByOrdtime(String date) throws Exception {
		return paymentDetailDAO.getAllDetailsByOrdtime(date);
	}
}
