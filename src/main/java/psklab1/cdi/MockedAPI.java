package psklab1.cdi;

import psklab1.rest.TeamController;

import javax.enterprise.inject.Specializes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Specializes
public class MockedAPI extends TeamController {

    @Override
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        return Response.status(Response.Status.CONFLICT).build();
    }
}
