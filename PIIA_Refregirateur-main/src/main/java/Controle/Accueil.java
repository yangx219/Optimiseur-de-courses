package Controle;

import javafx.scene.control.Button;


public class Accueil extends ChangePage {
    private static final String FXML_FILE_PATH1 = "/FXML/Liste_de_Recettes.fxml";
    private static final String FXML_FILE_PATH2 = "/FXML/Liste_de_Course.fxml";
    private static final String FXML_FILE_PATH3 = "/FXML/Refrigerateur.fxml";


    public Button refrigerateur;
    public Button recettes;
    public Button course;

    public void allerPageRecettes() {
        changePage(FXML_FILE_PATH1,recettes);

    }

    public void allerPageCourse() {
        changePage(FXML_FILE_PATH2,course);

    }

    public void allerPageRefrigerateur() {
        changePage(FXML_FILE_PATH3,refrigerateur);


    }
}
