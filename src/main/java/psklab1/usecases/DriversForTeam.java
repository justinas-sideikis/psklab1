package psklab1.usecases;

import lombok.Getter;
import lombok.Setter;
import psklab1.entities.Team;
import psklab1.entities.mybatis.Driver;
import psklab1.persistence.TeamsDAO;
import psklab1.persistence.mybatis.DriverMapper;
import psklab1.remote.Remote;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@ViewScoped
@Named
public class DriversForTeam implements Serializable {
    @Inject
    private DriverMapper driverMapper;

    @Inject
    private TeamsDAO teamsDAO;

    @Getter
    private List<Driver> allDrivers;

    @Getter
    @Setter
    private Driver createDriver = new Driver();

    @Setter@Getter
    private Team team = new Team();

    @Getter
    private String teamId;

    @PostConstruct
    public void load() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        teamId = requestParameters.get("teamId");

        team = teamsDAO.load(Integer.parseInt(teamId));

        createDriver.setTeamId(Integer.parseInt(teamId));
        allDrivers = driverMapper.selectByFK(teamId);
    }

    @Transactional
    public String create() {
        driverMapper.insert(createDriver);

        return "team.xhtml?teamId=";
    }

    @Transactional
    public String edit() {

        try{
            teamsDAO.update(team);
        } catch (OptimisticLockException e) {
            return "/team.xhtml?teamId=" + Integer.parseInt(teamId) + "&faces-redirect=true&error=opt-lock";
        }

        return "team.xhtml?teamId=" + Integer.parseInt(teamId) + "&faces-redirect=true";
    }
}
