package cn.springmvc.controller;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.model.EquCheckDetail;


@Scope("prototype")
@Controller
@RequestMapping("/equcheckdetails")
public class EquCheckDetailController {

}
