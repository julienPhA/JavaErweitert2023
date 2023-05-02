package de.lbbw;

import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

// endpoint URL/api/message
@Singleton
@Path("hkw")
public class HKWResource {

	private OfenController controller = null;

	public HKWResource() {
		System.out.println("created MessageResource");
		controller = new OfenController();
	}
	
	// http GET call with curl -v http://localhost:8080/api/hkw
	// api/message http GET many objects as JSON
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String hkw() {
		System.out.println("endpoint message hit");
		//return controller.getClass().toString();
		return "hello back";
	}

}