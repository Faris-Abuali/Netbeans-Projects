/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesdecember;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class StudentsMarks {

    public static void main(String[] args) {

        HashMap<Character, ArrayList<String>> map = new HashMap<>();

        File f = new File("marks.txt");

        try (/*FileInputStream fo = new FileInputStream(new File("marks.txt"));*/
                Scanner sc = new Scanner(f);) {

            while (sc.hasNext()) {

                String name = sc.next();
                char mark = sc.next().charAt(0);

//                    System.out.println("name = "+name);
//                    System.out.println("mark = "+mark);
                ArrayList current = map.get(mark);

                if (current == null) {
                    current = new ArrayList<String>();
                    map.put(mark, current);

                }

                current.add(name);

            }// end while

            System.out.println(map);

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found...!");
        } catch (NoSuchElementException e) {
            System.out.println("No such element...!");
        }

    }// end main

}
