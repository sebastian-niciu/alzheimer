package ro.ebs.internship.alzheimer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Patient patient;

    @Column
    private String latitude;

    @Column
    private String longitude;

    @Column
    private Long timestamp;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;}

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", patient=" + patient +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
