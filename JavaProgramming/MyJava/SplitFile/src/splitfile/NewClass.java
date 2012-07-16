/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package splitfile;

/**
 *
 * @author todd
 */
public class NewClass {
     System.out.println("");
  str = "one.two.three";
  delimiter = "\\.";
  temp = str.split(delimiter);
  for(int i =0; i < temp.length ; i++)
    System.out.println(temp[i]);
    
    
    
     /* String to split. */
  String str = "one-two-three";
  String[] temp;
 
  /* delimiter */
  String delimiter = "-";
  /* given string will be split by the argument delimiter provided. */
  temp = str.split(delimiter);
  /* print substrings */
  for(int i =0; i < temp.length ; i++)
    System.out.println(temp[i]);
}
