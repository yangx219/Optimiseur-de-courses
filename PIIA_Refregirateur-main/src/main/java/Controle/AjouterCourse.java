package Controle;

import Model.Aliment;
import Model.json.CourseJsonReader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AjouterCourse extends ChangePage {
    private static final String FXML_FILE_PATH = "/FXML/Liste_de_Course.fxml";

    public TextField nomAjouterAliment;
    public TextField typeAjouterAliment;
    public TextField tailleAjouterAliment;
    public TextField uniteAjouterAliment;

    public Button validerAjouterAliment;
    public Button revenirArriereAjouterAliment;



    public void validerAjouterAliment() {
        String nom = nomAjouterAliment.getText();
        String type = typeAjouterAliment.getText();
        int taille = Integer.parseInt(tailleAjouterAliment.getText());
        int unite = Integer.parseInt((uniteAjouterAliment.getText()));


        CourseJsonReader.addCourse(new Aliment(nom, type, taille, unite));
        changePage(FXML_FILE_PATH,validerAjouterAliment);
    }

    public void allerPageListeRecette() {
        changePage(FXML_FILE_PATH,revenirArriereAjouterAliment);
    }
}
