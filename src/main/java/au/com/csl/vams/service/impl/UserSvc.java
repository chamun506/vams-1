package au.com.csl.vams.service.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IUserDao;
import au.com.csl.vams.model.relational.AppUser;
import au.com.csl.vams.service.IUserSvc;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UserSvc implements IUserSvc {

	@Inject
	@Dao
	private IUserDao dao;
	

	public IUserDao getDao() {
		return dao;
		//return null;
	}

	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	@Override
	public AppUser getById(String pId) {
		return getDao().findOne(pId);
	}
	
	@Override
	public AppUser create(AppUser pEntity) {
		return getDao().save(pEntity);
	}
	
	@Override
	public AppUser update(AppUser pEntity) {
		return getDao().save(pEntity);
	}

	@Override
	public void delete(AppUser pEntity) {
		getDao().delete(pEntity);
	}
	
	@Override
	public List<AppUser> getAll() {
		return getDao().findAll();
	}

	@GET
	@Path("/get")	
	@Produces({"application/json"})
	public AppUser getByNumber() {
		AppUser user = new AppUser();
		user.setLogin("REST AppUser");
		
		return user;
		
	}
}
