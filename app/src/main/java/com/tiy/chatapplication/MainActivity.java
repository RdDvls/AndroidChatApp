package com.tiy.chatapplication;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {
    ArrayAdapter<String> items;
    ListView list;
    EditText text;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        list = (ListView) findViewById(R.id.listView);
        text = (EditText) findViewById(R.id.editText);
        addButton = (Button) findViewById(R.id.button);

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(items);

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
//        ChatClient();
    }

    @Override
    public void onClick(View v) {
        String item = text.getText().toString();
        ChatClient();
        items.add(item);
        text.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = items.getItem(position);
        items.remove(item);
        return true;
    }

    public void ChatClient() {
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
           String messageItem = text.getText().toString();
            outFromServer.println(messageItem);
            String serverResponse = inputFromServer.readLine();
            while (true) {
                if (messageCounter == 0) {
                    //System.out.println("Enter message:");
                    //String message = inputScanner.nextLine();
                    messageItem = text.getText().toString();
                    outFromServer.println(messageItem);
                    serverResponse = inputFromServer.readLine();
                    messageCounter++;
                } else {
//                        System.out.println("Enter message:");
//                        String message = inputScanner.nextLine();
//                        outFromServer.println("test");
//                        String serverResponse = inputFromServer.readLine();
//                        System.out.println("Would you like to send another message? y/n");
//                        String userResponse = inputScanner.nextLine();
//                        messageCounter++;
                    if (messageCounter > 200) {
                        clientSocket.close();

                        break;
                    }

//                    }
                }
//            out.println("name= " + name);// sent to server; read by server
//            String serverResponse = in.readLine();
            }
        } catch (IOException exception) {
        }

    }

}

