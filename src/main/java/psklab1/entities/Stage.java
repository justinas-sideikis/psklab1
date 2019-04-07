package psklab1.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQuery(name = "Stage.getAll", query = "select a from Stage as a")
@Table(name = "STAGE")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name"})
public class Stage implements Serializable {

    @Id
    private String id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "stages")
    private List<Team> teams;

    public Stage(){

    }

}
