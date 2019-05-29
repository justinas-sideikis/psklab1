package psklab1.dto;

import lombok.Getter;
import lombok.Setter;
import psklab1.entities.Team;

@Getter@Setter
public class TeamDto {
    public static TeamDto ToDto(Team team) {
        TeamDto t = new TeamDto();
        t.setId(team.getId());
        t.setName(team.getName());

        return t;
    }

    public static Team ToUpadtedEntity(TeamDto team) {
        Team t = new Team();

        t.setName(team.getName());
        t.setId(team.getId());

        return t;
    }

    public static Team ToCteatedEntity(TeamDto team) {
        Team t = new Team();

        t.setName(team.getName());

        return t;
    }

    private String name;
    private Integer id;
}
