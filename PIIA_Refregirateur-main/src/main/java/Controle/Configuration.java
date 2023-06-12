package Controle;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Model.Model;


public class Configuration extends ChangePage {
    private static final String FXML_FILE_PATH = "/FXML/Accueil.fxml";

    public Button etudiant;
    public Button familial;
    public TextField nbPersonne;

    public Button terminerConfiguration;


    public void terminerConfiguration() {
        changePage(FXML_FILE_PATH,terminerConfiguration);

    }
    @FXML
    public void entrerNbPersonne() {
            String input = nbPersonne.getText();
            try {
                int number = Integer.parseInt(input);
                Model.getInstance().setNbPersonne(number);
                System.out.println("nbPersonne est : " +  Model.getInstance().getnbPersonne());
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a number");
            }
    }
}
