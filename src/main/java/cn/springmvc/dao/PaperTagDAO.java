package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.PaperTag;

public interface PaperTagDAO {

	public int generatePaperTag(PaperTag paperTag);
	
	public int deletePaperTag(int id);
	
	public List<PaperTag> getAllPaperTag();
	
	public PaperTag getPaperTagById(int id);
}
