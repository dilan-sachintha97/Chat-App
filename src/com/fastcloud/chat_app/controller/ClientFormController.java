package com.fastcloud.chat_app.controller;

import com.fastcloud.chat_app.util.Client;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.Socket;

public class ClientFormController {

    public TextField txtMessageBox;
    public Label lblClientName;
    public VBox vBoxMessage;

    String clientName;
    public static VBox senderVBox;
    public Client client;


    public void initialize(){

    }

    public void setClientName(String name){

        new Thread(()->{
            try {
                senderVBox=vBoxMessage;

                // set client name
                lblClientName.setText(name);

                client = new Client(new Socket("localhost",5000),name,vBoxMessage);
                System.out.println("Connected to server !");
            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();
        clientName = name;
    }

    public void exitClientOnClicked(MouseEvent mouseEvent) {
    }

    public static void displayMessageOnRight(String messageToSend, VBox vBox){
            if( !messageToSend.isEmpty()){
                HBox hBox = new HBox();
                hBox.setAlignment(Pos.CENTER_RIGHT);
                hBox.setPadding(new Insets(5,5,5,10));
                Text msgText = new Text(messageToSend);
                TextFlow textFlow = new TextFlow(msgText);
                textFlow.setStyle("-fx-border-color: #3498db; -fx-background-radius: 10, 10, 0, 10 ");
                textFlow.setPadding(new Insets(5,5,5,10));
                msgText.setFill(Color.WHITE);
                hBox.getChildren().add(textFlow);
                Platform.runLater(()->{
                    vBox.getChildren().add(hBox);
                });
            }
    }
}
