/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project2;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import static procedure.process.menu;

/**
 * En este programa se realiza, una lectura de un txt elegido por el usuario,
 * además de la creación de grupos y el envio por email.
 *
 * @author dilan
 * @author Jose Pablo
 */
public class Main {

    static int i;

    static Student studentData[];
    static Student studentGroupsData[];

    /**
     * Aqui se encuentra en donde se llama al menu en donde se ejecuta el
     * programa
     *
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException Por si no encuentra el archivo que
     * se anda buscando.
     * @throws javax.mail.MessagingException Por el metodo de mandar mensajes
     * por correo electronico.
     */
    public static void main(String[] args) throws FileNotFoundException,
            IOException, MessagingException {
        JOptionPane.showMessageDialog(null, "Bienvenido a Sibajitas Creating "
                + "Systems");
        menu(i);
        JOptionPane.showMessageDialog(null, "Gracias por usar el programa, "
                + "hasta pronto");

    }

}
