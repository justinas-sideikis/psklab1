package psklab1.usecases;

import psklab1.entities.Worker;
import psklab1.persistence.WorkersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class Workers implements Serializable {
    @Inject
    private WorkersDAO workersDAO;

    private Worker workerToCreate = new Worker();

    private List<Worker> allWorkers;

    @PostConstruct
    public void init() {
        loadWorkers();
    }

    private void loadWorkers() {
        this.allWorkers = workersDAO.loadAll();
    }

    public List<Worker> getAllWorkers() {
        return this.allWorkers;
    }

    @Transactional
    public String createWorker(){
        this.workersDAO.persist(workerToCreate);

        return "success";
    }

    public Worker getWorkerToCreate() {
        return workerToCreate;
    }

    public void setWorkerToCreate(Worker workerToCreate) {
        this.workerToCreate = workerToCreate;
    }
}
