package Controle;

import Model.Aliment;
import Model.json.CourseJsonReader;
import Model.json.RecetteJsonReader;
import Model.json.RefrigerateurJsonReader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.net.URL;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListeRecettes extends ChangePage implements Initializable  {
    private static final String FXML_FILE_PATH1 = "/FXML/Ajoutez_une_Recette.fxml";
    private static final String FXML_FILE_PATH2 = "/FXML/Accueil.fxml";
    private static final String FXML_FILE_PATH3 = "/FXML/Liste_de_Course.fxml";
    private static final String FXML_FILE_PATH4 = "/FXML/Detaille_de_Recette.fxml";

    public ImageView panier;

    public Button ajouterRecette;
    public Button revenirArriereListeRecette;

    public ListView<String> listeRecette;
    public Button boutonAfficher;
    public Button boutonSupprimer;


    public static int recetteSelected;

    public void allerPageAjouterRecette() {
        changePage(FXML_FILE_PATH1,ajouterRecette);

    }

    public void allerPageAccueil() {
        changePage(FXML_FILE_PATH2,revenirArriereListeRecette);

    }

    public void ajouterCourse() {
        int selectedID = listeRecette.getSelectionModel().getSelectedIndex();
        if(selectedID != -1) {
            listeRecette.getSelectionModel().clearSelection();
            ArrayList<Aliment> ingredients = RecetteJsonReader.getIngredients(selectedID);

            for (int i = 0; i < ingredients.size(); i++) {
                CourseJsonReader.addCourse(ingredients.get(i));
                System.out.println(ingredients.get(i).getClass());
            }
        }else {
            changePage(FXML_FILE_PATH3, panier);
        }
    }


    /**
     * Supprime la recette sélectionnée de la liste et du fichier json
     */
    public void supprimerRecette() {
        int selectedID = listeRecette.getSelectionModel().getSelectedIndex();

        //retire de la liste
        String nomRecette = listeRecette.getItems().get(selectedID);

        //Retire du fichier json
        RecetteJsonReader.removeRecette(selectedID);

        //Retire de liste de l'interface
        listeRecette.getItems().remove(selectedID);
    }


    /**
     * Ajoute les noms de recette du fichier recettes.json à la liste
     */
    public void afficherListeRecette() {
        ArrayList<String> recettes = RecetteJsonReader.getNomRecette();
        for (String recette : recettes) {
            listeRecette.getItems().add(recette);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        afficherListeRecette();
    }

    public void afficherDetailleRecette() {
        int selectedID = listeRecette.getSelectionModel().getSelectedIndex();

        if(selectedID >= 0){
            recetteSelected = selectedID;
            changePage(FXML_FILE_PATH4,boutonAfficher);
        }
    }

    /**
     * Affiche les recettes ayant les ingrédients présent dans le réfrigérateur en vert
     * sinon en rouge
     */
    public void afficheCouleur() {
        listeRecette.setCellFactory(listeIngredients -> new ListCell<String>(){
            @Override
            protected void updateItem(String item, boolean empty){
                super.updateItem(item, empty);
                setText(item);
                if (!empty) {
                    ArrayList<String> aliments = RefrigerateurJsonReader.getAlimentNom();
                    ArrayList<String> ingredients =  RecetteJsonReader.getIngredientsNom(getIndex());
                    if (contient(ingredients,aliments)) {
                        setBackground(new Background(new BackgroundFill(Color.rgb(162, 217, 0), null, null)));
                    } else {
                        setBackground(new Background(new BackgroundFill(Color.rgb(233, 109, 78), null, null)));
                    }
                }
            }
        });
    }

    /**
     * Regarde si tous les ingrédients sont dans le réfrigérateur ou non
     * @param ingredients de la recette
     * @param aliments dans le réfrigérateur
     * @return true si tous les ingrédients sont dans le réfrigérateur
     * sinon false
     */
    private Boolean contient(ArrayList<String> ingredients, ArrayList<String> aliments){
        int temp =0;
        for(int i=0; i<ingredients.size();i++) {
            Boolean retirer = false;
            for (int j = 0; j < aliments.size(); j++) {
                if (ingredients.get(i).equals(aliments.get(j)) && !retirer) {
                    retirer = true;
                    aliments.remove(ingredients.get(i));
                    temp += 1;
                }
            }
        }
        return (temp==ingredients.size());
    }

}
