package ro.ebs.internship.alzheimer.entity;

public class Relation {

    private String patient;
    private String caretaker;

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getCaretaker() {
        return caretaker;
    }

    public void setCaretaker(String caretaker) {
        this.caretaker = caretaker;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "patient='" + patient + '\'' +
                ", caretaker='" + caretaker + '\'' +
                '}';
    }
}
