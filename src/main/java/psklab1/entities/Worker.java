package psklab1.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Worker.findAll", query = "select a from Worker as a")
})
@Table(name = "WORKER")
public class Worker implements Serializable {

    @Id
    @Size(max = 11, min = 11)
    @Column(name = "PIN")
    private String pin;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    public Worker() {
    }

    public Worker(String pin, String name) {
        this.pin = pin;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Worker worker = (Worker) obj;
        return Objects.equals(pin, worker.pin) &&
                Objects.equals(name, worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pin, name);
    }
}