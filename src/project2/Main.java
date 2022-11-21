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
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dilan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String posi = JOptionPane.showInputDialog(null, "Digite la opción 1"
                + "si desea cargar el archivo \nDigite la opcion 2 si desea "
                + "ver la lista de estudiantes \nDigite la opcion 3 si desea"
                + " hacer los grupos de estudiantes \nDigite la opcion 4 si"
                + " desea salir del programa");

        int cases = Integer.parseInt(posi);
        switch (cases) {

            case 1:
                JFileChooser file = new JFileChooser();
                file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("txt", "txt");
                file.setFileFilter(txtFilter);
                file.showOpenDialog(file);
                File files = file.getSelectedFile();
                
                break;
            case 2:
//                BufferedReader reader = new BufferedReader(new FileReader(files));
//                String strCurrentLine;
//                while ((strCurrentLine = reader.readLine()) != null) {
//                    System.out.println(strCurrentLine);
//                }
//                System.out.println(strCurrentLine);
                break;
            case 3:
                list();
                break;
            case 4:
                break;

        }



    }
        public static void list() throws FileNotFoundException, IOException{
        
        
                String pos = JOptionPane.showInputDialog(null, "Digite la opción a elegir");

        int number = Integer.parseInt(pos);
        switch (number) {

            case 1:
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\dilan\\OneDrive\\Documentos\\cursos de la UCR\\programación 1\\reporte.txt"));
                String strCurrentLine;

                while ((strCurrentLine = reader.readLine()) != null) {
                    System.out.println(strCurrentLine);
                }
                System.out.println(strCurrentLine);
                break;

        }
        
        }

}
