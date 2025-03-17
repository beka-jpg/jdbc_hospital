package project.model;

import java.util.List;

public class Hospital {
    private int hospitalId;
    private String name;
    private String address;
    private List<Doctor> doctors;

    public Hospital() {};

    public Hospital(String name, String address, List<Doctor> doctors) {
        this.name = name;
        this.address = address;
        this.doctors = doctors;
    }

    public int getId() {
        return hospitalId;
    }

    public void setId(int id) {
        this.hospitalId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + hospitalId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", doctors=" + doctors +
                '}';
    }
}
