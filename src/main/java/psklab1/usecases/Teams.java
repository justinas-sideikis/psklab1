package psklab1.usecases;

import lombok.Getter;
import lombok.Setter;
import psklab1.entities.Team;
import psklab1.interceptor.LoggedInvocation;
import psklab1.persistence.TeamsDAO;
import psklab1.remote.Remote;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SessionScoped
@Named
public class Teams implements Serializable {

    @Inject
    private TeamsDAO teamsDAO;

    @Getter @Setter
    private Team teamToCreate = new Team();

    @Getter
    private List<Team> allTeams;

    @PostConstruct
    public void init(){
        loadAllTeams();
    }

    @Inject
    private Remote remote;

    private Future<Integer> remoteUpdating = null;

    @Transactional
    @LoggedInvocation
    public String createTeam(){
        this.teamsDAO.persist(teamToCreate);
        return "success";
    }

    private void loadAllTeams(){
        this.allTeams = teamsDAO.loadAll();
    }

    public String upadteInRemote() {
        remoteUpdating = null;
        remoteUpdating = remote.updateInRemote();
        return "index.xhtml?faces-redirect=true";
    }

    public boolean isRemoteRequestHangs() {
        return this.remoteUpdating != null && !remoteUpdating.isDone();
    }

    public String getRemoteRequestStatus() throws ExecutionException, InterruptedException {
        if (this.remoteUpdating == null) {
            return "is null";
        }

        if (isRemoteRequestHangs()) {
            return "Remote is still updating";
        }
        return "Remote item Id: " + remoteUpdating.get();
    }
}