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

import com.springmvc.utils.HttpUtils;

import cn.springmvc.model.SkuCheckDetail;
import cn.springmvc.model.difference;
import cn.springmvc.service.SkuCheckDetailService;


@Scope("prototype")
@Controller
@RequestMapping("/skucheckdetails")
public class SkuCheckDetailController {
	
	@Autowired
	private SkuCheckDetailService skuCheckDetailService;
	
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
		List<difference> diffList=null;
		try {
			diffList=skuCheckDetailService.getSkuDifference(id1, id2);
		} catch (Exception ex) {
			ex.printStackTrace();
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "请求成功", diffList);
	}
	
}
