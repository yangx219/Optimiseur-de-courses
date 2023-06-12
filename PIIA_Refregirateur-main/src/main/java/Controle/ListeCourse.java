package Controle;


import Model.Aliment;
import Model.json.CourseJsonReader;
import Model.json.RefrigerateurJsonReader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListeCourse extends ChangePage implements Initializable {
    private static final String FXML_FILE_PATH1 = "/FXML/Accueil.fxml";
    private static final String FXML_FILE_PATH2 = "/FXML/Ajoutez_une_Course.fxml";


    public Button acheter;
    public Button ajouterCourse;
    public Button revenirArriereListeCourse;
    public ListView<String> listeCourse;

    public void acheter() {
        int selectedID = listeCourse.getSelectionModel().getSelectedIndex();
        if(selectedID !=-1) {
            System.out.println(selectedID);
            Aliment aliment = CourseJsonReader.getAliment(selectedID);

            //ajoute l'aliment au fichier json de réfrigérateur
            RefrigerateurJsonReader.addAliment(aliment);

            //retire l'aliment du fichier json
            CourseJsonReader.removeAliment(selectedID);

            //retire l'aliment de la liste de l'interface
            listeCourse.getItems().remove(selectedID);
        }
        else{
            ArrayList<Aliment> courses = CourseJsonReader.getCourse();
            System.out.println(courses.size());
            for(int i=0; i<courses.size(); i++){
                System.out.println(i);
                Aliment aliment = courses.get(i);
                CourseJsonReader.removeAliment(aliment.getNom());
                RefrigerateurJsonReader.addAliment(aliment);
            }

            listeCourse.getItems().clear();
        }

    }

    public void ajouterCourse() {
        changePage(FXML_FILE_PATH2,ajouterCourse);
    }

    public void allerPageAccueil() {
        changePage(FXML_FILE_PATH1,revenirArriereListeCourse);
    }

    private void afficherListeCourse(){
        ArrayList<String> ingredients = CourseJsonReader.getListeCourse();
        for (String ingredient : ingredients) {
            listeCourse.getItems().add(ingredient);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        afficherListeCourse();
    }


}
