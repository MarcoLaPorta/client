package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownError, UnknownHostException, IOException{
        System.out.println("Client partito");

        Socket server = new Socket("localhost", 3000);
        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        DataOutputStream out = new DataOutputStream(server.getOutputStream());

        Scanner myScan = new Scanner(System.in);
        Scanner myScan2 = new Scanner(System.in);

        System.out.println("Client collegato");

        String stringaRicevuta;
        String stringaInserita;
        String scelta;
        
        do {

            System.out.println( " -M x Trasformare stringa in maiuscolo\n -m x Trasformare stringa in minuscolo\n -R x Ribaltare i caratteri della stringa\n -C x Contare il numero di caratteri\n -! x terminare");
            System.out.println("Inserisci la scelta: ");
            scelta = myScan2.nextLine();
            out.writeBytes(scelta + '\n');

            System.out.println("Scrivi la stringa");
            stringaInserita = myScan.nextLine();
            out.writeBytes(stringaInserita + '\n');

            stringaRicevuta = in.readLine();
            System.out.println("Stringa ricevuta: " + stringaRicevuta);

            if (scelta.equals("!")) {
                System.out.println("STOP");
                break;
            }     

        } while (!scelta.equals("!"));
        
        server.close();
        out.close();
        in.close();
        myScan.close();
        myScan2.close();
    }
}
