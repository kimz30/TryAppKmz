
package com.kmztaskapp.taskappkmz;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
 * FXML Controller class
 *
 * @author v-KimM
 */
public class CalcuController implements Initializable {

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton sub;

    @FXML
    private JFXButton nine;

    @FXML
    private JFXButton six;

    @FXML
    private JFXButton mul;

    @FXML
    private JFXButton one;

    @FXML
    private JFXTextField display;

    @FXML
    private JFXButton clear;

    @FXML
    private JFXButton seven;

    @FXML
    private JFXButton two;

    @FXML
    private JFXButton three;

    @FXML
    private JFXButton eight;

    @FXML
    private JFXButton zero;

    @FXML
    private JFXButton div;

    @FXML
    private JFXButton four;

    @FXML
    private JFXButton equals;

    @FXML
    private JFXButton five;

    @FXML
    private JFXButton quit;

    @FXML
            private JFXButton delete;


    int data1=0;
    int data2=0;
    int operation=0;

    @FXML
    void handleAction(ActionEvent event) {
        if (event.getSource() == one)  {
            display.setText(display.getText() + "1");
        } else if (event.getSource() == two) {
            display.setText(display.getText() + "2");
        }
        else if (event.getSource() == three) {
            display.setText(display.getText() + "3");
        }   else if (event.getSource() == four) {
            display.setText(display.getText() + "4");
        }   else if (event.getSource() == five) {
            display.setText(display.getText() + "5");
        }   else if (event.getSource() == six) {
            display.setText(display.getText() + "6");
        }   else if (event.getSource() == seven) {
            display.setText(display.getText() + "7");
        }else if (event.getSource() == eight) {
            display.setText(display.getText() + "8");
        }
        else if (event.getSource() == nine) {
            display.setText(display.getText() + "9");
        }
        else if (event.getSource() == zero) {
            display.setText(display.getText() + "0");
        }

        else if (event.getSource() == clear) {
            display.setText("");
        }
        else if (event.getSource() == add) {
            data1 = Integer.parseInt(display.getText());
            display.setText("");
            operation = 1;
        }
        else if (event.getSource() == sub) {
            data1 = Integer.parseInt(display.getText());
            display.setText("");
            operation = 2;
        }
        else if (event.getSource() == mul) {
            data1 = Integer.parseInt(display.getText());
            display.setText("");
            operation = 3;
        }
        else if (event.getSource() == div) {
            data1 = Integer.parseInt(display.getText());
            display.setText("");
            operation = 4;
        }



        else if (event.getSource() == equals) {
            data2 = Integer.parseInt(display.getText());

            display.setText("");


            switch (operation) {
                case 1 : int ans = data1 + data2;
                    display.setText(String.valueOf(ans));
                    break;

                case 2 :  ans = data1 - data2;
                    display.setText(String.valueOf(ans));
                    break;

                case 3 :
                    ans = data1 * data2;
                    display.setText(String.valueOf(ans));
                    break;

                case 4:
                    ans = data1 / data2;
                    display.setText(String.valueOf(ans));
                    break;
            }
        }


    }


    @FXML
    void del(ActionEvent event) {
            if (event.getSource() == delete) {
                display.setText(display.getText());
            }
    }


    @FXML
    void quit(ActionEvent event) throws IOException {

        Parent quit = new FXMLLoader().load(getClass().getResource("/fxml/Home.fxml"));
        Stage quitStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        quitStage.setTitle("TaskKmz");
        Scene backScene = new Scene(quit);
        quitStage.setScene(backScene);
        quitStage.show();
    }

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
