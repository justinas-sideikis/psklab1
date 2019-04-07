package psklab1.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Stage.getAll", query = "select s from Stage as s"),
        @NamedQuery(name = "Stage.byId", query = "select s from Stage as s where s.id = :id"),
        @NamedQuery(name = "Stage.byDriver", query = "select t.stages from Team as t where exists (select d from Driver d where d.team = t)"),
        @NamedQuery(name = "Stage.byTeam", query = "select t.stages from Team as t where t.id = :teamId")
})
@Table(name = "STAGE")
@Getter
@Setter
@EqualsAndHashCode(of = {"id", "name"})
@ToString(of = {"id", "name"})
public class Stage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "stages")
    private List<Team> teams;

    public Stage(){

    }

}
