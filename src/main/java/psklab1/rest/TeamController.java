package psklab1.rest;

import lombok.Getter;
import lombok.Setter;
import psklab1.cdi.TimestampLogger;
import psklab1.dto.TeamDto;
import psklab1.entities.Team;
import psklab1.persistence.TeamsDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/team")
public class TeamController {

    @Inject
    @Setter
    @Getter
    private TeamsDAO teamsDAO;

    @Inject
    TimestampLogger timestampLogger;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        timestampLogger.logTimestamp();
        Team team = teamsDAO.load(id);
        if (team == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(TeamDto.ToDto(team)).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer teamId,
            TeamDto team) {
        try {
            Team currentTeam = teamsDAO.load(teamId);
            if (currentTeam == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            currentTeam.setName(team.getName());
            teamsDAO.update(currentTeam);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(TeamDto team) {
        try {
            Team created = TeamDto.ToCteatedEntity(team);
            return Response.ok(teamsDAO.update(created)).build();
        } catch (Exception ex) {
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
