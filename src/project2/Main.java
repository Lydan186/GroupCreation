/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.mail.MessagingException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import procedure.sendEmail;

/**
 *
 * @author dilan
 */
public class Main {

    static Student studentData[];
    static boolean exit = false;
    static String[] data;

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws javax.mail.MessagingException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, MessagingException {

        menu(exit);
    }

    public static void menu(boolean exit) throws IOException, MessagingException {
        exit = false;
        int cases;
        if (exit = false) {

        }
        do {
            String posi = JOptionPane.showInputDialog(null, "Digite la opción 1"
                    + " si desea cargar el archivo \nDigite la opcion 2 si desea "
                    + "ver la lista de estudiantes \nDigite la opcion 3 si desea"
                    + " hacer los grupos de estudiantes \nDigite la opcion 4 "
                    + " para enviar un correo con el archivo con los grupos"
                    + " \nDigite la opcion 5 si desea salir del programa");

            cases = Integer.parseInt(posi);

            switch (cases) {

                case 1:
                    txtReader();
                    break;
                case 2:
                    seeStudents(studentData, 0);
                    System.out.println(" ");
                    break;
                case 3:

                    break;
                case 4:
                    sendEmail.sendMail();
                    break;
                case 5:
                    exit = true;
                    System.out.println("gracias");

                    break;

            }
menu(exit = true);
        } while (exit = false);
        

    }
/**
 * Procedimiento para poder ver a los datos de los estudiantes.
 * @param studentData
 * @param i 
 */
    public static void seeStudents(Student studentData[], int i) {
        if (i != studentData.length) {
            System.out.println(studentData[i].toString());
            seeStudents(studentData, i + 1);
        }

    }
/**
 * Procedimiento para elegir un archivo.
 * @throws FileNotFoundException
 * @throws IOException 
 */
    public static void txtReader() throws FileNotFoundException, IOException {

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("txt", "txt");
        chooser.setFileFilter(txtFilter);
        chooser.showOpenDialog(chooser);
        chooser.getSelectedFile();
        System.out.println("Se subio el registro");
        split(chooser.getSelectedFile());
    }
/**
 * Procedimiento para dividir un archivo y guardarlo en un array.
 * @param chooser
 * @throws FileNotFoundException
 * @throws IOException 
 */
    public static void split(File chooser) throws FileNotFoundException, IOException {
        int i = 0;
        String strCurrentLine;

        BufferedReader objReader = new BufferedReader(new FileReader(chooser.getAbsolutePath()));
        while ((strCurrentLine = objReader.readLine()) != null) {
            try {
                String[] data;
                data = strCurrentLine.split(",");
                Student student = new Student(data[0], data[1], data[2], data[3], data[4]);
                studentData = newVector(student, i);
                i++;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }
/**
 * Procedimiento para copiar un archivo y aumentar el tamaño del vector.
 * @param student
 * @param i
 * @return 
 */
    private static Student[] newVector(Student student, int i) {

        Student[] copyStudend = new Student[i + 1];
        copyStudend[i] = student;
        if (i >= 1) {
            for (int j = 0; j < studentData.length; j++) {
                copyStudend[j] = studentData[j];
            }
            copyStudend[i] = student;
        }
        return copyStudend;
    }
/**
 * Procedimiento para poder visualizar un menu para los grupos de estudiantes.
 */
    public static void groupMenu() {
        int op;
        do {
            String posi = JOptionPane.showInputDialog(null, "Digite la opción 1"
                    + " si desea crear un grupo de trabajo \nDigite la opcion 2 si desea "
                    + "ver la lista de grupos formados \nDigite la opcion 3 si desea"
                    + " editar algunos de los grupos disponibles \nDigite la opcion 4 si"
                    + " desea volver al menu principal");

            op = Integer.parseInt(posi);

            switch (op) {

                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("gracias");
                    break;

            }

        } while (op != 4);

    }

}
