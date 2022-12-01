/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project2;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.mail.MessagingException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import procedure.process;
import static procedure.process.menu;
import procedure.sendEmail;

/**
 *
 * @author dilan
 */
public class Main {

    static Student studentData[];
    static Student studentGroupsData[];
    static int i = 0;

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws javax.mail.MessagingException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, MessagingException {

        menu(i);
    }

}
