package cn.springmvc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.utils.HttpUtils;

import cn.springmvc.model.PriceTag;
import cn.springmvc.model.SearchPriceTag;
import cn.springmvc.model.SelectPriceTag;
import cn.springmvc.model.RequestParams;
import cn.springmvc.model.priceTagInsert.PriceTagPacks;
import cn.springmvc.service.PriceTagService;

@Scope("prototype")
@Controller
@RequestMapping("/pricetags")
public class PriceTagController {

	@Autowired
	private PriceTagService priceTagService;

	/**
	 * @author Josh Yang
	 * @description 获得所有价签
	 * @date 2015-12-28
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> getAllPriceTags() {

		List<PriceTag> tags = null;
		try {
			tags = priceTagService.selectAllPriceTags();
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "查询成功", tags);
	}

	/**
	 * @author Josh Yang
	 * @description 添加新价签
	 * @date 2015-12-28
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> addNewPriceTag(@RequestBody PriceTag pt) {
		try {
			int result = priceTagService.insertPriceTag(pt);
			if (result != 0) {
				return HttpUtils.generateResponse("1", "添加失败", null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "添加成功", null);
	}

	/**
	 * @author Josh Yang
	 * @description 根据id查询单个价签
	 * @date 2015-12-28
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Map<String, Object> getPriceTagInfoById(@PathVariable String id) {
		PriceTag pt = null;
		try {
			pt = priceTagService.selectPriceTagById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "查询成功", pt);
	}

	/**
	 * @author Josh Yang
	 * @description 根据id删除单个价签
	 * @date 2015-12-28
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deletePriceTagById(@PathVariable String id) {
		try {
			int result = priceTagService.deletePriceTag(id);
			if (result == -2) {
				return HttpUtils.generateResponse("1", "无法识别此价签", null);
			}

			if (result == -1) {
				return HttpUtils.generateResponse("1", "删除失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "删除成功", null);
	}

	/**
	 * @author Josh Yang
	 * @description 复位已删除单个价签
	 * @date 2015-12-28
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}/rollback", method = RequestMethod.PATCH)
	public Map<String, Object> rollbackDeletedPriceTag(@PathVariable String id) {
		try {
			int result = priceTagService.rollbackDeletedPriceTag(id);
			if (result == -2) {
				return HttpUtils.generateResponse("1", "无法识别此价签", null);
			}

			if (result == -1) {
				return HttpUtils.generateResponse("1", "删除失败", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "复位成功", null);
	}

	/**
	 * @author Josh Yang
	 * @description 根据id更新单个价签
	 * @date 2015-12-28
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public Map<String, Object> updatePriceTag(@PathVariable String id,
			@RequestBody PriceTag pt) {
		PriceTag priceTag = null;
		try {
			int result = priceTagService.updatePriceTag(pt);
			if (result == -2) {
				return HttpUtils.generateResponse("1", "无法识别此价签", null);
			}

			if (result == -1) {
				return HttpUtils.generateResponse("1", "更新失败", null);
			}

			priceTag = priceTagService.selectPriceTagById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "更新成功", priceTag);
	}

	/**
	 * @author Josh Yang
	 * @description 根据id更新单个价签
	 * @date 2015-12-28
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/{goodsNo}/all", method = RequestMethod.PATCH)
	public Map<String, Object> updatePriceTagByGoodsNo(
			@PathVariable String goodsNo, @RequestBody PriceTag pt) {
		try {
			int result = priceTagService.updatePireceTagByGoodsNo(pt);
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
	 * @author Josh Yang
	 * @description 根据条件查询价签
	 * @date 2016-1-13
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public Map<String, Object> getPriceTagsByParam(@RequestBody RequestParams rp) {
		if (rp == null) {
			return HttpUtils.generateResponse("-2", "请求缺少参数", null);
		}
		List<PriceTag> priceTags = null;
		String priceTagAount;
		try {
			priceTags = priceTagService.selectPriceTagsByParams(rp);
			priceTagAount = priceTagService.getpriceTagsAll(rp);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponseFour("0", "请求成功", priceTags,priceTagAount);
	}

	/**
	 * @author Josh Yang
	 * @description 获得所有已删除价签
	 * @date 2015-12-28
	 * @return JSON	
	 */
	@ResponseBody
	@RequestMapping(value = "/deleted", method = RequestMethod.POST)
	public Map<String, Object> getAllDeletedPriceTags(@RequestBody RequestParams rp) {
		List<PriceTag> tags = null;
		String tagAount;
		try {
			tags = priceTagService.selectAllDeletePriceTags(rp);
			tagAount = priceTagService.getdeleteTagsAll();
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponseFour("0", "查询成功", tags,tagAount);
	}
	
	
	/*搜索价签*/
	
	@ResponseBody
	@RequestMapping(value = "/tag", method = RequestMethod.POST)
	public Map<String, Object> searchPriceTag(@RequestBody SelectPriceTag taginfo) {
		List<SearchPriceTag> tags = null;
		String getTagCount;
		try {
			tags = priceTagService.searchPriceTagInfo(taginfo);
			getTagCount = priceTagService.getCountPriceTag(taginfo);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponseFour("0", "查询成功", tags,getTagCount);
	}
	
	
	/*插入标签*/
	
	@ResponseBody
	@RequestMapping(value = "/insertag", method = RequestMethod.POST)
	public Map<String, Object> insertPriceTag(@RequestBody PriceTagPacks param) {
		//List<PriceTagPacks> param1 = null;
		String count;
		try {
			count = priceTagService.insertPriceTagg(param);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "查询成功",count);
	}
	
	/*同步标签*/
	
	@ResponseBody
	@RequestMapping(value = "/tag/sync/{shopId}", method = RequestMethod.GET)
	public Map<String, Object> copyPriceTag(@PathVariable String shopId) {
		//List<PriceTagPacks> param1 = null;
		
		String count;
		try {
			count = priceTagService.syncPriceTag(shopId);
		} catch (Exception e) {
			e.printStackTrace();
			return HttpUtils.generateResponse("1", "请求失败", null);
		}

		return HttpUtils.generateResponse("0", "查询成功",count);
	}
	
	
}
