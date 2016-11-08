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







import cn.springmvc.model.EquCheck;
import cn.springmvc.service.EquCheckService;

import com.springmvc.utils.GLCPDateUtils;
import com.springmvc.utils.GLCPStringUtils;
import com.springmvc.utils.HttpUtils;


@Scope("prototype")
@Controller
@RequestMapping("/equchecks")
public class EquCheckController {
	

	@Autowired
	private EquCheckService equCheckService;

	/**
	 * @author Josh Yang
	 * @description 根据shopId查询所有盘点设备单
	 * @date 2015-3-10
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/{shopId}", method = RequestMethod.GET)
	public Map<String, Object> getEquCheckByShopId(@PathVariable String shopId) {
		List<EquCheck> lists = null;
		try {
			lists = equCheckService.getEquCheckListByShopId(shopId);
		} catch (Exception ex) {
			ex.printStackTrace();
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "请求成功", lists);
		
	}

	/**
	 * @author johsnon
	 * @param shopId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Map<String, Object> getEquCheckByShopId() {
		List<EquCheck> lists = null;
		try {
			lists = equCheckService.getAllEquCheckList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "请求成功", lists);
	}
	
	/**
	 * @author Josh Yang
	 * @description 创建新盘点设备单
	 * @date 2015-3-10
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> saveOneSkuCheck(@RequestBody EquCheck equ) {
		if (equ == null ||
			 GLCPStringUtils.isNull(equ.getActor())) {
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		Map<String, Object> responeMap = new HashMap<String, Object>();
		
		try {
			int primaryKey = equCheckService.saveOneEquCheck(equ);
			responeMap.put("id", primaryKey);
		} catch (Exception ex) {
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "添加成功", responeMap);
	}
	
	/**
	 * @author Josh Yang
	 * @description 审核设备盘点单
	 * @date 2015-3-10
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.PATCH)
	public Map<String, Object> updateOneEquCheck(@PathVariable String id, @RequestBody EquCheck equ) {
		try {
			EquCheck equCheck = equCheckService.getEquCheckById(id);
			if (equCheck == null) {
				return HttpUtils.generateResponse("1", "查询不到此设备盘点单", null);
			}
		} catch (Exception e) {
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		
		if (equ == null ||
			 GLCPStringUtils.isNull(equ.getActor()) ||
			 GLCPStringUtils.isNull(equ.getChecker())) {
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		try {
			equ.setId(Integer.parseInt(id));
			equ.setCheckDate(GLCPDateUtils.getNowDate());
			int result = equCheckService.updateOneEquCheck(equ);
			if (result != 0) {
				return HttpUtils.generateResponse("1", "更新失败", null);
			}
		} catch (Exception ex) {
			return HttpUtils.generateResponse("1", "服务器内部错误", null);
		}
		return HttpUtils.generateResponse("0", "更新成功", null);
	}
}
