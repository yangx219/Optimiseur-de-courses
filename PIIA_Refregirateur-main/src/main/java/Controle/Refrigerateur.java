package Controle;

import Model.Aliment;
import Model.json.RefrigerateurJsonReader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Refrigerateur extends ChangePage implements Initializable {
    private static final String FXML_FILE_PATH1 = "/FXML/Accueil.fxml";
    private static final String FXML_FILE_PATH2 = "/FXML/Ajoutez_un_Aliment.fxml";

    public Button revenirArriereRefrigerateur;
    public Button ajouterAlimentRefrigerateur;


    public GridPane Bouteilles;
    public GridPane Fruits_et_legumes;
    public GridPane Viandes;
    public GridPane Pates;

    public void allerPageAccueil() {
        changePage(FXML_FILE_PATH1,revenirArriereRefrigerateur);

    }

    public void allerPageAjouterAliment() {
        changePage(FXML_FILE_PATH2,ajouterAlimentRefrigerateur);

    }

    /**
     * Affiche tous les aliments du fichier json dans les GridPane du réfrigérateur
     */
    private void afficheAliment(){
        ArrayList<Aliment> aliments =  RefrigerateurJsonReader.getAliment();
        ArrayList<Aliment> fruitLegume = new ArrayList<>();
        ArrayList<Aliment> viandes = new ArrayList<>();
        ArrayList<Aliment> bouteilles = new ArrayList<>();
        ArrayList<Aliment>pates = new ArrayList<>();

        for(int i=0; i<aliments.size();i++){
            switch (aliments.get(i).getType()){
                case "Fruits et légumes":
                    fruitLegume.add(aliments.get(i));
                    break;
                case "Viandes":
                    viandes.add(aliments.get(i));
                    break;
                case "Bouteilles":
                    bouteilles.add(aliments.get(i));
                    break;
                case "Pates":
                    pates.add(aliments.get(i));
                    break;
            }
        }
        ajouterAliment(fruitLegume,Fruits_et_legumes,4);
        ajouterAliment(viandes,Viandes,3);
        ajouterAliment(bouteilles,Bouteilles,2);
        ajouterAliment(pates,Pates,3);
    }

    private void ajouterAliment(ArrayList<Aliment>aliments, GridPane gridPane, int n){
        for(int i=0; i<aliments.size();i++){
            TextField textField = new TextField();
            textField.setText(aliments.get(i).getNom());
            textField.setFont(Font.font(16));
            textField.setPrefSize(30, 30);
            textField.setAlignment(Pos.CENTER);
            gridPane.add(textField, i % n, i / n);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        afficheAliment();

    }
}
