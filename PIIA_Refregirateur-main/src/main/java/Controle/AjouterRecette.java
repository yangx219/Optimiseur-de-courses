package Controle;

import Model.Aliment;
import Model.Recette;
import Model.json.RecetteJsonReader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AjouterRecette extends ChangePage implements Initializable {
    private static final String FXML_FILE_PATH1 = "/FXML/Liste_de_Recettes.fxml";
    private static final String FXML_FILE_PATH2 = "/FXML/Ajoutez_un_ingredient.fxml";

    public TextField nomAjouterRecette;

    public Button validerAjouterRecette;
    public Button revenirArriereAjouterRecette;
    public Button ajouterIngredient;

    public ListView<String> listeIngredients;

    private static final ArrayList<Aliment> ingredients = new ArrayList<>();

    public static ArrayList<Aliment> getIngredients(){return ingredients;}

    public void validerAjouterRecette() {
        String nom = nomAjouterRecette.getText();

        //ajoute au fichier json
        RecetteJsonReader.addRecette(new Recette(nom, ingredients));

        //nettoie la liste d'ingrédient
        ingredients.clear();

        changePage(FXML_FILE_PATH1,validerAjouterRecette);

    }


    public void allerPageListeRecette() {
        //nettoie la liste d'ingrédient
        ingredients.clear();

        changePage(FXML_FILE_PATH1,revenirArriereAjouterRecette);

    }

    public void allerPageAjouterIngredient() {
        changePage(FXML_FILE_PATH2,validerAjouterRecette);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Aliment aliment : ingredients) {
            String ingredient = aliment.getNom();
            int unite = aliment.getUnite();
            listeIngredients.getItems().add(ingredient );
        }
    }
}
