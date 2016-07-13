package service;

import java.util.List;

import dao.ContentDao;
import domain.Catalog;
import domain.Content;
import domain.User;

public class ContentService {

	private ContentDao contentDao = null;

	public ContentService(ContentDao contentDao) {
		this.contentDao = contentDao;
	}

	public void addNewContent(Content content) {
		contentDao.create(content);
	}

	public void updateContent(Content content) {
		contentDao.update(content);
	}

	public void deleteContent(Content content) {
		contentDao.delete(content);		
	}

	public void addNewContents(Content[] contents) {
		for(Content content:contents){
			contentDao.create(content);
		}
		
	}

	public List<Content> getAllContents() {
		return contentDao.findAll();
	}
	
	public List<Content> getAllContentsByUser(User user) {
		return contentDao.findAllByUser(user.getId());
	}
	
	public List<Content> getAllContentsByCatalog(Catalog catalog) {
		return contentDao.findAllByCatalog(catalog.getId());
	}
	
}
