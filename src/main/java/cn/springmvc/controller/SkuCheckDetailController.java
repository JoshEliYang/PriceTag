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

import cn.springmvc.model.SkuCheck;
import cn.springmvc.model.SkuCheckDetail;
import cn.springmvc.model.Difference;
import cn.springmvc.service.SkuCheckDetailService;
import cn.springmvc.service.SkuCheckService;


@Scope("prototype")
@Controller
@RequestMapping("/skucheckdetails")
public class SkuCheckDetailController {
	
	@Autowired
	private SkuCheckDetailService skuCheckDetailService;
	@Autowired
	private SkuCheckService	skuCheckService;
	
	/**
	 * @author Josh Yang
	 * @description 根据shopId查询所有盘点设备单
	 * @date 2015-3-10
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/{skuCheckId}", method = RequestMethod.GET)
	public Map<String, Object> getAllDetailsByCheckId(@PathVariable String skuCheckId ) {
		List<SkuCheckDetail> lists = null;
		try {
			lists = skuCheckDetailService.getAllDetailsBySkuCheckId(skuCheckId);
		} catch (Exception ex) {
			ex.printStackTrace();
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "请求成功", lists);
	}
	
	/**
	 * 上传SKUdetail
	 * @author johsnon
	 * @param detail
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> insertSkuDetail(@RequestBody List<SkuCheckDetail> detail) {
		System.out.println(detail.toString());
		int res=0;
		try {
			res=skuCheckDetailService.insertSkuDetail(detail);
		} catch (Exception ex) {
			ex.printStackTrace();
			return HttpUtils.generateResponse("1", "服务器内部错误", res);
		}
		return HttpUtils.generateResponse("0", "请求成功", res);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id1}/{id2}",method = RequestMethod.GET)
	public Map<String, Object> skuDifference(@PathVariable String id1,@PathVariable String id2) {
		List<Difference> diffList=null;
		try {
			diffList=skuCheckDetailService.getSkuDifference(id1, id2);
		} catch (Exception ex) {
			ex.printStackTrace();
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "请求成功", diffList);
	}
	
	/**
	 * 导出skudetail
	 * @author victor
	 * @date 2016-3-24
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/{skuCheckId}/excelExport", method = RequestMethod.GET)
	public void exportSkucheckdetails(@PathVariable String skuCheckId, 
			HttpServletResponse response){
		
		PrintWriter writer = null;
		List<SkuCheckDetail> reports = null;
		JSON json = null;
		Map<String, Object> responseMap = null;
		try {
			writer = response.getWriter();
			responseMap = new HashMap<String, Object>();
			
			reports = skuCheckDetailService.getAllDetailsBySkuCheckId(skuCheckId);
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
					this.getLeadToFiledSkuDetails(), "SKU盘点表", response);
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
	
	private LinkedHashMap<String, String> getLeadToFiledSkuDetails() {
		LinkedHashMap<String, String> superClassMap = new LinkedHashMap<String, String>();
		superClassMap.put("id", "ID");
		superClassMap.put("skuCheckId", "SKU盘点表编号");
		superClassMap.put("goodsNo", "商品编码");
		superClassMap.put("goodsName", "商品名称");
		superClassMap.put("num", "数量");

		return superClassMap;
	}
	
	/**
	 * 导出skuDifference
	 * @author victor
	 * @date 2016-3-24
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/{id1}/{id2}/excelExport",method = RequestMethod.GET)
	public void exportDifference (@PathVariable String id1,@PathVariable String id2, 
			HttpServletResponse response){
		PrintWriter writer = null;
		List<Difference> reports = null;
		JSON json = null;
		Map<String, Object> responseMap = null;
		try{
			writer = response.getWriter();
			responseMap = new HashMap<String, Object>();
			
			reports = skuCheckDetailService.getSkuDifference(id1, id2);
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
					this.getLeadToFiledSkuDifference(id1,id2), "SKU盘点比较表", response);
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
	
	private LinkedHashMap<String, String> getLeadToFiledSkuDifference(String id1,String id2) {
		LinkedHashMap<String, String> superClassMap = new LinkedHashMap<String, String>();
		superClassMap.put("name", "SKU盘点表编号");
		try {
			SkuCheck sku1=skuCheckService.getSkuCheckById(id1);
			SkuCheck sku2=skuCheckService.getSkuCheckById(id2);
			superClassMap.put("param1", sku1.getCreationDate().toString());
			superClassMap.put("param2", sku2.getCreationDate().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return superClassMap;
	}
	
}

	