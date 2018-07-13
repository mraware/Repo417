package com.revature.data;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;


import com.revature.beans.Flavor;
import com.revature.beans.History;


@Component
public class FlavorHibernateDAO implements FlavorDAO, HibernateSession {
	private volatile Session session;
	Logger log = Logger.getLogger(FlavorHibernateDAO.class);

	@Override
	public Flavor addFlavor(Flavor flavor) {
		log.debug("Adding flavor " + flavor);
		session.save(flavor);
		return flavor;
		
	}

	@Override
	public Flavor getFlavorById(int id) {
		return (Flavor) session.get(Flavor.class, id);
	}

	@Override
	public Flavor updateFlavor(Flavor flavor) {
		session.update(flavor);
		return flavor;
		
	}

	@Override
	public void deleteFlavor(Flavor flavor) {
		session.delete(flavor);
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
		
	}
	
	@Override
	public int getIdFromName(String name) {
		Query<Flavor> query = session.createQuery("FROM com.revature.beans.Flavor flav "
				+ "WHERE flav.name=:name");
		query.setParameter("name", name);
		return query.uniqueResult().getId();
	}

}