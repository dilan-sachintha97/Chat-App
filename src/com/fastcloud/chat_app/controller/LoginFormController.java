package com.fastcloud.chat_app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class LoginFormController {
    public TextField txtUserName;
    public AnchorPane loginFormContext;

    public void btnStartChatOnAction(ActionEvent actionEvent) throws IOException {
        if(!txtUserName.getText().trim().isEmpty()){
            /*Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ClientForm.fxml"))));
            stage.setTitle(txtUserName.getText());

            Stage stage2 = (Stage) loginFormContext.getScene().getWindow();
            stage2.close();
            stage.show();*/

            Stage stage = (Stage) loginFormContext.getScene().getWindow();
            stage.setTitle(txtUserName.getText());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ClientForm.fxml"));
            Parent parent = fxmlLoader.load();
            ClientFormController controller = fxmlLoader.getController();
            controller.setClientName(txtUserName.getText());
            stage.setScene(new Scene(parent));



        }else {
            new Alert(Alert.AlertType.WARNING, "User Name is Required !").show();
        }
    }
}
