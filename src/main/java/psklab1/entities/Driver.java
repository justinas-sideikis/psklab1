package psklab1.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@NamedQuery(name = "Driver.getAll", query = "select a from Driver as a")
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