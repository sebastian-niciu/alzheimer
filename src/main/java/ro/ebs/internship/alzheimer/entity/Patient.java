package ro.ebs.internship.alzheimer.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "T_PATIENT")
public class Patient extends User {

    @ManyToMany(fetch = FetchType.EAGER, cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Caretaker> caretakers;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
    private List<Location> locations;

    public Set<Caretaker> getCaretakers() {
        return caretakers;
    }

    public void setCaretakers(Set<Caretaker> caretakers) {
        this.caretakers = caretakers;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Patient{" +
                ", locations=" + locations +
                "} " + super.toString();
    }
}
