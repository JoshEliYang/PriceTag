package cn.springmvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.EquCheckDetail;
import cn.springmvc.model.SkuCheckDetail;
import cn.springmvc.model.difference;
import cn.springmvc.service.EquCheckDetailService;

import com.springmvc.utils.HttpUtils;


@Scope("prototype")
@Controller
@RequestMapping("/equcheckdetails")
public class EquCheckDetailController {

	@Autowired
	private EquCheckDetailService equCheckDetailService;
	
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
}
