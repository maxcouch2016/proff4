package service;

import java.util.List;

import dao.CatalogDao;
import domain.Catalog;

public class CatalogService {

	private CatalogDao catalogDao = null;

	public CatalogService(CatalogDao catalogDao) {
		this.catalogDao = catalogDao;
	}

	public void addNewCatalog(Catalog catalog) {
		catalogDao.create(catalog);
	}

	public void updateCatalog(Catalog catalog) {
		catalogDao.update(catalog);
	}

	public void deleteCatalog(Catalog catalog) {
		catalogDao.delete(catalog);		
	}

	public void addNewCatalogs(Catalog[] catalogs) {
		for(Catalog catalog:catalogs){
			catalogDao.create(catalog);
		}
		
	}

	public List<Catalog> getAllCatalogs() {
		return catalogDao.findAll();
	}

	public Catalog getCatalogByName(String name) {
		return catalogDao.findCatalogByName(name);
	}
	
}
