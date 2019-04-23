package psklab1.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TEAM")
@NamedQuery(name = "Team.getAll", query = "select t from Team as t")
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