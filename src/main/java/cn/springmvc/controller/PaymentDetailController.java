package cn.springmvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.utils.HttpUtils;

import cn.springmvc.model.PaymentDetail;
import cn.springmvc.service.PaymentDetailService;

@Scope("prototype")
@Controller
@RequestMapping("/paymentdetail")
public class PaymentDetailController {
	@Autowired
	private PaymentDetailService paymentDetailService;

	@ResponseBody
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public Map<String, Object> getPaymentDetail() {
		List<PaymentDetail> list = null;
		
		try {
			list = paymentDetailService.getPaymentDetail();
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}
		
		return HttpUtils.generateResponse("0", "请求成功", list);
	}
	
	@ResponseBody
	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	public Map<String, Object> getsPaymentDetail(@RequestBody Map<String,String> params) {
		List<PaymentDetail> list = null;
		
		try {
			list = paymentDetailService.getsPaymentDetail(params.get("ORDER_CREATE_TIME"));
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}
		
		return HttpUtils.generateResponse("0", "请求成功", list);
	}
	
}
