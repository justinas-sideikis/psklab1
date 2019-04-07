package psklab1.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TEAM")
@NamedQueries({
        @NamedQuery(name = "Team.getAll", query = "select t from Team as t"),
        @NamedQuery(name = "Team.byId", query = "select t from Team as t where t.id = :id"),
        @NamedQuery(name = "Team.byDriver", query = "select d.team from Driver as d where d.pin = :driverPin"),
        @NamedQuery(name = "Team.byStage", query = "select s.teams from Stage as s where s.id = :stageId")
})
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "name"})
@ToString(of = {"id", "name"})
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Driver> drivers;

    @ManyToMany
    private List<Stage> stages;

    public Team(){
    }
}