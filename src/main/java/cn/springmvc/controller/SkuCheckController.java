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

import cn.springmvc.model.SkuCheck;
import cn.springmvc.service.SkuCheckService;

@Scope("prototype")
@Controller
@RequestMapping("/skuchecks")
public class SkuCheckController {

	@Autowired
	private SkuCheckService skuCheckService;

	/**
	 * @author Josh Yang
	 * @description 根据shopId查询所有盘点单
	 * @date 2015-3-10
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/{shopId}", method = RequestMethod.GET)
	public Map<String, Object> getSkuCheckByShopId(@PathVariable String shopId) {
		List<SkuCheck> lists = null;
		try {
			lists = skuCheckService.getSkuCheckListByShopId(shopId);
		} catch (Exception ex) {
			ex.printStackTrace();
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "请求成功", lists);
	}

	/**
	 * @author Josh Yang
	 * @description 根据创建新盘点单
	 * @date 2015-3-10
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> saveOneSkuCheck(@RequestBody SkuCheck sku) {
		if (sku == null ||
			 GLCPStringUtils.isNull(sku.getActor())) {
			return HttpUtils.generateResponse("1", "请求失败", null);
		}
		Map<String, Object> responseMap = new HashMap<String, Object>();
		try {
			int primaryKey = skuCheckService.saveOneSkuCheck(sku);
			responseMap.put("id", primaryKey);
		} catch (Exception ex) {
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "添加成功", responseMap);
	}
	
	/**
	 * @author Josh Yang
	 * @description 根据创建新盘点单
	 * @date 2015-3-10
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.PATCH)
	public Map<String, Object> updateOneSkuCheck(@PathVariable String id, @RequestBody SkuCheck sku) {
		try {
			SkuCheck skuCheck = skuCheckService.getSkuCheckById(id);
			if (skuCheck == null) {
				return HttpUtils.generateResponse("1", "查询不到此盘点单", null);
			}
		} catch (Exception e) {
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		
		if (sku == null ||
			 GLCPStringUtils.isNull(sku.getActor()) ||
			 GLCPStringUtils.isNull(sku.getChecker())) {
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		try {
			sku.setId(Integer.parseInt(id));
			sku.setCheckDate(GLCPDateUtils.getNowDate());
			int result = skuCheckService.updateOneSkuCheck(sku);
			if (result != 0) {
				return HttpUtils.generateResponse("1", "更新失败", null);
			}
		} catch (Exception ex) {
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "更新成功", null);
	}
}
