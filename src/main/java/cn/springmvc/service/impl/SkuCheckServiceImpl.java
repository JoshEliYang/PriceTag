package cn.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.SkuCheckDAO;
import cn.springmvc.service.SkuCheckService;

@Service
public class SkuCheckServiceImpl implements SkuCheckService {

	@Autowired
	private SkuCheckDAO skuCheckDao;
}
