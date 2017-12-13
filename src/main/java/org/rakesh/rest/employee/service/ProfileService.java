package org.rakesh.rest.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rakesh.rest.employee.database.staticDB;
import org.rakesh.rest.employee.model.Profile;

public class ProfileService {
private Map<String,Profile> profiles=staticDB.getProfiles();
public ProfileService()
{
	profiles.put("rakesh", new Profile(1L,"rakesh","biradar",25000));
}
public List<Profile> getAllProfiles()
{
	return new ArrayList<Profile>(profiles.values());
}
public Profile getProfile(String profileName)
{
	return profiles.get(profileName);
}
public Profile addProfile(Profile profile)
{
	profile.setId(profiles.size()+1);
	profiles.put(profile.getFirstName(), profile);
	return profile;
}
public Profile updateProfile(Profile profile)
{
	if(profile.getId()==0)
	{
		return null;
	}else {
		profiles.put(profile.getFirstName(), profile);
		return profile;
	}
}
public Profile deleteProfile(String firstName)
{
	return profiles.remove(firstName);
}
}
