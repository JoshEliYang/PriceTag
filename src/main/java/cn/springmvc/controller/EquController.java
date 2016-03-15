package cn.springmvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.Equipment;
import cn.springmvc.service.EquService;

import com.springmvc.utils.HttpUtils;


@Scope("prototype")
@Controller
@RequestMapping("/equ")
public class EquController {

	private EquService equService;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> getEquCheckByShopId(@PathVariable String shopId) {
		List<Equipment> lists = null;
		try {
			lists = equService.getAllEquipments();
		} catch (Exception ex) {
			ex.printStackTrace();
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "请求成功", lists);
	}
}
