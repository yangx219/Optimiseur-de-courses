package Controle;

import Model.Aliment;
import Model.Recette;
import Model.json.RecetteJsonReader;
import Model.json.RefrigerateurJsonReader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class DetailleRecette extends ChangePage implements Initializable {
    private static final String FXML_FILE_PATH = "/FXML/Liste_de_Recettes.fxml";

    public Button cuisinier;
    public Button diminierPersonne;
    public Button ajouterPersonne;
    public Button boutonRevenierArriere;


    public Text nomRecette;
    public ListView<String> listeIngredients;

    public void cuisinier() {
        miseAJourFrigo();
        changePage(FXML_FILE_PATH,cuisinier);
    }

    public void diminierPersonne() {}

    public void ajouterPersonne() {}

    public void allerPageListeRecette() {
        changePage(FXML_FILE_PATH,boutonRevenierArriere);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        afficheRecette();
        //metCouleurs();
    }

    /**
     * Affiche la liste d'ingrédient
     */
    private void afficheRecette(){
        int index = ListeRecettes.recetteSelected;

        Recette recette = RecetteJsonReader.getRecette(index);
        ArrayList<Aliment> ingredients = recette.getIngredients();

        this.nomRecette.setText(recette.getNomRecette());

        for (Aliment ingredient : ingredients) {
            String nom = ingredient.getNom();
            listeIngredients.getItems().add(nom);
            }
        }
/*
    /**
     * Change la couleur de la ligne de la liste
     * si l'ingrédient est dans le réfrigérateur, affiche en vert
     * sinon en rouge
     *//*
    private void metCouleur(){
        ArrayList<String> aliments = RefrigerateurJsonReader.getAlimentNom();

        listeIngredients.setCellFactory(listeIngredients -> new ListCell<String>(){
             @Override
             protected void updateItem(String item, boolean empty){
                super.updateItem(item, empty);
                setText(item);
                if (!empty) {
                    // Change la couleur de fond en fonction du stock du réfrigérateur
                    if(RefrigerateurJsonReader.exist(getText()))
                        setBackground(new Background(new BackgroundFill(Color.rgb(162, 217, 0), null, null)));
                    else
                        setBackground(new Background(new BackgroundFill(Color.rgb(233, 109, 78), null, null)));
                }
             }
        });
    }

*/

    /**
     * Mettre à jour le réfrigérateur après avoir cuisinier
     */
    private void miseAJourFrigo(){
        ArrayList<String> aliments = new ArrayList<>();
        for (String aliment : listeIngredients.getItems()) {
            aliments.add(aliment);
        }

        RefrigerateurJsonReader.removeAliment(aliments);
    }



    /**
     * Change la couleur de la ligne de la liste
     * si l'ingrédient est dans le réfrigérateur, affiche en vert
     * sinon en rouge
     */
    public void afficherCouleur() {
        ArrayList<String> aliments = RefrigerateurJsonReader.getAlimentNom();

        listeIngredients.setCellFactory(listeIngredients -> new ListCell<String>(){

            @Override
            protected void updateItem(String item, boolean empty){
                super.updateItem(item, empty);
                setText(item);
                if (!empty) {
                    if (aliments.contains(getText())) {
                        setBackground(new Background(new BackgroundFill(Color.rgb(162, 217, 0), null, null)));
                        aliments.remove(getText());
                    } else {
                        setBackground(new Background(new BackgroundFill(Color.rgb(233, 109, 78), null, null)));

                    }

                }

            }
        });
    }
}
