package procedure;

import java.awt.Component;
import java.awt.HeadlessException;
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
 * Clase en donde se encuentran todos los procedimientos del sistema.
 *
 * @author josep
 */
public class process {

    static Student studentData[];
    static Student studentGroupsData[];
    static int cases;
    static int op;
    static int op2;

    /**
     * Procedimiento menu encardado de generar el menu principal que brindara
     * todas las opciones al usuario sobre lo que desea realizar
     *
     * @param i para guardar el numero elegido en el menu.
     * @throws IOException si no elige una opción dentro de las existentes.
     * @throws MessagingException Por el metodo de mandar mensajes por correo
     * electronico.
     */
    public static void menu(int i) throws IOException, MessagingException {
        try {

            String posi = JOptionPane.showInputDialog(null, "Digite la opción que "
                    + "desea utilizar \nDigite la opción 1"
                    + " si desea cargar el archivo \nDigite la opcion 2 si desea "
                    + "ver la lista de estudiantes \nDigite la opcion 3 si desea"
                    + " hacer los grupos de estudiantes \nDigite la opcion 4 "
                    + " para enviar un correo con el archivo con los grupos"
                    + " \nDigite la opción 5 si desea leer el manual de usuario. \n"
                    + "Digite la opcion 6 si desea salir del programa");

            cases = Integer.parseInt(posi);
            if (cases != 6) {
                switch (cases) {

                    case 1:
                        txtReader();
                        break;
                    case 2:
                        menu2(i);
//                    seeStudents(studentData, 0);
//                    System.out.println(" ");
                        break;
                    case 3:
                        groupMenu(op);
                        break;
                    case 4:
                        sendEmail.sendMail();
                        break;
                    case 5:
                        handBook();
                        break;
                    case 6:
                        break;

                }

                menu(cases);

            }
        } catch (HeadlessException headlessException) {
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "Favor digitar un numero dentro"
                    + " de las opciones");
            menu(cases);
        } catch (IOException iOException) {
        } catch (MessagingException messagingException) {
        }
    }

    /**
     * Procedimiento menu encardado de generar el menu donde se decide como se
     * presentaran los datos
     *
     * @param i para guardar el numero elegido en el menu.
     * @throws IOException si no elige una opción dentro de las existentes.
     * @throws MessagingException Por el metodo de mandar mensajes por correo
     * electronico.
     */
    public static void menu2(int i) throws IOException, MessagingException {
        try {

            String posi = JOptionPane.showInputDialog(null, "Digite la opción "
                    + "que "
                    + "desea utilizar \nDigite la opción 1"
                    + " si desea ver la lista completa \nDigite la opcion 2 si "
                    + "desea "
                    + "ver solo los nombres de los estudiantes de la lista "
                    + "\nDigite"
                    + " la opcion 3 si desea"
                    + " ver solo las ubicaciones de los estudiantes de la lista"
                    + " \nDigite la opción 4 si desea ver los carnets de los "
                    + "estudiantes de la lista \nDigite la opción 5 si deser "
                    + "ver "
                    + "el genero de los estudiantes de la lista \nDigite la "
                    + "opción "
                    + "6 si desea volver al menu anterior.");

            cases = Integer.parseInt(posi);
            if (cases != 6) {
                switch (cases) {

                    case 1:
                        System.out.println("--------------------------------");
                        seeStudentsComplete(studentData, 0);
                        break;
                    case 2:
                        System.out.println("--------------------------------");
                        seeStudentsName(studentData, 0);
                        break;
                    case 3:
                        System.out.println("--------------------------------");
                        seeStudentsUbications(studentData, 0);
                        break;
                    case 4:
                        System.out.println("--------------------------------");
                        seeStudentsId(studentData, 0);
                        break;
                    case 5:
                        System.out.println("--------------------------------");
                        seeStudentsGender(studentData, 0);
                        break;
                    case 6:
                        break;
                }

                menu2(cases);

            }
        } catch (HeadlessException headlessException) {
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "Favor digitar un numero dentro"
                    + " de las opciones");
            menu2(cases);
        } catch (IOException iOException) {
        } catch (MessagingException messagingException) {
        }
    }

    /**
     * Este metodo llama a un txt que esta en una dirección establecida, el cual
     * muestra un manual de usuario.
     *
     * @throws IOException Por si el archivo no esta en la ubicación
     * correspondiente
     */
    public static void handBook() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\"
                + "Users\\dilan\\OneDrive\\Escritorio\\Manual de "
                + "Usuario.txt"));
        String strCurrentLine;

        while ((strCurrentLine = reader.readLine()) != null) {
            System.out.println(strCurrentLine);
        }

        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException ex) {

        }

    }

    /**
     * procedimiento encargado de imprimir la lista de los nombres de lo
     * estudiantes DiscoDurodeRoer. (2016, 16 agosto). Ejercicios Java -
     * Recursividad #2 - Recorriendo un array recursivamente [Vídeo]. YouTube.
     * https://www.youtube.com/watch?v=I_iGTfc7Uoo
     *
     * @param studentData Es el vector en donde se guardan los estudiantes.
     * @param i Es una variable para que avance el vector.
     */
    public static void seeStudentsName(Student studentData[], int i) {
        if (i != studentData.length) {
            System.out.println(studentData[i].getName());
            seeStudentsName(studentData, i + 1);
        }

    }

    /**
     * procedimiento encargado de imprimir la lista de los carnets de los
     * estudiantes DiscoDurodeRoer. (2016, 16 agosto). Ejercicios Java -
     * Recursividad #2 - Recorriendo un array recursivamente [Vídeo]. YouTube.
     * https://www.youtube.com/watch?v=I_iGTfc7Uoo
     *
     * @param studentData Es el vector en donde se guardan los estudiantes.
     * @param i Es una variable para que avance el vector.
     */
    public static void seeStudentsId(Student studentData[], int i) {
        if (i != studentData.length) {

            System.out.println(studentData[i].getStudentId());
            seeStudentsId(studentData, i + 1);
        }

    }

    /**
     * procedimiento encargado de imprimir la lista de las ubicaciones
     * geograficas de los estudiantes DiscoDurodeRoer. (2016, 16 agosto).
     * Ejercicios Java - Recursividad #2 - Recorriendo un array recursivamente
     * [Vídeo]. YouTube. https://www.youtube.com/watch?v=I_iGTfc7Uoo
     *
     * @param studentData Es el vector en donde se guardan los estudiantes.
     * @param i Es una variable para que avance el vector.
     */
    public static void seeStudentsUbications(Student studentData[], int i) {
        if (i != studentData.length) {

            System.out.println(studentData[i].getGeographicLocation());
            seeStudentsUbications(studentData, i + 1);
        }

    }

    /**
     * procedimiento encargado de imprimir la lista de los generos de los
     * estudiantes DiscoDurodeRoer. (2016, 16 agosto). Ejercicios Java -
     * Recursividad #2 - Recorriendo un array recursivamente [Vídeo]. YouTube.
     * https://www.youtube.com/watch?v=I_iGTfc7Uoo
     *
     * @param studentData Es el vector en donde se guardan los estudiantes.
     * @param i Es una variable para que avance el vector.
     */
    public static void seeStudentsGender(Student studentData[], int i) {
        if (i != studentData.length) {

            System.out.println(studentData[i].getGender());
            seeStudentsGender(studentData, i + 1);
        }

    }

    /**
     * procedimiento encargado de imprimir la lista completa de estudiantes
     * DiscoDurodeRoer. (2016, 16 agosto). Ejercicios Java - Recursividad #2 -
     * Recorriendo un array recursivamente [Vídeo]. YouTube.
     * https://www.youtube.com/watch?v=I_iGTfc7Uoo
     *
     * @param studentData Es el vector en donde se guardan los estudiantes.
     * @param i Es una variable para que avance el vector.
     */
    public static void seeStudentsComplete(Student studentData[], int i) {
        if (i != studentData.length) {

            System.out.println(studentData[i].toString());
            seeStudentsComplete(studentData, i + 1);
        }

    }

    /**
     * Procedimiento txtReader encardado de de permitir al usuario de elegir el
     * archivo con los datos de los estudiantes con los cuales va a trabajar.
     *
     * @throws FileNotFoundException Por si no encuentra el archivo que se anda
     * buscando.
     * @throws IOException Por si no se elige un archivo.
     */
    public static void txtReader() throws FileNotFoundException, IOException {

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("txt",
                "txt");
        chooser.setFileFilter(txtFilter);
        chooser.showOpenDialog(chooser);
        chooser.getSelectedFile();
        System.out.println("Se subio el registro");
        split(chooser.getSelectedFile());
    }

    /**
     * procedimiento split que realiza la divicion de cada dato en el archivo
     * txt
     *
     * @param chooser Variable en donde se encuentra el archivo escogido.
     * @throws FileNotFoundException Por si no se encuentra el archivo.
     * @throws IOException Por si hay un error a la hora de registrar los datos.
     */
    public static void split(File chooser) throws FileNotFoundException,
            IOException {
        int i = 0;
        String strCurrentLine;

        BufferedReader objReader = new BufferedReader(new FileReader
        (chooser.getAbsolutePath()));
        while ((strCurrentLine = objReader.readLine()) != null) {
            try {
                String[] data;
                data = strCurrentLine.split(",");
                Student student = new Student(data[0], data[1], data[2], 
                        data[3], data[4], false);
                studentData = newVector(student, i);
                studentGroupsData = newVector(student, i);
                i++;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

    /**
     * newVector se encarga de realizar una copia de los datos del txt para
     * almacenarlos en un array
     *
     * @param student Para utilizar la clase student.
     * @param i Variable para recorrer el vector.
     * @return La copia del vector.
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
     * groupMenu Se encargar de gestionar las opciones a la hora de gestionar
     * los grupos
     *
     * @param i para guardar el numero elegido en el menu.
     * @throws IOException si no elige una opción dentro de las existentes.
     */
    public static void groupMenu(int i) throws IOException {
        try {

            String posi = JOptionPane.showInputDialog(null, "Digite la opción 1"
                    + " si desea crear un grupo de trabajo \nDigite la opcion 2"
                    + " si desea "
                    + "ver la lista de algun grupo formado \nDigite la opcion 3"
                    + " si"
                    + " desea volver al menu principal");

            op = Integer.parseInt(posi);
            if (op != 3) {

                switch (op) {

                    case 1:

                        groupCreationMenu(op2);

                        break;
                    case 2:

                        readGroup();
                        break;
                    case 3:

                        System.out.println("gracias");
                        break;

                }

                groupMenu(op);
            }

        } catch (HeadlessException headlessException) {
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "Favor digitar un numero dentro"
                    + " de las opciones");
            groupMenu(op);
        } catch (IOException iOException) {
        }

    }

    /**
     * Menu creado para poder realizar de distintas formas los grupos de
     * estudiantes
     */
    public static void groupCreationMenu(int i) {
        try {

            String posi = JOptionPane.showInputDialog(null, "Digite la opción 1"
                    + " para generar grupos de forma aleatoria \nDigite la "
                    + "opcion 2 para "
                    + "generar grupos por genero \nDigite la opcion 3 para "
                    + "formar"
                    + " grupos por ubicación geografica \nDigite la opcion 4 "
                    + "para"
                    + " para volver al menu anterior");

            op2 = Integer.parseInt(posi);
            if (op2 != 4) {

                switch (op2) {

                    case 1:
                    try {

                        groupAssigment(groupCreation());

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                    case 2:
                        JOptionPane.showMessageDialog(null, "Selecione el "
                                + "archivo "
                                + "txt con el grupo que desea verificar");
                        groupGender(studentData);
                        break;
                    case 3:
                        geographicalGroup(studentData);
                        break;
                    case 4:
                        System.out.println("gracias");
                        break;

                }
                groupCreationMenu(op2);
            }
        } catch (HeadlessException headlessException) {
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "Favor digitar un numero dentro"
                    + " de las opciones");
            groupCreationMenu(op2);
        }
    }

    /**
     * Proceso groupCreation que genera un txt con la cantidad de grupos
     * deseados en los cuales se formaran por estudiantes aleatorios.
     *
     * @return El copyArray en donde se guarda la información copia del array
     * studentData.
     */
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

    /**
     * verifica el estado bo0oleano del estudiante para poder ser añadido a un
     * grupo
     *
     * @return El valor find como verdadero.
     */
    public static boolean inspect() {
        boolean find = false;

        for (int i = 0; i < studentData.length; i++) {
            if (studentData[i].isState() == false) {
                find = true;

            }
        }
        return find;
    }

    /**
     * procedimiento principal de la formacion de grupos aleatorios en el cual
     * se pide la cantidad de grupos que se formaran y crear el txt del grupo
     *
     * @param copyArray Llamada de parametro del vector copia de studentData.
     * @throws IOException Por si no indica la cantidad de grupos.
     */
    public static void groupAssigment(Student copyArray[]) throws IOException {

        String cantGroups = JOptionPane.showInputDialog(null, "Digite la "
                + "cantidad de "
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
                        for (int x = copyArray.length - z; x < copyArray.length;
                                x++) {
                            write.write("Nombre: " + copyArray[x].getName()
                                    + " carnet: " + copyArray[x].getStudentId()
                                    + "\n");
                        }
                    }
                    for (int j = initiate; j < finalize; j++) {
                        write.write("Nombre: " + copyArray[j].getName()
                                + " carnet: " + copyArray[j].getStudentId()
                                + "\n");
                    }
                    initiate += copyArray.length / cantG;
                    finalize += copyArray.length / cantG;
                    write.write("\n");

                }
                write.close();
                JOptionPane.showMessageDialog(null, "Grupos guardados "
                        + "exitosamente");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    /**
     * proceso para crear grupos con forme al genero de los estudiantes
     *
     * @param student Para llamar a la clase student.
     */
    public static void groupGender(Student[] student) {

        JFileChooser chooser = new JFileChooser();
        Component parent = null;
        int returnVal = chooser.showSaveDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            try {
                File h = chooser.getSelectedFile();
                FileWriter write = new FileWriter(h, true);

                write.write(("Grupos por genero: " + "\n"));

                write.write("Grupo: 1" + "\n");

                for (int j = 0; j < studentData.length; j++) {

                    if (((studentData[j].getGender()).equals("M"))) {
                        write.write("Nombre: " + studentData[j].getName()
                                + "    Carnet: " + studentData[j].getStudentId()
                                + "\n");
                    }

                }
                write.write("\n");

                write.write("Grupo: 2" + "\n");

                for (int j = 0; j < studentData.length; j++) {

                    if (((studentData[j].getGender()).equals("F"))) {
                        write.write("Nombre: " + studentData[j].getName()
                                + "    Carnet: " + studentData[j].getStudentId()
                                + "\n");
                    }

                }
                write.write("\n");
                write.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("-----------------------------------------");
            }
        }

    }

    /**
     * procedimiento para crear los grupos de estudiantes en base a su ubicacion
     * geografica
     *
     * @param student Para llamar a la clase student.
     */
    public static void geographicalGroup(Student[] student) {

        JFileChooser chooser = new JFileChooser();
        Component parent = null;
        int returnVal = chooser.showSaveDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            try {
                File h = chooser.getSelectedFile();
                FileWriter write = new FileWriter(h, true);

                write.write(("Grupos por ubicacion Geografica: " + "\n"));

                write.write("Grupo: Golfito" + "\n");

                for (int j = 0; j < studentData.length; j++) {

                    if (((studentData[j].getGeographicLocation()).
                            equals("Golfito"))) {
                        write.write("Nombre: " + studentData[j].getName()
                                + "    Carnet: " + studentData[j].getStudentId()
                                + "\n");
                    }

                }
                write.write("\n");

                write.write("Grupo: Rio Claro" + "\n");

                for (int j = 0; j < studentData.length; j++) {

                    if (((studentData[j].getGeographicLocation()).
                            equals("Rio Claro"))) {
                        write.write("Nombre: " + studentData[j].getName()
                                + "    Carnet: " + studentData[j].getStudentId()
                                + "\n");
                    }

                }
                write.write("\n");

                write.write("Grupo: Corredores" + "\n");

                for (int j = 0; j < studentData.length; j++) {

                    if (((studentData[j].getGeographicLocation()).
                            equals("Corredores"))) {
                        write.write("Nombre: " + studentData[j].getName()
                                + "    Carnet: " + studentData[j].getStudentId()
                                + "\n");
                    }

                }
                write.write("\n");

                write.write("Grupo: San vito" + "\n");

                for (int j = 0; j < studentData.length; j++) {

                    if (((studentData[j].getGeographicLocation()).
                            equals("San vito"))) {
                        write.write("Nombre: " + studentData[j].getName()
                                + "    Carnet: " + studentData[j].getStudentId()
                                + "\n");
                    }

                }
                write.write("\n");

                write.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("-----------------------------------------");
            }
        }

    }

    /**
     * proceso para leer e imprimir un grupo ya formado
     *
     * @throws IOException Excepción por si se sale sin leer algun archivo.
     */
    public static void readGroup() throws IOException {

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter txtFilter = new FileNameExtensionFilter
        ("txt", "txt");
        chooser.setFileFilter(txtFilter);
        chooser.showOpenDialog(chooser);
        chooser.getSelectedFile();
        System.out.println("Se subio el registro");

        String strCurrentLine;
        int i = 0;
        BufferedReader objReader = new BufferedReader
        (new FileReader(chooser.getSelectedFile()));
        while ((strCurrentLine = objReader.readLine()) != null) {
            try {
                String[] data;
                //
                System.out.println(strCurrentLine);
                i++;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

}
