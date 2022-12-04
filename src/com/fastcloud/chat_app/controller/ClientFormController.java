package com.fastcloud.chat_app.controller;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ClientFormController {

    public TextField txtMessageBox;
    public Label lblClientName;



    public void initialize(){

    }

    public void setClientName(String name){
       lblClientName.setText(name);
    }

    public void exitClientOnClicked(MouseEvent mouseEvent) {
    }
}
