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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dilan
 */
public class Main {

    static Student studentData[];

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        int cases;
        do {
            String posi = JOptionPane.showInputDialog(null, "Digite la opción 1"
                    + " si desea cargar el archivo \nDigite la opcion 2 si desea "
                    + "ver la lista de estudiantes \nDigite la opcion 3 si desea"
                    + " hacer los grupos de estudiantes \nDigite la opcion 4 si"
                    + " desea salir del programa");

            cases = Integer.parseInt(posi);

            switch (cases) {

                case 1:
                    txtReader();
                    break;
                case 2:
                    for (int i = 0; i < studentData.length; i++) {
                        System.out.println(studentData[i].toString());
                    }
                    
                    System.out.println(" ");
                    break;
                case 3:
                      groupMenu();
                    break;
                case 4:
                    System.out.println("gracias");
                    break;

            }

        } while (cases != 4);
    }

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

    public static void split(File chooser) throws FileNotFoundException, IOException {
        int i = 0;
        String strCurrentLine;

        BufferedReader objReader = new BufferedReader(new FileReader(chooser.getAbsolutePath()));
        while ((strCurrentLine = objReader.readLine()) != null) {
            try {
                String[] data;
                data = strCurrentLine.split(",");
              //
              System.out.println(strCurrentLine);
                Student student = new Student(data[0], data[1], data[2], data[3], data[4]);
                System.out.println(i);
                studentData = newVector(student, i);
                i++;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

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
    
    
    public static void groupMenu(){
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
