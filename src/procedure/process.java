
package procedure;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import project2.Student;

/**
 *
 * @author josep
 */
public class process {
    
            static Student studentData[];
            
            
//     public static void txtReader(File files) throws FileNotFoundException, IOException{
//                  
//                JFileChooser chooser = new JFileChooser();
//                
//                  Component parent = null;
//                  int returnVal = chooser.showOpenDialog(parent);
//                  if (returnVal == JFileChooser.APPROVE_OPTION) {
//                  System.out.println("Se subio el registro: "
//                    + chooser.getSelectedFile().getName());
//                  System.out.println("-------------------------------------------");
//        }
//                
////                JFileChooser file = new JFileChooser();
////                file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
////                FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("txt", "txt");
////                file.setFileFilter(txtFilter);
////                file.showOpenDialog(file);
////                File files = file.getSelectedFile();
//                  split (chooser.getSelectedFile());
//                
//                
//                
//   }
//     
//     
//     public static void split(File files) throws FileNotFoundException, IOException{
//     int i=0;
//     BufferedReader objReader = null;
//                 String strCurrentLine;
//                
//                objReader = new BufferedReader(new FileReader(files.getAbsolutePath()));
//                while ((strCurrentLine = objReader.readLine()) != null) {
//                String datos [] =strCurrentLine.split(",");
//                Student student=new Student(datos [0], datos [1], datos [2], datos [3], datos [4]);
//               
//                studentData = newVector(student, i);
//                i++;
//                
//     }
//     
//     
//     }
//     
//     
//     private static Student[] newVector(Student student,  int i) {
//           
//            Student[] copyStudend = new Student[i + 1];
//            copyStudend [i] = student;
//            if (i>=1) {
//                for (int j = 0; j < studentData.length; j++) {
//                     copyStudend[j] = studentData[j];
//                }
//                copyStudend [i] = student;
//             }
//            return copyStudend;
//    }
//     
//     
//     
//     public static void txtPrint() throws IOException{
//         
//                
//    /*
//         BufferedReader reader = new BufferedReader(new FileReader(files));
//                String strCurrentLine;
//                while ((strCurrentLine = reader.readLine()) != null) {
//                    System.out.println(strCurrentLine);
//                }
//                System.out.println(strCurrentLine);
//         */        
//                
//         
//     }
//     
    
}
