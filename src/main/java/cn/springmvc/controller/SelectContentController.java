package cn.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.utils.HttpUtils;

import cn.springmvc.model.Select;
import cn.springmvc.service.SelectService;


@Scope("prototype")
@Controller
@RequestMapping("/selects")
public class SelectContentController {

	@Autowired
	private SelectService selectService;
	
	/**
	 * 获取产地和门店
	 * @author summ
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public Map<String, Object> getAllSelectContent() {
		List<Select> selects = null;
		List<String> origins = null;
		Map<String, Object> datas = null;
		
		try {
		     origins = selectService.selectAllOrigin();
			 selects = selectService.selectAllShop();
			 
			 datas = new HashMap<String, Object>();
			 datas.put("areas", selects);
			 datas.put("origins", origins);
		} catch(Exception ex) {
			ex.printStackTrace();
			return HttpUtils.generateResponse("-1", "查询失败", null);
		}
		
		return HttpUtils.generateResponse("0", "请求成功", datas);
	}
	
}
