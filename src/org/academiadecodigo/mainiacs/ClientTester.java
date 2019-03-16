package org.academiadecodigo.mainiacs;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientTester {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8080);
            Scanner s = new Scanner(System.in);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

            while(true) {
                System.out.println("aosid");
                System.out.println(in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
