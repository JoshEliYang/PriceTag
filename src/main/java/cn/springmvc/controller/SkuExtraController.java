package cn.springmvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.utils.HttpUtils;

import cn.springmvc.model.GoodsInfo;
import cn.springmvc.service.SkuExtraService;

/**
 * It's an extra API for PSSsystem
 * @author johsnon
 * 
 */
@Scope("prototype")
@Controller
@RequestMapping("/sku_extra")
public class SkuExtraController {
	@Autowired
	SkuExtraService service;
	
	/**
	 * 
	 * @param goodsNo
	 * @return goodsName and goodsNo
	 */
	@ResponseBody
	@RequestMapping(value = "/{goodsNo}", method = RequestMethod.GET)
	public Map<String, Object> getGoodsByNo(@PathVariable String goodsNo) {
		try {
			List<GoodsInfo> result=service.getGoodsByNo(goodsNo);
			return HttpUtils.generateResponse("0", "请求成功", result);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "内部错误", null);
		}
	}
}
