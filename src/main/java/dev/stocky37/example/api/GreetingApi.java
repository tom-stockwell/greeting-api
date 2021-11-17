package dev.stocky37.example.api;

import dev.stocky37.example.json.Greeting;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public interface GreetingApi {
	@GET
	@Path("/")
	Greeting hello();

	@GET
	@Path("{name}")
	Greeting hello(@PathParam("name") String name);
}
