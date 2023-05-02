package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.example.global.Brennbar;
import org.example.ofen.OfenController;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.inject.Singleton;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

// endpoint URL/api/message
@Singleton
@Path("message")
public class MessageResource {

	private OfenController controller = null;
	private List<Message> brennelementelist = null;

	public MessageResource() {
		
		System.out.println("created OfenController");
		controller = new OfenController();
		HashMap<String, String> map = controller.erzeugeBrennelementliste();

		brennelementelist = new ArrayList<>();
		int i = 0;
		for (String key : map.keySet()) {
			i++;
			Message mess = new Message();
			mess.setNr(i);
			mess.setContent(map.get(key));
			brennelementelist.add(mess);
		}
		
	}

	// http GET call with curl -v http://localhost:8080/api/message
	// api/message http GET many objects as JSON
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> messages() {
		System.out.println("endpoint message hit");
				
		return brennelementelist;
	}

	// api/message/<nr> http GET one object as JSON curl -v http://localhost:8080/api/message/1
	@GET
	@Path("{nr}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message messageByNr(@PathParam("nr") int nr) {
		//return controller.getMessageByNr(nr);
		Message result = null;
		for(Message m : brennelementelist) {
			if (m.getNr()==nr) {
				result = m; 
				break;
			}
		}
		return result;
	}
	
	/**
	 * checks authorization header field 
	 * @param authorization
	 * @return
	 */
	private boolean checkAccessToken(List<String> authorization) {
		if (authorization != null && authorization.size() >= 1) {
			String[] tokens = authorization.get(0).split(" ");
			if (tokens.length == 2 && tokens[0].equals("Bearer") && tokens[1].equals("only_a_test")) {
				return true;
			}
		}
		return false;
	}

	// api/message/<nr> http PUT one object as JSON
	// note: this endpoint can only be called with a bearer access token in the authorization request header field
	// before calling this endpoint, the client needs to request this access token from an authentication provider
	// see also https://datatracker.ietf.org/doc/html/rfc6750
	// curl -X PUT -v -H "Content-Type: application/json" -H "Authorization: Bearer only_a_test" -d "{\"nr\":\"3\",\"content\":\"Hola Mundo !\"}" http://localhost:8080/api/message
	// for a discussion of PUT vs POST see here: https://stackoverflow.com/questions/630453/what-is-the-difference-between-post-and-put-in-http
	/*@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postMessage(@Context HttpHeaders httpHeaders, String json) {
		System.err.println("Hallo");
		ObjectMapper mapper = new ObjectMapper();
		if (!checkAccessToken(httpHeaders.getRequestHeader("authorization"))) {
			return Response.status(Status.UNAUTHORIZED).build();
		} else {
			try {
				Message m = mapper.readValue(json, Message.class);
				//controller.addMessage(m);
			} catch (IOException e) {
				System.out.println(e.getMessage());
				controller.verbrenneSortiert();

			}
			return Response.noContent().build();
		}
	}*/
	
	/*@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postMessage(String json) {
		System.err.println("Hallo");
		//ObjectMapper mapper = new ObjectMapper();
				controller.verbrenneObject(json);



			return Response.noContent().build();
	} */
	
	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	public Response postMessage(String json) {
		System.err.println("Hallo");
		//ObjectMapper mapper = new ObjectMapper();
				controller.verbrenneObject(json);


			return Response.noContent().build();
	}
	
	
	// curl -X DELETE -v -H "Content-Type: text/plain" -d "3" http://localhost:8080/api/message
	@DELETE
	@Consumes(MediaType.TEXT_PLAIN)
	public Response deleteMessageByNr(String messageNo) {
		try {
			System.out.println(messageNo);
			//controller.deleteMessage(Integer.parseInt(messageNo));
		} catch (NumberFormatException ex) {
			System.out.println(ex.getMessage());
		}
		return Response.noContent().build();
	}

	// rest/message -> http GET + plain text
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String messagePlainText() {
        return "Hello World !!";
    }

}