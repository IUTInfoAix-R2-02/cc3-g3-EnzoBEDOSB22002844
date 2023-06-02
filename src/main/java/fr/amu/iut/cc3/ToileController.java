package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;

    @FXML
    private Shape pointtest;

    @FXML
    private Shape point1;
    @FXML
    private Shape point2;
    @FXML
    private Shape point3;
    @FXML
    private Shape point4;
    @FXML
    private Shape point5;
    @FXML
    private Shape point6;

    @FXML
    private TextField FieldC1;
    @FXML
    private TextField FieldC2;
    @FXML
    private TextField FieldC3;
    @FXML
    private TextField FieldC4;
    @FXML
    private TextField FieldC5;
    @FXML
    private TextField FieldC6;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }


    public void setPoint1(Shape point1, int x, int y) {
        point1.setLayoutX(x);
        point1.setLayoutY(y);
    }
    public void setPoint2(Shape point2, int x, int y) {
        point2.setLayoutX(x);
        point2.setLayoutY(y);
    }
    public void setPoint3(Shape point3, int x, int y) {
        point3.setLayoutX(x);
        point3.setLayoutY(y);
    }
    public void setPoint4(Shape point4, int x, int y) {
        point4.setLayoutX(x);
        point4.setLayoutY(y);
    }
    public void setPoint5(Shape point5, int x, int y) {
        point5.setLayoutX(x);
        point5.setLayoutY(y);
    }
    public void setPoint6(Shape point6, int x, int y) {
        point6.setLayoutX(x);
        point6.setLayoutY(y);
    }
    @FXML
    private void writeComp(){
        int x1 = getXRadarChart(Integer.valueOf(FieldC1.getText()),1);
        int y1 = getYRadarChart(Integer.valueOf(FieldC1.getText()),1);
        setPoint1(point1, x1, y1);

        int x2 = getXRadarChart(Integer.valueOf(FieldC2.getText()), 2);
        int y2 = getYRadarChart(Integer.valueOf(FieldC2.getText()),2);
        setPoint2(point2, x2, y2);

        int x3 = getXRadarChart(Integer.valueOf(FieldC3.getText()),3);
        int y3 = getYRadarChart(Integer.valueOf(FieldC3.getText()),3);
        setPoint3(point3, x3, y3);

        int x4 = getXRadarChart(Integer.valueOf(FieldC4.getText()),4);
        int y4 = getYRadarChart(Integer.valueOf(FieldC4.getText()),4);
        setPoint4(point4, x4, y4);

        int x5 = getXRadarChart(Integer.valueOf(FieldC5.getText()),5);
        int y5 = getYRadarChart(Integer.valueOf(FieldC5.getText()),5);
        setPoint5(point5, x5, y5);

        int x6 = getXRadarChart(Integer.valueOf(FieldC6.getText()),6);
        int y6 = getYRadarChart(Integer.valueOf(FieldC6.getText()),6);
        setPoint6(point6, x6, y6);
    }
    @FXML
    private void clearField(){
        FieldC1.setText("");
        FieldC2.setText("");
        FieldC3.setText("");
        FieldC4.setText("");
        FieldC5.setText("");
        FieldC6.setText("");
        setPoint1(point1, 200, 200);
        setPoint2(point2, 200, 200);
        setPoint3(point3, 200, 200);
        setPoint4(point4, 200, 200);
        setPoint5(point5, 200, 200);
        setPoint6(point6, 200, 200);
    }


}
