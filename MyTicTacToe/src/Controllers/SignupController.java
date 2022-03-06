/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import mytictactoe.*;
import DataBase.DataBase;
import Handlers.ClientHandler;
import Models.Player;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.simple.JSONObject;

/**
 *
 * @author MrMr
 */
public class SignupController implements Initializable {
    @FXML
    TextField uname;
    @FXML
    PasswordField password,confirm;
    @FXML
    Label error;
    Thread readerThread;
    Player player = null;
    public void SignUp(ActionEvent event)
    {
         
         if(password.getText().equals(confirm.getText())&&!password.getText().isEmpty()&&!uname.getText().isEmpty())
     
         {
               player = new Player();
            ClientHandler.setSignUpCtrl(this);
            ClientHandler.setPlayer(player);

            //Generate a new SignUp request to the server.
            JSONObject loginReq = new JSONObject();
            loginReq.put("type", "signup");
            loginReq.put("username", uname.getText());
            loginReq.put("password", password.getText());
            ClientHandler.sendRequest(loginReq);
            readerThread = new Thread(new ClientHandler.recieveRespone());
         }
         else
             error.setText("Password or User Name Not Valid");
    }
      public void SignIn(ActionEvent event)
    {
        navigateTo("/mytictactoe/Login.fxml");

    }
public void navigateTo(String screen)
{
          try {
            Stage s = (Stage) password.getScene().getWindow();
            s.close();
            Parent parent = FXMLLoader.load(getClass().getResource(screen));

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            System.out.println("not load");
        }
}
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public Label getErrorLable() {
       return error;
    }
    
}
