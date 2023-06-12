package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Aliment;

public class Model {

    private int nbPersonne;
    private static Model instance = null;
    public ObservableList<Aliment> alimentList = FXCollections.observableArrayList();

    private Model() {
        // Private constructor to prevent creating new instances from outside
    }

    public static synchronized Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public void setNbPersonne(int nbPersonne) {
        this.nbPersonne = nbPersonne;
    }

    public int getnbPersonne() {
        return nbPersonne;
    }

    public void addAliment(Aliment aliment) {
        alimentList.add(aliment);
    }
}
