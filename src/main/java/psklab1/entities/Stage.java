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
    @NamedQuery(name = "Stage.getById", query = "select s.teams from Stage as s where s.id = :id"),
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
