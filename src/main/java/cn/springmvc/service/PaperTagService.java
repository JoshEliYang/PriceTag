package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.PaperTag;

public interface PaperTagService {

	public int generatePaperTag(PaperTag paperTag);
	
	public PaperTag getPaperTagById(int id);
	
	public List<PaperTag> getAllPaperTag();
	
	public int deletePaperTagById(int id);
}
