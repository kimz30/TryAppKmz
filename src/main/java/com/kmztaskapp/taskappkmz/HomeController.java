
package com.kmztaskapp.taskappkmz;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
/**
 *
 * @author v-KimM
 */
public class HomeController implements Initializable{
    @FXML
    private JFXButton insertTask;

    @FXML
    private JFXButton viewTask;

    @FXML
    private JFXButton quit;



    @FXML
    void handeInsert(ActionEvent event) throws IOException{
        Parent InsertTask = new FXMLLoader().load(getClass().getResource("/fxml/InsertTask.fxml"));
        Stage InsertStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene InsertScene  = new Scene(InsertTask);
//        InsertScene.getStylesheets().add("/fxml/stylee.css");
        InsertStage.setResizable(false);
        InsertStage.setScene(InsertScene);
        InsertStage.setTitle("Insert Task");
        InsertStage.show();

    }

    @FXML
    void handleView(ActionEvent event) throws IOException{
        Parent ViewTask = new FXMLLoader().load(getClass().getResource("/fxml/ViewTask.fxml"));
        Stage ViewStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene ViewScene = new Scene(ViewTask); ViewScene.getStylesheets().add("/fxml/stylee.css");
        ViewStage.setResizable(false);
        ViewStage.setTitle("View  Task");
        ViewStage.setScene(ViewScene);
        ViewStage.show();
    }


    @FXML
    void handleCalcu(ActionEvent event) throws  IOException{
        Parent CalcuPage = new FXMLLoader().load(getClass().getResource("/fxml/Calculator.fxml")) ;
        Stage CalcuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(CalcuPage); scene.getStylesheets().add("/fxml/stylee.css");
        CalcuStage.setScene(scene);
        CalcuStage.setTitle("KMZ Calculator");
        CalcuStage.show();


    }


    @FXML
    void handeQuit(ActionEvent event) throws IOException {
        Parent login = new FXMLLoader().load(getClass().getResource("/fxml/Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(login); scene.getStylesheets().add("/fxml/stylee.css");
        System.out.println("User has Log off");
        stage.setResizable(false);
        
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(URL url, ResourceBundle rb) {

        System.out.println("10.1.34.103:55432");
    }
}
