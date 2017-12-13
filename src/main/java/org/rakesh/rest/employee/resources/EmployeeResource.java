package org.rakesh.rest.employee.resources;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rakesh.rest.employee.model.Employee;
import org.rakesh.rest.employee.service.EmployeeService;
import java.sql.DriverManager;

@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
public Connection connection = null;
	
EmployeeService empService=new EmployeeService();


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getMessage() {
		List<Employee> list=new ArrayList<Employee>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			try {
			String connectionURL = "jdbc:mysql://localhost:3306/EmployeeDB";
			connection = DriverManager.getConnection(connectionURL, "root", "");
			Statement st=connection.createStatement();
			String query="select *from Employees";
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				Employee e=new Employee();
				e.setId(rs.getLong("id"));
				e.setName(rs.getString("name"));
				e.setAge(rs.getInt("age"));
				e.setSalary(rs.getInt("salary"));
			    list.add(e);
			}
			
			System.out.println("Connected!!");
		}catch(SQLException e)
		{
			System.out.println("Problem");
		}}catch (ClassNotFoundException err) {
			err.printStackTrace();
		}	
			return list;
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee addEmployee(Employee employee) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			try {
			String connectionURL = "jdbc:mysql://localhost:3306/EmployeeDB";
			connection = DriverManager.getConnection(connectionURL, "root", "");
			Statement st=connection.createStatement();
			System.out.println("Connected!!");
			String insert_query = "insert into Employees values("+employee.getId()+", '" + employee.getName()+"', "+ employee.getAge() +", " + employee.getSalary()+")";
			st.executeUpdate(insert_query);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}}catch (ClassNotFoundException err) {
			err.printStackTrace();
		}	
		return empService.addEmployee(employee);
	}
	@PUT
	@Path("/{employeeId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee updateEmployee(@PathParam("employeeId") long id,Employee employee)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			try {
			String connectionURL = "jdbc:mysql://localhost:3306/EmployeeDB";
			connection = DriverManager.getConnection(connectionURL, "root", "");
			Statement st=connection.createStatement();
			System.out.println("Connected!!");
			String update_query = "update Employees set name='"+employee.getName()+"',age="+employee.getAge()+",salary=" + employee.getSalary()+" where id="+id;
			st.executeUpdate(update_query);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}}catch (ClassNotFoundException err) {
			err.printStackTrace();
		}	
	    employee.setId(id);
		return empService.updateEmployee(employee);
	}
	@DELETE
	@Path("/{employeeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteEmployee(@PathParam("employeeId") long id)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			try {
			String connectionURL = "jdbc:mysql://localhost:3306/EmployeeDB";
			connection = DriverManager.getConnection(connectionURL, "root", "");
			Statement st=connection.createStatement();
			System.out.println("Connected!!");
			//String query="select *from Employees where id="+id;
			String delete_query = "delete from Employees where id="+id;
			st.executeUpdate(delete_query);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}}catch (ClassNotFoundException err) {
			err.printStackTrace();
		}	
		empService.deleteEmployee(id);
	}
	@GET
	@Path("/{employeeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("employeeId") long id) {
		return empService.getEmployee(id);
		
	}
}
