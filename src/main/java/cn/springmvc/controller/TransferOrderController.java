package cn.springmvc.controller;

import java.util.HashMap;
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

import com.springmvc.utils.GLCPDateUtils;
import com.springmvc.utils.GLCPStringUtils;
import com.springmvc.utils.HttpUtils;

import cn.springmvc.model.TransferOrder;
import cn.springmvc.service.TransferGoodService;
import cn.springmvc.service.TransferOrderService;

@Scope("prototype")
@Controller
@RequestMapping("/transferorder")
public class TransferOrderController {

	@Autowired
	private TransferOrderService transferOrderService;

	@Autowired
	private TransferGoodService transferGoodService;

	/**
	 * 
	 * @author Edward
	 * @description  处理调拨单（即确认调拨）
	 * @date 2016年6月14日
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/dealorder/{handler}/{orderId}", method = RequestMethod.GET)
	public Map<String, Object> dealTransferOrder(@PathVariable String handler, @PathVariable int orderId)
			throws Exception {
		
		TransferOrder transferOrder = transferOrderService.getTransferOrderById(orderId);
		transferOrder.setHandler(handler);
		transferOrder.setDealDate(GLCPDateUtils.getNowDate());
		try {
			if ("sku".equals(transferGoodService.getTransferGoodsByOrderId(orderId).get(0).getGoodType())) {
				transferOrderService.dealSkuTransferOrder(transferOrder);
			} else {
				transferOrderService.dealEquTransferOrder(transferOrder);
			}
			transferOrderService.updateTransferOrder(transferOrder);
			
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "查询成功", null);
	}

	/**
	 * 
	 * @author Edward
	 * @description  获取需门店处理并未完成（确定）的调拨单
	 * @date 2016年6月14日
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/getundealdorders/{shopId}", method = RequestMethod.GET)
	public Map<String, Object> getUndealTransferOrderListByDealShopId(@PathVariable String shopId) {

		List<TransferOrder> orders = null;
		try {
			orders = transferOrderService.getUndealTransferOrderListByDealShopId(shopId);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "查询成功", orders);
	}

	/**
	 * 
	 * @author Edward
	 * @description  获取经门店处理并完成（确定）的调拨单
	 * @date 2016年6月14日
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/getdealedorders/{shopId}", method = RequestMethod.GET)
	public Map<String, Object> getDealedTransferOrderListByDealShopId(@PathVariable String shopId) {

		List<TransferOrder> orders = null;
		try {
			orders = transferOrderService.getDealedTransferOrderListByDealShopId(shopId);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "查询成功", orders);
	}

	/**
	 * 
	 * @author Edward
	 * @description  获取门店申请单未处理的调拨单（即可更改的调拨单）
	 * @date 2016年6月14日
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/getundealapplyorders/{shopId}", method = RequestMethod.GET)
	public Map<String, Object> getUndealTransferOrderListByApplyShopId(@PathVariable String shopId) {

		List<TransferOrder> orders = null;
		try {
			orders = transferOrderService.getUndealTransferOrderListByApplyShopId(shopId);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "查询成功", orders);
	}

	/**
	 * 
	 * @author Edward
	 * @description  获取门店申请并已处理的调拨单
	 * @date 2016年6月14日
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/getdealedapplyorders/{shopId}", method = RequestMethod.GET)
	public Map<String, Object> getDealedTransferOrderListByApplyShopId(@PathVariable String shopId) {

		List<TransferOrder> orders = null;
		try {
			orders = transferOrderService.getDealedTransferOrderListByApplyShopId(shopId);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "查询成功", orders);
	}

	/**
	 * 
	 * @author Edward
	 * @description  取消调拨单
	 * @date 2016年6月13日
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteorder/{id}", method = RequestMethod.GET)
	public Map<String, Object> deleteOrder(@PathVariable int id) {

		try {
			int resultForDeleteOrder = transferOrderService.deleteOrder(id);
			//同时删除改调拨单的所有调拨物品
			int resultForDeleteGood = transferGoodService.deleteTransferGoodsByOrderId(id);
			if (resultForDeleteGood != 0 && resultForDeleteOrder != 0) {

				return HttpUtils.generateResponse("0", "更新成功", null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("1", "更新失败", null);
	}

	/**
	 * 
	 * @author Edward
	 * @description  获取门店申请的调拨单
	 * @date 2016年6月13日
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/getapplyorders/{shopId}", method = RequestMethod.GET)
	public Map<String, Object> getTransferOrderListByApplyShopId(@PathVariable String shopId) {

		List<TransferOrder> orders = null;
		try {
			orders = transferOrderService.getTransferOrderListByApplyShopId(shopId);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "查询成功", orders);
	}

	/**
	 * 
	 * @author Edward
	 * @description  获取门店处理的调拨单
	 * @date 2016年6月13日
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/getdealorders/{shopId}", method = RequestMethod.GET)
	public Map<String, Object> getTransferOrderListByDealShopId(@PathVariable String shopId) {

		List<TransferOrder> orders = null;
		try {
			orders = transferOrderService.getTransferOrderListByDealShopId(shopId);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "查询成功", orders);
	}

	/**
	 * 
	 * @author Edward
	 * @description  通过orderId获取单个调拨单
	 * @date 2016年6月13日
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/getorder/{id}", method = RequestMethod.GET)
	public Map<String, Object> getTransferOrderByOrderId(@PathVariable int id) {

		TransferOrder order = null;
		try {
			order = transferOrderService.getTransferOrderById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "查询成功", order);
	}

	/**
	 * 
	 * @author Edward
	 * @description  更改调拨单
	 * @date 2016年6月13日
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/updateorder", method = RequestMethod.PATCH)
	public Map<String, Object> dealTransferOrder1(@RequestBody TransferOrder transferOrder) throws Exception {
		// List<TransferGood> transferGoods =
		// transferGoodService.getTransferGoodsByOrderId(transferOrder.getId());

		try {
			int result = transferOrderService.updateTransferOrder(transferOrder);
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
	 * @description 申请调拨
	 * @date 2016年6月13日
	 * @return Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping(value = "/applyorder", method = RequestMethod.POST)
	public Map<String, Object> applyOneTransferOrder(@RequestBody TransferOrder transferOrder) {

		if (transferOrder == null || GLCPStringUtils.isNull(transferOrder.getActor())) {
			return HttpUtils.generateResponse("1", "请求失败", null);
		}
		Map<String, Object> responseMap = new HashMap<String, Object>();
		try {
			transferOrder.setApplyDate(GLCPDateUtils.getNowDate());
			int primaryKey = transferOrderService.insertTransferOrder(transferOrder);
			responseMap.put("id", primaryKey);
		} catch (Exception ex) {
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "添加成功", responseMap);
	}

}
