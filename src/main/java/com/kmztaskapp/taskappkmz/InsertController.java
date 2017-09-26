/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kmztaskapp.taskappkmz;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author v-KimM
 */
public class InsertController implements Initializable {
    @FXML
    private MenuButton hour_menubutton;

    @FXML
    private MenuButton minute_menubutton;

    @FXML
    private MenuButton ampm_menubutton;

    @FXML
    private Button done_button;

    @FXML
    private TextField title_text;


    @FXML
    private TextField location_text;

    @FXML
    private TextArea notes_text;

    @FXML
    private DatePicker date_picker;


    @FXML
    private void doneButtonAction(ActionEvent event) throws IOException {


        String hour_value = hour_menubutton.getText();

        if (ampm_menubutton.getText().equals("PM")) {
            System.out.println("They checked PM");
            int int_hour_value = Integer.parseInt(hour_value) + 12;
            hour_value = "" + int_hour_value;
        }

        String query = "INSERT INTO task2 (TITLE,LOCATION,NOTES,TIMING) VALUES (" + "'" + title_text.getText() +
                "'," + "'" + location_text.getText() + "'," + "'" + notes_text.getText() + "'," + "'" +
                date_picker.getValue() + " " + hour_value + ":" +
                minute_menubutton.getText() + ":00" + "');";



        System.out.println("Inserting\n" + query);
        insertStatement(query);
        System.out.println("TASK SAVED!");


        Stage stage = new Stage();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets( 20,20,20,25));
        grid.setAlignment(Pos.CENTER);
        stage.setAlwaysOnTop(true);
        Label message = new Label();
        message.setText("Adding task succeed");
        message.setFont(Font.font("Verdana", 15));
        grid.add(message, 0,0);
        Button ok = new Button("Ok");

        HBox bok = new HBox(10);
        bok.setAlignment(Pos.BOTTOM_CENTER);
        grid.add(ok, 1, 2);
        ok.setOnAction(e -> stage.close());
        Scene scene = new Scene(grid, 250,80);
        stage.setScene(scene);
        stage.show();
        Parent date_page_parent = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
        Scene date_page_scene = new Scene(date_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(date_page_scene);
        app_stage.show();
    }
    private void insertStatement(String insert_query){

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:kmz.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            System.out.println("Our query was: " + insert_query);
            stmt.executeUpdate(insert_query);
            stmt.close();
            c.commit();
            c.close();
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }


    }
    @FXML
    private void hourMenuItemButtonAction(ActionEvent event) throws IOException {
        MenuItem menu = (MenuItem) event.getSource();
        hour_menubutton.setText(menu.getText());
    }
    @FXML
    private void minuteMenuItemButtonAction(ActionEvent event) throws IOException {
        MenuItem menu = (MenuItem) event.getSource();
        minute_menubutton.setText(menu.getText());
    }
    @FXML
    private void ampmMenuItemButtonAction(ActionEvent event) throws IOException {
        MenuItem menu = (MenuItem) event.getSource();
        ampm_menubutton.setText(menu.getText());
    }

    @FXML
    private void datePickerAction(ActionEvent event) throws IOException {
        DatePicker date_picker = (DatePicker) event.getSource();
        System.out.println(date_picker.getValue());
    }

    @FXML
    void goBackHome(ActionEvent event) throws  IOException{
        Parent goBackHome = new FXMLLoader().load(getClass().getResource("/fxml/Home.fxml"));
        Stage backStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         backStage.setTitle("TaskKMZ");
        Scene backScene = new Scene(goBackHome);
        System.out.println("Back on home");
        backStage.setScene(backScene);
        backStage.show();

    }


    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
