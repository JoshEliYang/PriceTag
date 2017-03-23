package cn.springmvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.utils.HttpUtils;

import cn.springmvc.service.RefrePrcService;

@Scope("prototype")
@Controller
@RequestMapping("/RefrePrc")
public class RefrePrcController {
	@Autowired
	RefrePrcService service;
	
	@ResponseBody
	@RequestMapping(value = "/goodsid", method=RequestMethod.GET)
	public Map<String, Object> select(){
		try {
			return HttpUtils.generateResponse("0", "success", service.select());
		} catch (Exception e) {
			return HttpUtils.generateResponse("1", "false", null);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/cargoid", method=RequestMethod.GET)
	public Map<String, Object> selectCargoId(){
		try {
//			Map<String, Object> res = service.selectCargoId(service.select());
//			return HttpUtils.generateResponseCargo("0", "success", res.get("rList"), res.get("fList"));
			return HttpUtils.generateResponse("0", "success", service.selectCargoId(service.select()));
		} catch (Exception e) {
			return HttpUtils.generateResponse("1", "false", null);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public Map<String, Object> update(){
		try {
			service.update(service.selectCargoId(service.select()));
			return HttpUtils.generateResponse("0", "success", null);
		} catch (Exception e) {
			return HttpUtils.generateResponse("1", "failed", null);
		}
	}
}
