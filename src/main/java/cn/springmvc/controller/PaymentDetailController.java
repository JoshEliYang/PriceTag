package cn.springmvc.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.springmvc.utils.ExcelUtils;
import com.springmvc.utils.HttpUtils;

import cn.springmvc.model.PaymentDetail;
import cn.springmvc.model.SkuCheckDetail;
import cn.springmvc.service.PaymentDetailService;

@Scope("prototype")
@Controller
@RequestMapping("/paymentdetail")
public class PaymentDetailController {
	@Autowired
	private PaymentDetailService paymentDetailService;
	
	/**
	 * @author Summer Wu
	 * @description 订单查询
	 * @date 2016-5-23
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/select/{date}", method = RequestMethod.GET)
	public Map<String, Object> getPaymentDetail(@PathVariable String date) {
		List<PaymentDetail> list = null;
		
		try {
			list = paymentDetailService.getPaymentDetail(date);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}
		
		return HttpUtils.generateResponse("0", "请求成功", list);
	}
	
	/**
	 * @author Summer Wu
	 * @description 导出Excel
	 * @date 2016-5-23
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/excelExport/{date}", method = RequestMethod.GET)
	public void exportPayDetails(@PathVariable String date, 
			HttpServletResponse response){
		
		PrintWriter writer = null;
		List<PaymentDetail> reports = null;
		JSON json = null;
		Map<String, Object> responseMap = null;
		try {
			writer = response.getWriter();
			responseMap = new HashMap<String, Object>();
			
			reports = paymentDetailService.getAllDetailsByOrdtime(date);
			if (reports == null || reports.isEmpty()) {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json; charset=utf-8");
				responseMap.put("code", 0);
				responseMap.put("data", null);
				responseMap.put("msg", "无数据");
				json = (JSON) JSON.toJSON(responseMap);
				writer.println(json.toJSONString());
				return;
			}
			ExcelUtils.listToExcel(reports,
					this.getLeadToFiledPaymentDetails(), "支付详情盘点表", response);
		} catch (Exception e) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			responseMap.put("code", -1);
			responseMap.put("data", null);
			responseMap.put("msg", "服务器内部错误");
			json = (JSON) JSON.toJSON(responseMap);
			writer.println(json.toJSONString());
		}
	}
	
	private LinkedHashMap<String, String> getLeadToFiledPaymentDetails() {
		LinkedHashMap<String, String> superClassMap = new LinkedHashMap<String, String>();
		superClassMap.put("ORDER_CREATE_TIME", "下单时间");
		superClassMap.put("order_no", "下单编号");
		superClassMap.put("item_name", "支付方式");
		

		return superClassMap;
	}
	
}
