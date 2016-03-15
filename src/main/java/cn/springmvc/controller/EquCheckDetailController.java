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

import cn.springmvc.model.EquCheckDetail;
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
}
