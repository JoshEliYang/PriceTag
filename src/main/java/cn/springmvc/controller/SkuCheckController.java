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
		return HttpUtils.generateResponse("1", "请求成功", lists);
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

		try {
			int result = skuCheckService.saveOneSkuCheck(sku);
			if (result != 0) {
				return HttpUtils.generateResponse("1", "添加失败", null);
			}
		} catch (Exception ex) {
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "添加成功", null);
	}
}
