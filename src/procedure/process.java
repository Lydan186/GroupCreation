package procedure;

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
import project2.Student;

/**
 *
 * @author josep
 */
public class process {

    static Student studentGroupsData[];
    static Student studentData[];

    public static void menu(int i) throws IOException, MessagingException {

        int cases;

        String posi = JOptionPane.showInputDialog(null, "Digite la opción 1"
                + " si desea cargar el archivo \nDigite la opcion 2 si desea "
                + "ver la lista de estudiantes \nDigite la opcion 3 si desea"
                + " hacer los grupos de estudiantes \nDigite la opcion 4 "
                + " para enviar un correo con el archivo con los grupos"
                + " \nDigite la opcion 5 si desea salir del programa");

        cases = Integer.parseInt(posi);
        if (cases != 5) {
            switch (cases) {

                case 1:
                    txtReader();
                    break;
                case 2:
                    seeStudents(studentData, 0);
                    System.out.println(" ");
                    break;
                case 3:
                    groupMenu();
                    break;
                case 4:
                    sendEmail.sendMail();
                    break;
                case 5:

                    System.out.println("gracias");

                    break;

            }

            menu(cases);

        }

    }

    public static void seeStudents(Student studentData[], int i) {
        if (i != studentData.length) {
            System.out.println(studentData[i].getName());
            seeStudents(studentData, i + 1);
        }

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
                Student student = new Student(data[0], data[1], data[2], data[3], data[4], false);
                studentData = newVector(student, i);
                studentGroupsData = newVector(student, i);
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

                    groupCreationMenu();

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

    public static void groupCreationMenu() {
        int op2;

        do {
            String posi = JOptionPane.showInputDialog(null, "Digite la opción 1"
                    + " para generar grupos de forma aleatoria \nDigite la opcion 2 para "
                    + "generar grupos por genero \nDigite la opcion 3 para formar"
                    + " grupos por ubicación geografica \nDigite la opcion 4 para"
                    + " grupos por carnet \nDigite la opcion 5 para volver "
                    + " al menu anterior");

            op2 = Integer.parseInt(posi);

            switch (op2) {

                case 1:
                    try {

                    groupAssigment(groupCreation());

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;

                case 2:
                    groupGender(studentData);
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("gracias");
                    break;

            }

        } while (op2 != 5);

    }

    public static Student[] groupCreation() {

        int j = 0;
        Student[] copyArray = new Student[studentData.length];

        for (int i = 0; i < studentData.length; i++) {
            studentData[i].setState(false);
        }

        while (inspect()) {

            int randomStudent = (int) (Math.random() * copyArray.length);
            if (studentData[randomStudent].isState() == false) {

                studentData[randomStudent].setState(true);

                copyArray[j] = studentData[randomStudent];
                j++;

            }
        }
        return copyArray;
    }

    public static boolean inspect() {
        boolean find = false;

        for (int i = 0; i < studentData.length; i++) {
            if (studentData[i].isState() == false) {
                find = true;

            }
        }
        return find;
    }

    public static void groupAssigment(Student copyArray[]) throws IOException {

        String cantGroups = JOptionPane.showInputDialog(null, "Digite la cantidad de "
                + "grupos que desea formar");
        int cantG = Integer.parseInt(cantGroups);

        JFileChooser chooser = new JFileChooser();
        int initiate = 0;
        int finalize = (copyArray.length / cantG);
        int z = copyArray.length % cantG;
        Component parent = null;

        int returnVal = chooser.showSaveDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            try {
                File h = chooser.getSelectedFile();
                FileWriter write = new FileWriter(h, true);

                for (int i = 0; i < cantG; i++) {
                    write.write("Grupo de trabajo: " + (i + 1) + "\n");
                    if ((i + 1) == 1) {
                        for (int x = copyArray.length - z; x < copyArray.length; x++) {
                            write.write("Nombre: " + copyArray[x].getName() + " carnet: " + copyArray[x].getStudentId() + "\n");
                        }
                    }
                    for (int j = initiate; j < finalize; j++) {
                        write.write("Nombre: " + copyArray[j].getName() + " carnet: " + copyArray[j].getStudentId() + "\n");
                    }
                    initiate += copyArray.length / cantG;
                    finalize += copyArray.length / cantG;
                    write.write("\n");

                }
                write.close();
                JOptionPane.showMessageDialog(null, "Grupos guardados exitosamente");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
    
    
     public static void groupGender(Student[] student){
         
         
         
        JFileChooser chooser = new JFileChooser(); 
        Component parent = null;
        int returnVal = chooser.showSaveDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            
            try {
            File h = chooser.getSelectedFile();
             FileWriter write=new FileWriter(h,true);

            
            write.write(("Grupos por genero: "+ "\n" ));
                          
             write.write("Grupo: 1" + "\n");
              
             for (int j = 0; j < studentData.length; j++) {
                 
                 if (((studentData[j].getGender()).equals("M"))) {
                    write.write("Nombre: " + studentData[j].getName() + "    Carnet: " + studentData[j].getStudentId()+"\n");
                 }
                       
             }   
             write.write("\n");
 
            write.write("Grupo: 2"+"\n");
              
             for (int j = 0; j < studentData.length; j++) {
                 
                 if (((studentData[j].getGender()).equals("F"))) {
                    write.write("Nombre: " + studentData[j].getName() + "    Carnet: " + studentData[j].getStudentId()+"\n");
                 }
                       
             }   
             write.write("\n");   
            write.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------");
        }
    }
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
             
             
            
                                   
     }
    
    
    

}
