/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursionjune2019;

import java.io.File;
import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class SizeOfDirectory {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a directory or a file:");
        String directoryName = sc.nextLine();

        System.out.println(getSize(new File(directoryName)) + " bytes");
    }

    private static long getSize(File file) {

        long size = 0; // store the total size of all files and subDirectories inside the directory 

        if (file.isDirectory()) {
            File[] arr = file.listFiles(); // Returns an array contains all files and directories in the big directory

            for (int i = 0; arr != null && i < arr.length; i++) {
                size += getSize(arr[i]); // recursive call
            }
        } else {
            size += file.length();
        }

        return size;
    }
}
