package org.rakesh.rest.employee.database;

import java.util.HashMap;
import java.util.Map;

import org.rakesh.rest.employee.model.Employee;
import org.rakesh.rest.employee.model.Profile;

public class staticDB {
private static Map<Long, Employee> employees=new HashMap<>();
private static Map<String, Profile> profiles=new HashMap<>();

public static Map<Long, Employee> getEmployees()
{
	return employees;
}
public static Map<String,Profile> getProfiles()
{
	return profiles;
}

}
