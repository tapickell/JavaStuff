/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package splittextfilebysentences;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author todd
 */

public class SplitTextFileBySentences {

    /**
     * @param args the command line arguments
     * @throws FileNotFoundException  
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        Boolean flag = true;
        
        while(flag)
        {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter filename: ");
            String filePath = keyboard.nextLine();
            File fileIn = new File(filePath);

            if(fileIn.exists())
            {
                Scanner inputFile = new Scanner(fileIn);
                //inputFile.useDelimiter(".");

                String fileOutName = filePath.replace(".txt", "Split.txt");
                
                File fileOut = new File(fileOutName);

                if(fileOut.exists())
                {
                    System.err.println(fileOutName + " Already Exists!");
                    return;
                }

                PrintWriter outputFile = new PrintWriter(fileOut);

                int lineCount = 1;

                while(inputFile.hasNext())
                {
                    String str = inputFile.nextLine();
                    String[] temp;
                    String delimiter = "\\. ";
                    temp = str.split(delimiter);
                    for(int i = 0; i < temp.length; i++)
                    {
                        outputFile.println(lineCount + "  " + temp[i] + ". \n");
                        lineCount++;
                    }
                }
                inputFile.close();
                outputFile.close();
            }
            else
            {
                System.err.println(filePath + " Doesn't Exist!");
            }
            
            System.out.println("Want to split more files?");
            String answer = keyboard.nextLine();
            if(!answer.startsWith("Y") || !answer.startsWith("y"))
            {
                System.exit(0);
            }
        }
        
        
        
        
    }
}
