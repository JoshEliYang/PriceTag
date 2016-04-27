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

import cn.springmvc.model.PaperTag;
import cn.springmvc.service.PaperTagService;


@Scope("prototype")
@Controller
@RequestMapping("/papertag")
public class PaperTagController {

	@Autowired
	private PaperTagService paperTagService;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public Map<String, Object> getAllPaperTag() {
		List<PaperTag> paperTags = null;
		Map<String, Object> datas;
		try {
			paperTags = paperTagService.getAllPaperTag();
			 
			datas = new HashMap<String, Object>();
			datas.put("paperTags", paperTags);
		} catch(Exception ex) {
			ex.printStackTrace();
			return HttpUtils.generateResponse("-1", "查询失败", null);
		}
		
		return HttpUtils.generateResponse("0", "请求成功", datas);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Map<String, Object> getAllPaperTagById(int id) {
		PaperTag paperTag = null;
		Map<String, Object> datas = null;
		try {
			paperTag = paperTagService.getPaperTagById(id);
			 
			datas = new HashMap<String, Object>();
			datas.put("paperTag", paperTag);
		} catch(Exception ex) {
			ex.printStackTrace();
			return HttpUtils.generateResponse("-1", "查询失败", null);
		}
		
		return HttpUtils.generateResponse("0", "请求成功", datas);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public Map<String, Object> generatePaperTag(PaperTag paperTag) {
		Map<String, Object> datas = null;
		try {
			int result = paperTagService.generatePaperTag(paperTag);
			if (result < 0) {
				return HttpUtils.generateResponse("-1", "添加失败", null);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return HttpUtils.generateResponse("-1", "添加失败", null);
		}
		
		return HttpUtils.generateResponse("0", "添加成功", datas);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.DELETE)
	public Map<String, Object> deletePaperTagById(int id) {
		Map<String, Object> datas = null;
		try {
			int result = paperTagService.deletePaperTagById(id);
			if (result < 0) {
				return HttpUtils.generateResponse("-1", "删除失败", null);
			} 
		} catch (Exception ex) {
			ex.getLocalizedMessage();
			return HttpUtils.generateResponse("-1", "删除失败", null);
		}
		
		return HttpUtils.generateResponse("0", "删除成功", datas);
	}
}
