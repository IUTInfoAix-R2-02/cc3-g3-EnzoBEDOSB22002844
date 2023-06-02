package fr.amu.iut.cc3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import java.net.URL;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;

    // Permet de changer la couleur des traits reliant les points
    private String colorLine = "black";

    //coordonée X et Y du centre du graph
    private int c = 200;


    //Récupération du label d'erreur
    @FXML
    private Label labelError;

    //Récupération des 6 points du graph
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

    //Récupération des 6 TextField du graph
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

    //Récupération des lignes reliant les points
    @FXML
    private Line Line1_2;
    @FXML
    private Line Line2_3;
    @FXML
    private Line Line3_4;
    @FXML
    private Line Line4_5;
    @FXML
    private Line Line5_6;
    @FXML
    private Line Line6_1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    //Récupération de la coordonnée X en fonction de la note et de la compétence
    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    //Récupération de la coordonnée Y en fonction de la note et de la compétence
    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }


    //Changement des coordonnées du point 1
    public void setPoint1(Shape point1, int x, int y) {
        point1.setLayoutX(x);
        point1.setLayoutY(y);
    }

    //Changement des coordonnées du point 2
    public void setPoint2(Shape point2, int x, int y) {
        point2.setLayoutX(x);
        point2.setLayoutY(y);
    }

    //Changement des coordonnées du point 3
    public void setPoint3(Shape point3, int x, int y) {
        point3.setLayoutX(x);
        point3.setLayoutY(y);
    }

    //Changement des coordonnées du point 4
    public void setPoint4(Shape point4, int x, int y) {
        point4.setLayoutX(x);
        point4.setLayoutY(y);
    }

    //Changement des coordonnées du point 5
    public void setPoint5(Shape point5, int x, int y) {
        point5.setLayoutX(x);
        point5.setLayoutY(y);
    }

    //Changement des coordonnées du point 6
    public void setPoint6(Shape point6, int x, int y) {
        point6.setLayoutX(x);
        point6.setLayoutY(y);
    }
    @FXML
    private void writeComp(){

        // Convertion des notes String en int
        int valueC1 = Integer.valueOf(FieldC1.getText());
        int valueC2 = Integer.valueOf(FieldC2.getText());
        int valueC3 = Integer.valueOf(FieldC3.getText());
        int valueC4 = Integer.valueOf(FieldC4.getText());
        int valueC5 = Integer.valueOf(FieldC5.getText());
        int valueC6 = Integer.valueOf(FieldC6.getText());

        // Changement de couleur des traits
        Line1_2.setStyle("-fx-stroke: "+colorLine+";");
        Line2_3.setStyle("-fx-stroke: "+colorLine+";");
        Line3_4.setStyle("-fx-stroke: "+colorLine+";");
        Line4_5.setStyle("-fx-stroke: "+colorLine+";");
        Line5_6.setStyle("-fx-stroke: "+colorLine+";");
        Line6_1.setStyle("-fx-stroke: "+colorLine+";");

        // Si une variable est inférieur à 0 ou supérieur à 20, "labelTest" se met à "true"
        boolean labelTest =false;

        // Verification de la condition, 0 < i < 20

        // Si la note et inférieur à 0 ou supérieur à 20, alors "labelTest" passe à "true"
        if (valueC1> 20 ||valueC1 < 0 ){
            labelTest = true;
        } else {
            // Récupération des coordonnées du point pour la compétence 1
            int x1 = getXRadarChart(valueC1,1);
            int y1 = getYRadarChart(valueC1,1);

            // Changement des coordonées du point 1
            setPoint1(point1, x1, y1);

            // Coordonnées de début et de fin des traits
            Line6_1.setEndX(x1);
            Line6_1.setEndY(y1);

            Line1_2.setStartX(x1);
            Line1_2.setStartY(y1);
        }

        // Si la note et inférieur à 0 ou supérieur à 20, alors "labelTest" passe à "true"
        if (valueC2> 20 ||valueC2 < 0 ){
            labelTest = true;

        } else {
            // Récupération des coordonnées du point pour la compétence 2
            int x2 = getXRadarChart(valueC2, 2);
            int y2 = getYRadarChart(valueC2,2);

            // Changement des coordonées du point 2
            setPoint2(point2, x2, y2);

            // Coordonnées de début et de fin des traits
            Line1_2.setEndX(x2);
            Line1_2.setEndY(y2);

            Line2_3.setStartX(x2);
            Line2_3.setStartY(y2);
        }

        // Si la note et inférieur à 0 ou supérieur à 20, alors "labelTest" passe à "true"
        if (valueC3> 20 ||valueC3 < 0 ){
            labelTest = true;
        } else {
            // Récupération des coordonnées du point pour la compétence 3
            int x3 = getXRadarChart(valueC3,3);
            int y3 = getYRadarChart(valueC3,3);
            // Changement des coordonées du point 3
            setPoint3(point3, x3, y3);

            // Coordonnées de début et de fin des traits
            Line2_3.setEndX(x3);
            Line2_3.setEndY(y3);

            Line3_4.setStartX(x3);
            Line3_4.setStartY(y3);
        }
        // Si la note et inférieur à 0 ou supérieur à 20, alors "labelTest" passe à "true"
        if (valueC4> 20 ||valueC4 < 0 ){
            labelTest = true;
        } else {
            // Récupération des coordonnées du point pour la compétence 4
            int x4 = getXRadarChart(valueC4,4);
            int y4 = getYRadarChart(valueC4,4);

            // Changement des coordonées du point 4
            setPoint4(point4, x4, y4);

            // Coordonnées de début et de fin des traits
            Line3_4.setEndX(x4);
            Line3_4.setEndY(y4);

            Line4_5.setStartX(x4);
            Line4_5.setStartY(y4);

        }

        // Si la note et inférieur à 0 ou supérieur à 20, alors "labelTest" passe à "true"
        if (valueC5 > 20 ||valueC5 < 0 ){
            labelTest = true;
        } else {
            // Récupération des coordonnées du point pour la compétence 5
            int x5 = getXRadarChart(valueC5,5);
            int y5 = getYRadarChart(valueC5,5);

            // Changement des coordonées du point 5
            setPoint5(point5, x5, y5);

            // Coordonnées de début et de fin des traits
            Line4_5.setEndX(x5);
            Line4_5.setEndY(y5);

            Line5_6.setStartX(x5);
            Line5_6.setStartY(y5);
        }

        // Si la note et inférieur à 0 ou supérieur à 20, alors "labelTest" passe à "true"
        if (valueC6 > 20 ||valueC6 < 0 ){
            labelTest = true;
        } else {
            // Récupération des coordonnées du point pour la compétence 6
            int x6 = getXRadarChart(valueC6,6);
            int y6 = getYRadarChart(valueC6,6);

            // Changement des coordonées du point 6
            setPoint6(point6, x6, y6);

            // Coordonnées de début et de fin des traits
            Line5_6.setEndX(x6);
            Line5_6.setEndY(y6);

            Line6_1.setStartX(x6);
            Line6_1.setStartY(y6);
        }
        if (labelTest == true){
            labelError.setVisible(true);
        } else {
            labelError.setVisible(false);
        }
    }
    @FXML
    private void clearField(){

        //Textfield clear pour une nouvelle saisie
        FieldC1.setText("");
        FieldC2.setText("");
        FieldC3.setText("");
        FieldC4.setText("");
        FieldC5.setText("");
        FieldC6.setText("");

        //Réinitialisation des points vers le centre du graphique
        setPoint1(point1, c, c);
        setPoint2(point2, c, c);
        setPoint3(point3, c, c);
        setPoint4(point4, c, c);
        setPoint5(point5, c, c);
        setPoint6(point6, c, c);

        //Réinitialisation des coordonnées des traits vers le centre du graphique
        Line1_2.setStartX(c);
        Line1_2.setStartY(c);
        Line1_2.setEndX(c);
        Line1_2.setEndY(c);

        Line2_3.setStartX(c);
        Line2_3.setStartY(c);
        Line2_3.setEndX(c);
        Line2_3.setEndY(c);

        Line3_4.setStartX(c);
        Line3_4.setStartY(c);
        Line3_4.setEndX(c);
        Line3_4.setEndY(c);

        Line4_5.setStartX(c);
        Line4_5.setStartY(c);
        Line4_5.setEndX(c);
        Line4_5.setEndY(c);

        Line5_6.setStartX(c);
        Line5_6.setStartY(c);
        Line5_6.setEndX(c);
        Line5_6.setEndY(c);

        Line6_1.setStartX(c);
        Line6_1.setStartY(c);
        Line6_1.setEndX(c);
        Line6_1.setEndY(c);

        //Réinitialisation du label d'erreur en invisible
        labelError.setVisible(false);
    }


}
