/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author Ivan Almada
 */

public class UseDataStructures {
    
    /*
    * Clase de Uso del Paquete Data Structures.
    */
    
    public static void main(String[] args) {
        
        try {
            Set dictionary = SyntaxVerificator.readWords(new FileReader("dicc.txt"), 20);
            Set text = SyntaxVerificator.readWords(new FileReader("text.txt"), 20);
            Set result = text.difference(dictionary);

            System.out.println("\n The incorrect words are: \n");
            
            Iterator e = result.iterator();
            int cont = 0;
            
            while (e.hasNext()) {
                System.out.print(e.next() + " ");
                if (cont == 10) {
                    System.out.println();
                } else {
                    cont++;
                }
            }
            
        } catch (IOException ioe) {
            System.err.println("IO Exception triggered. Most probably didn't found the text files.\n"
            + "Please copy them to the package root.");
        }
        
    }

}
