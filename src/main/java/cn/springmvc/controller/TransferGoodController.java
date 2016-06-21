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
import cn.springmvc.model.TransferGood;
import cn.springmvc.service.TransferGoodService;


@Scope("prototype")
@Controller
@RequestMapping("/transfergood")
public class TransferGoodController {

	@Autowired
	private TransferGoodService transferGoodService;

	/**
	 * 
	 * @author Edward
	 * @description  通过orderId获取调拨单的所有物品
	 * @date 2016年6月13日
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/getgoods/{orderId}", method = RequestMethod.GET)
	public Map<String, Object> getTransferGoodsByOrderId(@PathVariable int orderId) {

		List<TransferGood> goods = null;
		try {
			goods = transferGoodService.getTransferGoodsByOrderId(orderId);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}
		return HttpUtils.generateResponse("0", "查询成功", goods);
	}

	/**
	 * 
	 * @author Edward
	 * @description  通过id获取单个物品
	 * @date 2016年6月13日
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/getgood/{id}", method = RequestMethod.GET)
	public Map<String, Object> getGoodById(@PathVariable int id) {

		TransferGood good = null;
		try {
			good = transferGoodService.getTransferGoodById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "查询成功", good);
	}


	/**
	 * 
	 * @author Edward
	 * @description  更改物品（只能更改物品的数量）
	 * @date 2016年6月13日
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/updategood", method = RequestMethod.PATCH)
	public Map<String, Object> updateTransferGood(@RequestBody TransferGood transferGood) {

		try {
			int result = transferGoodService.updateTransferGood(transferGood);
			if (result != 0) {
				return HttpUtils.generateResponse("1", "更新失败", null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "更新成功", null);
	}

	/**
	 * 
	 * @author Edward
	 * @description   通过id删除物品（单个删除）
	 * @date 2016年6月13日
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/deletebyid/{id}", method = RequestMethod.GET)
	public Map<String, Object> deleteTransferGood(@PathVariable int id) {

		int result;
		try {
			result = transferGoodService.deleteTransferGoodById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "查询成功", result);
	}

	/**
	 * 
	 * @author Edward
	 * @description   通过orderId删除物品（系列删除）
	 * @date 2016年6月13日
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/deletebyorderid/{orderId}", method = RequestMethod.GET)
	public Map<String, Object> deleteTransferGoods(@PathVariable int orderId) {

		int result;
		try {
			result = transferGoodService.deleteTransferGoodsByOrderId(orderId);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "查询成功", result);
	}

	/**
	 * 
	 * @author Edward
	 * @description 添加调拨物品
	 * @date 2016年6月13日
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/addgood", method = RequestMethod.POST)
	public Map<String, Object> addTransferGood(@RequestBody List<TransferGood> transferGoods) {
		
		if (transferGoods == null) {
			return HttpUtils.generateResponse("1", "请求失败", null);
		}
		int result = 0;
		//Map<String, Object> responseMap = new HashMap<String, Object>();
		try {
			result = transferGoodService.insertTransferGood(transferGoods);
			System.out.println(transferGoods.get(0).getGoodName());
			//responseMap.put("id", primaryKey);
		} catch (Exception ex) {
			System.out.println(ex);
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "添加成功", result);
	}

}
