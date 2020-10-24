/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dannymvp.javaduinoclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9090);
            DataInputStream in = new DataInputStream(socket.getInputStream());            
            boolean serverIsAvailable = socket.isConnected();
            while(serverIsAvailable){
                        try {
                            if(in.readUTF() != null)
                                System.out.println(in.readUTF());
                        } catch (IOException ex) {
                            serverIsAvailable = false;
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);                            
                        }
                    }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
