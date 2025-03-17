package project.model;

public class Patient {
    private int patientId;
    private String name;
    private int age;
    private GENDER gender;
    private String diagnose;

    public Patient(String name, int age, GENDER gender, String diagnose) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.diagnose = diagnose;
    }





    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }



    public Patient() {


    }

    public int getId() {
        return patientId;
    }

    public void setId(int id) {
        this.patientId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + patientId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", diagnose='" + diagnose + '\'' +
                '}';
    }
}
