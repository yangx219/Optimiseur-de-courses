package Controle;

import Model.json.RefrigerateurJsonReader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Model.Aliment;


public class AjouterAliment extends ChangePage {
    private static final String FXML_FILE_PATH = "/FXML/Refrigerateur.fxml";

    public Button validerAjouterAliment;
    public Button revenirArriereAjouterAliment;

    public TextField nomAjouterAliment;
    public TextField typeAjouterAliment;
    public TextField tailleAjouterAliment;
    public TextField uniteAjouterAliment;


    public void validerAjouterAliment() {
        ajouterAliment();
        changePage(FXML_FILE_PATH,validerAjouterAliment);
    }


    public void allerPageRefrigerateur() {
        changePage(FXML_FILE_PATH,revenirArriereAjouterAliment);
    }

    /**
     * Ajouter un aliment au fichier json
     */
    public void ajouterAliment(){
        String nom = nomAjouterAliment.getText();
        String type = typeAjouterAliment.getText();
        int taille = Integer.parseInt(tailleAjouterAliment.getText());
        int unite = Integer.parseInt(uniteAjouterAliment.getText());

        RefrigerateurJsonReader.addAliment(new Aliment(nom,type,taille,unite));
        System.out.println(nom);
    }
/*
    private Stage getStage() {
        Scene sceneCourante = nomAjouterAliment.getScene();
        if (sceneCourante != null) {
            return (Stage) sceneCourante.getWindow();
        }
        return null;
    }

    public void ajouterAliment() throws IOException {
        String nom = nomAjouterAliment.getText();
        String type = typeAjouterAliment.getText();
        int taille = Integer.parseInt(tailleAjouterAliment.getText());
        int unite = Integer.parseInt(uniteAjouterAliment.getText());


        Aliment aliment1 = new Aliment(nom, type, taille, unite);
        Model.getInstance().addAliment(aliment1);

        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_FILE_PATH));
        Parent root = loader.load();

        for (int i = 0; i <Model.getInstance().alimentList.size(); i++) {
            TextField textField = new TextField();
            textField.setText(Model.getInstance().alimentList.get(i).nom);
            textField.setFont(Font.font(16));
            textField.setPrefSize(30, 30);
            textField.setAlignment(Pos.CENTER);

            switch (Model.getInstance().alimentList.get(i).type) {
                case "Fruits et légumes":
                    GridPane fruitsEtLegumes = (GridPane) loader.getNamespace().get("Fruits_et_légumes");
                    fruitsEtLegumes.add(textField, i % 4, i / 4);
                    Stage stage1 = getStage();
                    if (stage1 != null) {
                        stage1.show();
                    }
                    break;
                case "Viandes":
                    GridPane viandes = (GridPane) loader.getNamespace().get("Viandes");
                    viandes.add(textField, i % 3, i / 4);
                    Stage stage2 = getStage();
                    if (stage2 != null) {
                        stage2.show();
                    }
                    break;
                case "Bouteilles":
                    GridPane bouteilles = (GridPane) loader.getNamespace().get("Bouteilles");
                    bouteilles.add(textField, i % 2, i / 5);
                    Stage stage3 = getStage();
                    if (stage3 != null) {
                        stage3.show();
                    }
                    break;
                case "Pates":
                    GridPane pates = (GridPane) loader.getNamespace().get("Pates");
                    pates.add(textField, i % 3, i / 3);
                    Stage stage4 = getStage();
                    if (stage4 != null) {
                        stage4.show();
                    }
                    break;
            }
        }

        Scene scene = nomAjouterAliment.getScene();
        scene.setRoot(root);
        Stage stage = getStage();
        if (stage != null) {
            stage.close();
        }
    }

 */
}
