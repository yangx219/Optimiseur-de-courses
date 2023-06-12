package Controle;

import Model.Aliment;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AjouterIngredient extends ChangePage {
    private static final String FXML_FILE_PATH = "/FXML/Ajoutez_une_recette.fxml";

    public Button validerAjouterIngredient;
    public Button revenirArriereAjouterAliment;

    public TextField nomAjouterAliment;
    public TextField typeAjouterAliment;
    public TextField tailleAjouterAliment;
    public TextField uniteAjouterAliment;

    public void validerAjouterIngredient() {
        String nom = nomAjouterAliment.getText();
        String type = typeAjouterAliment.getText();
        int taille = Integer.parseInt(tailleAjouterAliment.getText());
        int unite = Integer.parseInt(uniteAjouterAliment.getText());


        AjouterRecette.getIngredients().add(new Aliment(nom,type,taille,unite));
        changePage(FXML_FILE_PATH,validerAjouterIngredient);
    }

    public void allerPageAjouterRecette() {
        changePage(FXML_FILE_PATH,revenirArriereAjouterAliment);
    }
}
