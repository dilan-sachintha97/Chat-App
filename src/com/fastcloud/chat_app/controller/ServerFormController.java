package com.fastcloud.chat_app.controller;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerFormController {
    public TextField txtMessageBox;

    public void initialize(){
        new Thread(() -> {
            try{
                ServerSocket serverSocket = new ServerSocket(5000);
                System.out.println("Server Started !");
            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();
    }

    public void shutdownServerOnClicked(MouseEvent mouseEvent) {
    }
}
