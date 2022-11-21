/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

/**
 *
 * @author dilan
 */
public class Student extends Person{
    private String studentId;
    private String geographicLocation;

    public Student() {
    }

    public Student(String studentId, String geographicLocation) {
        this.studentId = studentId;
        this.geographicLocation = geographicLocation;
    }

    public Student(String studentId, String geographicLocation, String name, 
            String gender, String email) {
        super(name, gender, email);
        this.studentId = studentId;
        this.geographicLocation = geographicLocation;
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
        return super.toString()+"Student{" + "studentId=" + studentId + 
                ", geographicLocation=" + geographicLocation + '}';
    }
    
}
