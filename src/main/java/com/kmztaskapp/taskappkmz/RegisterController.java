package com.kmztaskapp.taskappkmz;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RegisterController  implements Initializable {
    
    @FXML
    private TextField Username;
    @FXML
    private PasswordField Password;
    private Connection c;
    private PreparedStatement pstmt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:kmz.db");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @FXML
    public void reg(ActionEvent event) throws SQLException{
    
        pstmt = c.prepareStatement("INSERT INTO task (USERNAME, PASSWORD) VALUES (?, ?)");
        pstmt.setString(1, Username.getText());
        pstmt.setString(2, Password.getText());
        pstmt.executeUpdate();
      //  ((Node) (event.getSource())).getScene().getWindow().hide();
      
      Stage stage = new Stage();
      stage.setTitle("Congrats");
      StackPane layout = new StackPane ();
      Label lbl = new Label();
      
      lbl.setText("Account Registered");
      layout.getChildren().add(lbl);
      stage.initModality(Modality.APPLICATION_MODAL);
      Scene scene = new Scene(layout,300,150);
      stage.setScene(scene);
      stage.show();
      
      
        
    }
    
    @FXML
    public void update(ActionEvent event) throws SQLException{
    
        pstmt = c.prepareStatement("UPDATE task SET PASSWORD=? WHERE USERNAME=?");
        pstmt.setString(1, Password.getText());
        pstmt.setString(2, Username.getText());
        pstmt.executeUpdate();
    }
    
    @FXML
    public void delete(ActionEvent event) throws SQLException{
    
        pstmt = c.prepareStatement("DELETE FROM task WHERE USERNAME=?");
        pstmt.setString(1, Username.getText());
        pstmt.executeUpdate();
    }
    
    @FXML
    public void back (ActionEvent event) throws IOException{
        
           Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
           Parent root = new FXMLLoader().load(getClass().getResource("/fxml/Login.fxml"));
           stage.setTitle("KmzTaskApp");
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
           
           
    }

}
