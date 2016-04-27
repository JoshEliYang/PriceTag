package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.PaperTagDAO;
import cn.springmvc.model.PaperTag;
import cn.springmvc.service.PaperTagService;

@Service
public class PaperTagServiceImpl implements PaperTagService {

	@Autowired
	private PaperTagDAO paperTagDao;
	
	public int generatePaperTag(PaperTag paperTag) {
		if (paperTag == null) {
			return -1;
		}
		
		try {
			paperTagDao.generatePaperTag(paperTag);
		}catch (Exception ex) {
			ex.getLocalizedMessage();
			return -1;
		}
		
		return paperTag.getId();
	}

	public PaperTag getPaperTagById(int id) {
		PaperTag paperTag = null;
		try {
			paperTag = paperTagDao.getPaperTagById(id);
		} catch (Exception ex) {
			ex.getLocalizedMessage();
			return null; 
		}
		return paperTag;
	}

	public List<PaperTag> getAllPaperTag() {
		List<PaperTag> paperTags = null;
		try {
			paperTags = paperTagDao.getAllPaperTag();
		} catch (Exception ex) {
			ex.getLocalizedMessage();
			return null;
		}
		return paperTags;
	}

	public int deletePaperTagById(int id) {
		PaperTag paperTag = null;
		try {
			paperTag = paperTagDao.getPaperTagById(id);
			if (paperTag == null) {
				return -1;
			}
			
			paperTagDao.deletePaperTag(id);
		} catch (Exception ex) {
			ex.getLocalizedMessage();
			return -1;
		}
				
		return 0;
	}
}
