package com.tiy.chatapplication;

import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by RdDvls on 9/8/16.
 */
public class ChatClient {
    EditText text;
    public void chatClient() {
        Scanner inputScanner = new Scanner(System.in);
        int messageCounter = 0;
        //String name = "Clay ";
        System.out.println("Running client...");
        //String testOutput ="Test string";
        try {
            Socket clientSocket = new Socket("10.0.0.133", 8005);
            PrintWriter outFromServer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                System.out.println("Please enter your first name:");
//                String name = inputScanner.nextLine();
//            String messageItem = text.getText().toString();
//            outFromServer.println(messageItem);
//            String serverResponse = inputFromServer.readLine();
//            while (true) {
//                if (messageCounter == 0) {
//                    //System.out.println("Enter message:");
//                    //String message = inputScanner.nextLine();
//                    String messageItem = text.getText().toString();
//                    outFromServer.println(messageItem);
//                    serverResponse = inputFromServer.readLine();
//                    messageCounter++;
//                } else {
////                        System.out.println("Enter message:");
////                        String message = inputScanner.nextLine();
////                        outFromServer.println("test");
////                        String serverResponse = inputFromServer.readLine();
////                        System.out.println("Would you like to send another message? y/n");
////                        String userResponse = inputScanner.nextLine();
////                        messageCounter++;
//                    if (messageCounter > 200) {
//                        clientSocket.close();
//
//                        break;
//                    }
//
////                    }
//                }
////            out.println("name= " + name);// sent to server; read by server
////            String serverResponse = in.readLine();
//            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
    public void sendMessage(EditText text){
        String messageItem = text.getText().toString();
    }
}
