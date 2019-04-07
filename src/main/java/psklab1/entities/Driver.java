package psklab1.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "Driver.getAll", query = "select a from Driver as a"),
        @NamedQuery(name = "Driver.byPin", query = "select a from Driver as a where a.pin = :pin"),
        @NamedQuery(name = "Driver.byTeam", query = "select d from Driver as d where d.team.id = :teamId"),
        @NamedQuery(name = "Driver.byStage", query = "select t.drivers from Team t where exists (select s from Stage as s where s.id = :stageId)")
})
@Table(name = "DRIVER")
@Getter
@Setter
@EqualsAndHashCode(of = "pin")
@ToString(of = {"name", "pin", "team"})
public class Driver implements Serializable {

    @Id
    @Size(max = 11, min = 11)
    @Column(name = "PIN")
    private String pin;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Driver() {
    }
}