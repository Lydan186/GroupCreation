/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

/**
 * Esta clase guarda los constructores de los estudiantes.
 *
 * @author dilan
 */
public class Student {

    private boolean state;

    private String email;
    private String gender;
    private String geographicLocation;
    private String name;
    private String studentId;

    public Student() {
    }

    /**
     *Constructor encargado de llamar todas las variables.
     * @param studentId Carnet de estudiante.
     * @param name Nombre.
     * @param email Correo electronico.
     * @param gender Genero.
     * @param geographicLocation Ubicación geografica.
     * @param state Estado.
     */
    public Student(String studentId, String name, String email, String gender, String geographicLocation, boolean state) {

        this.state = state;
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.studentId = studentId;
        this.geographicLocation = geographicLocation;
    }

    /**
     * Constructor encargado de obtener el booleano de state.
     *
     * @return the state
     */
    public boolean isState() {
        return state;
    }

    /**
     * Constructor encargado de establecer el state.
     *
     * @param state the state to set
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * Constructor encargado de obtener el email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Constructor encargado de establecer el email.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Constructor encargado de obtener el name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Constructor encargado de establecer el name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Constructor encargado de obtener el gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Constructor encargado de establecer el gender.
     *
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Constructor encargado de obtener el studentId.
     *
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Constructor encargado de establecer el studentId.
     *
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Constructor encargado de obtener el geographicLocation.
     *
     * @return the geographicLocation
     */
    public String getGeographicLocation() {
        return geographicLocation;
    }

    /**
     * Constructor encargado de establecer el geographicLocation.
     *
     * @param geographicLocation the geographicLocation to set
     */
    public void setGeographicLocation(String geographicLocation) {
        this.geographicLocation = geographicLocation;
    }

    /**
     * Constructor encargado de sobreescribir los datos de las variables.
     *
     * @return Los datos ya sobreescritos.
     */
    @Override
    public String toString() {
        return " Carnet: " + studentId + ", Nombre; " + name + ", Correo Institucional: " + email + ", Genero: " + gender + ", Ubicación Geografica" + geographicLocation;
    }

}
