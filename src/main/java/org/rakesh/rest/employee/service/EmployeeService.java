package org.rakesh.rest.employee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.rakesh.rest.employee.database.staticDB;
import org.rakesh.rest.employee.model.Employee;
import org.rakesh.rest.employee.model.Profile;

public class EmployeeService {
   private Map<Long,Employee> employees=staticDB.getEmployees();
   ///private Map<Long,Profile> profiles=staticDB.getProfiles();
   public EmployeeService()
   {
	   employees.put(1L, new Employee(1,"Ritesh",23,4567));
	   employees.put(2L, new Employee(2,"Rutesh",34,456789));
   }
   
	public List<Employee> getAllEmployees()
	{
		return new ArrayList<Employee>(employees.values());
	}
	public Employee getEmployee(long id)
	{
		return employees.get(id);
	}
	public Employee addEmployee(Employee employee)
	{
		employee.setId(employees.size()+1);
		employees.put((long) employee.getId(), employee);
		return employee;
	}
	public Employee updateEmployee(Employee employee)
	{
		if(employee.getId()==0)
			return null;
		else
		{
			employees.put((long) employee.getId(),employee);
			return employee;
		}
	}
	public Employee deleteEmployee(long id)
	{
		return employees.remove(id);
	}
	
	
}
