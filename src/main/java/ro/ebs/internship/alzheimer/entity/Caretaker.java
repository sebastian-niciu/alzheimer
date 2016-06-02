package ro.ebs.internship.alzheimer.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "T_CARETAKER")
public class Caretaker extends User {

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "caretakers", cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
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


