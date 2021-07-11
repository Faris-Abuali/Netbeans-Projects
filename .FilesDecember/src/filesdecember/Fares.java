/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesdecember;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.xml.sax.InputSource;

/**
 *
 * @author Fares Abu Ali
 */
public class Fares {

    public static void main(String[] args) {

        File f = new File("Fat.txt");

        try (PrintWriter fileOut = new PrintWriter(f)) {
            fileOut.print("Fars");
        } catch (IOException e) {

        }
    }
}
