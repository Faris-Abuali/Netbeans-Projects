/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesjune2019;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Fares Abu Ali
 */
public class TestForReplaceText {

    public static void main(String[] args) throws FileNotFoundException {

//        File sourceFile = new File("sourceFile.txt");
//        File targetFile = new File("targetFile.txt");


        String[] a = new String[]{"sourceFile.txt", "targetFile.txt", "Fares", "Haneen"};

        ReplaceText.main(a); // sourceFile,targetFile,oldText,newText

    }

}
