package psklab1.usecases;

import lombok.Getter;
import lombok.Setter;
import psklab1.entities.Stage;
import psklab1.persistence.StagesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Stages {

    @Inject
    private StagesDAO stagesDAO;

    @Getter @Setter
    private Stage stageToCreate = new Stage();

    @Getter
    private List<Stage> allStages;

    @PostConstruct
    public void init(){
        loadAllStages();
    }

    @Transactional
    public String createStage(){
        this.stagesDAO.persist(stageToCreate);
        return "success";
    }

    private void loadAllStages(){
        this.allStages = stagesDAO.loadAll();
    }
}