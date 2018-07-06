package com.revature.data;

import org.hibernate.Session;
import org.springframework.stereotype.Component;


import com.revature.beans.Preference;

@Component
public class PreferenceHibernateDAO implements PreferenceDAO, HibernateSession {
	private volatile Session session;

	@Override
	public Preference addPreference(Preference preference) {
		session.save(preference);
		return preference;
		
	}

	@Override
	public Preference getPreferenceById(int id) {
		return (Preference) session.get(Preference.class, id);
	}

	@Override
	public Preference updatePreference(Preference preference) {
		session.update(preference);
		return preference;
		
	}

	@Override
	public void deletePreference(Preference preference) {
		session.delete(preference);
		
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
		
	}


}
