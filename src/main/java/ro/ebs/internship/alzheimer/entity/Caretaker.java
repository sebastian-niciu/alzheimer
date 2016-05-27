package ro.ebs.internship.alzheimer.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "T_CARETAKER")
public class Caretaker extends User {

    @ManyToMany
    private Set<Patient> patients;

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Caretaker{" +
                "patients=" + patients +
                "} " + super.toString();
    }
}


