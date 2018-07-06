package com.revature.data;

import com.revature.beans.Preference;

public interface PreferenceDAO {
	public Preference addPreference(Preference preference);
	public Preference getPreferenceById(int id);
	public Preference updatePreference(Preference preference);
	public void deletePreference(Preference preference);
}
