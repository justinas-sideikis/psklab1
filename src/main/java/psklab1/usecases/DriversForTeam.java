package psklab1.usecases;

import lombok.Getter;
import lombok.Setter;
import psklab1.entities.mybatis.Driver;
import psklab1.persistence.mybatis.DriverMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class DriversForTeam {
    @Inject
    private DriverMapper driverMapper;

    @Getter
    private List<Driver> allDrivers;

    @Getter
    @Setter
    private Driver createDriver = new Driver();

    @Getter
    private String teamId;

    @PostConstruct
    public void load() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        teamId = requestParameters.get("teamId");

        createDriver.setTeamId(Integer.parseInt(teamId));
        allDrivers = driverMapper.selectByFK(teamId);
    }

    @Transactional
    public String create() {
        driverMapper.insert(createDriver);

        return "team.xhtml?teamId=";
    }
}
