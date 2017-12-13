package org.rakesh.rest.employee.resources;

import java.util.List;

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
import org.rakesh.rest.employee.model.Profile;
import org.rakesh.rest.employee.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	private ProfileService proService=new ProfileService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfile()
	{
		return proService.getAllProfiles();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		return proService.addProfile(profile);
	}
	@GET
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String firstName)
	{
	   return proService.getProfile(firstName);
	}
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String firstName,Profile profile)
	{
		profile.setFirstName(firstName);
		return proService.updateProfile(profile);
	}
	@DELETE
	@Path("/profileName")
	public void deleteProfile(@PathParam("profileName") String firstName)
	{
		proService.deleteProfile(firstName);
	}
	
	
}
