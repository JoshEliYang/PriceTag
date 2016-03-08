package cn.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.SkuCheckDetailDAO;
import cn.springmvc.service.SkuCheckDetailService;

@Service
public class SkuCheckDetailServiceImpl implements SkuCheckDetailService {

	@Autowired
	private SkuCheckDetailDAO skuCheckDetailDao;
}
