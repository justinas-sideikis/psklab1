package psklab1.usecases;

import psklab1.entities.Driver;
import psklab1.persistence.DriversDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class Drivers implements Serializable {
    @Inject
    private DriversDAO driversDAO;

    private Driver driverToCreate = new Driver();

    private List<Driver> allDrivers;

    @PostConstruct
    public void init() {
        loadDrivers();
    }

    private void loadDrivers() {
        this.allDrivers = driversDAO.loadAll();
    }

    public List<Driver> getAllDrivers() {
        return this.allDrivers;
    }

    @Transactional
    public String createDriver(){
        this.driversDAO.persist(driverToCreate);

        return "success";
    }

    public Driver getDriverToCreate() {
        return driverToCreate;
    }

    public void setDriverToCreate(Driver driverToCreate) {
        this.driverToCreate = driverToCreate;
    }
}
