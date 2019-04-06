package psklab1.usecases;

import psklab1.entities.Worker;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Model
public class Workers implements Serializable {

    private List<Worker> workers;

    @PostConstruct
    public void init() {
        loadWorkers();
    }

    private void loadWorkers() {
        List<Worker> workers = new LinkedList();

        workers.add(new Worker("Skrudžas", "Makdakas"));
        workers.add(new Worker("Saulius", "Skvernelis"));

        this.workers = workers;
    }

    public List<Worker> getWorkers() {
        return this.workers;
    }
}
