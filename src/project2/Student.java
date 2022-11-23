/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

/**
 *
 * @author dilan
 */
public class Student{
        private String name;
    private String gender;
    private String email;
    private String studentId;
    private String geographicLocation;

    public Student() {
    }

    public Student(String name, String gender, String email, String studentId, String geographicLocation) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.studentId = studentId;
        this.geographicLocation = geographicLocation;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the geographicLocation
     */
    public String getGeographicLocation() {
        return geographicLocation;
    }

    /**
     * @param geographicLocation the geographicLocation to set
     */
    public void setGeographicLocation(String geographicLocation) {
        this.geographicLocation = geographicLocation;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", gender=" + gender + ", email=" + email + ", studentId=" + studentId + ", geographicLocation=" + geographicLocation + '}';
    }

    
    
}
