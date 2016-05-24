package cn.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.utils.GLCPStringUtils;
import com.springmvc.utils.HttpUtils;
import com.springmvc.utils.RedisUtil;

import cn.springmvc.model.User;
import cn.springmvc.model.newUser;
import cn.springmvc.service.UserService;

@Scope("prototype")
@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * @author Josh Yang
	 * @description 用户登入
	 * @date 2016-3-9
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> userLogin(@RequestBody User u) {
		if (u == null || GLCPStringUtils.isNull(u.getUsername()) || GLCPStringUtils.isNull(u.getPassword())) {
			return HttpUtils.generateResponse("-2", "请求缺少参数", null);
		}

		User user = null;
		try {
			user = userService.getSingleUser(u);
			if (user == null) {
				return HttpUtils.generateResponse("-4", "没有此用户，登入失败", null);
			}

			String token = GLCPStringUtils.generateRandomDigits(20);

			RedisUtil.getRedis().setdat(token, user.getRole() + "$" + user.getShopId(), 12 * 3600);

			Map<String, String> resDatas = new HashMap<String, String>();
			resDatas.put("token", token);
			resDatas.put("shopId", user.getShopId());
			resDatas.put("id", String.valueOf(user.getId()));
			resDatas.put("username", user.getUsername());
			resDatas.put("email", user.getEmail());
			resDatas.put("role", user.getRole());

			return HttpUtils.generateResponse("0", "登入成功", resDatas);
		} catch (Exception ex) {
			return HttpUtils.generateResponse("-3", "服务器内部错误", null);
		}
	}

	/**
	 * @author Josh Yang
	 * @description 修改密码
	 * @date 2016-3-9
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/changePass", method = RequestMethod.PATCH)
	public Map<String, Object> userChangePassword(@RequestBody newUser u) {
		if (u == null || GLCPStringUtils.isNull(u.getUsername()) || GLCPStringUtils.isNull(u.getPassword())
				|| GLCPStringUtils.isNull(u.getNewPassword())) {
			return HttpUtils.generateResponse("-2", "密码不能为空", null);
		}

		User user = null;
		try {
			user = userService.getSingleUser(u);

		} catch (Exception ex) {
			return HttpUtils.generateResponse("-3", "原密码输入错误", null);
		}
		if (user == null) {
			return HttpUtils.generateResponse("-4", "原密码输入错误", null);
		}
		newUser nUser = null;
		try{
			nUser = userService.changePassword(u);
		}catch (Exception ex) {
			return HttpUtils.generateResponse("-3", "两次输入不一致", null);
		}
		
		Map<String, String> resDatas = new HashMap<String, String>();
		resDatas.put("shopId", user.getShopId());
		return HttpUtils.generateResponse("0", "修改密码成功", resDatas);
	}
	
	/**
	 * @author Josh Yang
	 * @description 修改邮箱
	 * @date 2016-3-9
	 * @return JSON
	 */
	@ResponseBody
	@RequestMapping(value = "/resetUserInfo", method = RequestMethod.PATCH)
	public Map<String, Object>userResetInfo(@RequestBody User u){
		User user = null;
		try{
			user = userService.resetUserInfo(u);
		}catch (Exception ex) {
			return HttpUtils.generateResponse("-3", "两次输入不一致", null);
		}
		//return null;
		return HttpUtils.generateResponse("0", "修改密码成功", null);
	}

}
