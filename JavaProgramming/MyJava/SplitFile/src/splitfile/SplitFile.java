/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package splitfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author todd
 */
public class SplitFile {

    /**
     * @param args the command line arguments
     * @throws FileNotFoundException  
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter filename: ");
        String filePath = keyboard.nextLine();
        File fileIn = new File(filePath);
        
        if(!fileIn.exists())
        {
            System.out.println(filePath + " Doesn't Exist!");
            System.out.println("Enter filename: ");
            filePath = keyboard.nextLine();
            fileIn = new File(filePath);
            
        }
        
        Scanner inputFile = new Scanner(fileIn);
        inputFile.useDelimiter(".  ");

        String fileOutName = "Split" + filePath;
        File fileOut = new File(fileOutName);

        if(fileOut.exists())
        {
            System.out.println(fileOutName + " Already Exists!");
            System.out.println("Enter new filename: ");
            fileOutName = keyboard.nextLine();
            fileOut = new File(fileOutName);
        }

        PrintWriter outputFile = new PrintWriter(fileOut);

        int lineCount = 1;

        while(inputFile.hasNext())
        {
            outputFile.println(lineCount + inputFile.next() + ".");
            lineCount++;
        }
    }
}
///Volumes/MacBookXtrnl/Dropbox/ColumbiaCollege/JavaProgramming/MyJava/SplitFile/src/splitfile/TextFile.txt
//
///Users/todd/Downloads/WeDrove.txt