package psklab1.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TEAM")
@NamedQuery(name = "Team.getAll", query = "select a from Team as a")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name"})
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Driver> drivers;

    @ManyToMany
    private List<Stage> stages;

    public Team(){
    }
}