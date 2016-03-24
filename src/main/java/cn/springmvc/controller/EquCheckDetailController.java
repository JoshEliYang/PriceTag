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

import cn.springmvc.model.EquCheck;
import cn.springmvc.model.EquCheckDetail;
import cn.springmvc.model.difference;
import cn.springmvc.service.EquCheckDetailService;
import cn.springmvc.service.EquCheckService;


@Scope("prototype")
@Controller
@RequestMapping("/equcheckdetails")
public class EquCheckDetailController {

	@Autowired
	private EquCheckDetailService equCheckDetailService;
	@Autowired
	private EquCheckService equCheckService;
	
	/**
	 * @author Josh Yang
	 * @description 根据shopId查询所有盘点设备单
	 * @date 2015-3-10
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/{skuCheckId}", method = RequestMethod.GET)
	public Map<String, Object> getAllDetailsByCheckId(@PathVariable String skuCheckId ) {
		List<EquCheckDetail> lists = null;
		try {
			lists = equCheckDetailService.getAllDetailsBySkuCheckId(skuCheckId);
		} catch (Exception ex) {
			ex.printStackTrace();
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "请求成功", lists);
	}
	
	
	/**
	 * 上传EQUdetail
	 * @author johsnon
	 * @param detail
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> insertEquDetail(@RequestBody List<EquCheckDetail> detail) {
		int res=0;
		try {
			res=equCheckDetailService.insertEquDetail(detail);
		} catch (Exception ex) {
			ex.printStackTrace();
			return HttpUtils.generateResponse("1", "服务器内部错误", res);
		}
		return HttpUtils.generateResponse("0", "请求成功", res);
	}
	
	/**
	 * 
	 * @param id1
	 * @param id2
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/{id1}/{id2}",method = RequestMethod.GET)
	public Map<String, Object> equDifference(@PathVariable String id1,@PathVariable String id2) {
		List<difference> diffList=null;
		try {
			diffList=equCheckDetailService.getEquDifference(id1, id2);
		} catch (Exception ex) {
			ex.printStackTrace();
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "请求成功", diffList);
	}
	
	/**
	 * 导出equdetail
	 * @author victor
	 * @date 2016-3-24
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/{equCheckId}/excelExport", method = RequestMethod.GET)
	public void exportSkucheckdetails(@PathVariable String equCheckId, 
			HttpServletResponse response){
		PrintWriter writer = null;
		List<EquCheckDetail> reports = null;
		JSON json = null;
		Map<String, Object> responseMap = null;
		try{
			writer = response.getWriter();
			responseMap = new HashMap<String, Object>();
			
			reports = equCheckDetailService.getAllDetailsBySkuCheckId(equCheckId);
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
					this.getLeadToFiledSkuDetails(), "EQU盘点表", response);
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
		superClassMap.put("equCheckId", "EQU盘点表编号");
		superClassMap.put("equName", "设备名称");
		superClassMap.put("num", "数量");

		return superClassMap;
	}
	
	/**
	 * 导出equDifference
	 * @author victor
	 * @date 2016-3-24
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/{id1}/{id2}/excelExport",method = RequestMethod.GET)
	public void exportDifference (@PathVariable String id1,@PathVariable String id2, 
			HttpServletResponse response){
		PrintWriter writer = null;
		List<difference> reports = null;
		JSON json = null;
		Map<String, Object> responseMap = null;
		try{
			writer = response.getWriter();
			responseMap = new HashMap<String, Object>();
			
			reports = equCheckDetailService.getEquDifference(id1, id2);
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
					this.getLeadToFiledEquDifference(id1,id2), "EQU盘点比较表", response);
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
	
	private LinkedHashMap<String, String> getLeadToFiledEquDifference(String id1,String id2) {
		LinkedHashMap<String, String> superClassMap = new LinkedHashMap<String, String>();
		superClassMap.put("name", "EQU盘点表编号");
		try {
			EquCheck equ1=equCheckService.getEquCheckById(id1);
			EquCheck equ2=equCheckService.getEquCheckById(id2);
			superClassMap.put("param1", equ1.getCreationDate().toString());
			superClassMap.put("param2", equ2.getCreationDate().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return superClassMap;
	}
}
