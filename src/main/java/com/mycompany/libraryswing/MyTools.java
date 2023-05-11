/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.libraryswing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author anton
 */
public class MyTools {

    private static Scanner aScanInput = new Scanner(System.in);

    // konvertiert string in integer ohne exception im fehlerfall
    // wenn nicht möglich wird -1 zurückgeliefert
    public static int strToInt(String inStr) {
        try {
            return Integer.valueOf(inStr); // string to int
        } // fehler abfangen, falls inStr to int eine exception wirft
        catch (NumberFormatException e) {
            return (-1);
        }
    }

    public static int getInt(int inMin, int inMax) {
        int iVal;

        iVal = strToInt(getString()); // eingabestring in int konvertieren
        if ((iVal >= inMin) && (iVal <= inMax)) {
            return iVal; // alles OK -> richtigen wert liefern
        } else {
            return (-1); // nicht im bereich inMin..inMax
        }
    }

    

  public static String getString() {
        return aScanInput.nextLine();
    }


  public static int inputInt() {
        int n;
        Scanner aScanInput = new Scanner(System.in);
        System.out.print("geben Sie eine Ganzzahl ein: ");
        try {
            n = aScanInput.nextInt();
            aScanInput.nextLine();
            return n;
        } catch (Exception e) {
            System.out.println("FALSCHE EINGABE!");
            return inputInt();
        }
    }
/**
     *
     * @param max - maximum possible number
     * @return int in interval - 1...max
     */
public static int generatInt(int max) {
        Random ran = new Random();
        int i = (ran.nextInt(max) + 1);
        return i;
    }

public static String readString(String prompt) {
        if (!prompt.isEmpty()) {
            System.out.print(prompt + ": ");
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException ex) {
            return "";
        }
    }
}
