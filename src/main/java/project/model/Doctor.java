package project.model;

import java.util.List;

public class Doctor {
    private int doctorId;
    private String name;
    private String position;
    private int experience;
    private List<Patient> patients;

    public Doctor(String name, String position, int experience) {
        this.name = name;
        this.position = position;
        this.experience = experience;
    }

    public Doctor() {
    }

    public int getId() {
        return doctorId;
    }

    public void setId(int id) {
        this.doctorId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + doctorId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", experience=" + experience +
                ", patients=" + patients +
                '}';
    }
}
