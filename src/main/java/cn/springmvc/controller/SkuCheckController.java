package cn.springmvc.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Scope("prototype")
@Controller
@RequestMapping("/skuchecks")
public class SkuCheckController {
	
}