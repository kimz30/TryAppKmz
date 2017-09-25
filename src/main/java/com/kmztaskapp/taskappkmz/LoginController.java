/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.kmztaskapp.taskappkmz;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
/**
 *
 * @author v-KimM
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField txtUser;

    @FXML
    private JFXPasswordField txtPass;

    @FXML
    private JFXButton btnLogIn;

    @FXML
    private Label lblInvalid;
    
    @FXML
    private JFXButton btnReg;
    
   @FXML
   void handleReg(ActionEvent event ) throws  IOException{
         Parent registered  = FXMLLoader.load(getClass().getResource("/fxml/register.fxml"));
              Scene regiScene = new Scene(registered);

            Stage regi = (Stage) ((Node) event.getSource()).getScene().getWindow();
            regi.setScene(regiScene);
            regi.setTitle("Register");
            regi.show();
   }


    @FXML
    void handleLogIn(ActionEvent event) throws IOException {

        Parent home_page = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
        if (isValidCredentials()==true) {
            Scene homeScene = new Scene(home_page);

            Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            homeStage.setScene(homeScene);
            homeStage.setTitle("Home Page");
            System.out.println("User has log in");
            homeStage.show();
        } else {
            txtUser.setText("");
            txtPass.setText("");
            lblInvalid.setText("WRONG CREDENTIALS");

        }
    }


    private boolean isValidCredentials()   {

        boolean let_in = false;
        System.out.println("SELECT * FROM task WHERE USERNAME= " + "'" + txtUser.getText() + "'" + " " +
                "AND PASSWORD = " + "'" + txtPass.getText() + "'");

        Connection c = null;
        java.sql.Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:kmz.db");

            c.setAutoCommit(false);

            System.out.println("Opened database Successfully");
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM task WHERE USERNAME= " + "'" + txtUser.getText() + "'" + " " +
                    "AND PASSWORD = " + "'" + txtPass.getText() + "'");

            while (rs.next()) {
                if (rs.getString("USERNAME") != null && rs.getString("PASSWORD") != null) {
                    String username = rs.getString("USERNAME");
                    System.out.println("USERNAME = " + username);
                    String password = rs.getString("PASSWORD");
                    System.out.println("PASSWORD = " + password);
                    let_in = true;

                }

            }
            rs.close();
            stmt.close();
            c.close();

        }catch (Exception e) {
            System.err.println(getClass().getName() + ": " + e .getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return let_in;
    }

    @FXML
    void handleEnterLogin(KeyEvent e) throws  IOException{
        if (e.getCode().equals(KeyCode.ENTER)) {
            Parent Bahay = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
            if (isValidCredentials()) {
                Scene EnterKeyHome = new Scene(Bahay);

                Stage bahayStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                bahayStage.setScene(EnterKeyHome);
                bahayStage.setTitle("Home Page");
                System.out.println("User log in");
                bahayStage.show();


            } else {
                txtUser.setText("");
                txtPass.setText("");
                lblInvalid.setText("WRONG CREDENTIALS");

            }
        }
    }





    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

