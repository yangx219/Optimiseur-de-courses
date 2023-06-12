package Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Recette {
    private String nomRecette;
    private ArrayList<Aliment> ingredients;


    public Recette(@JsonProperty("nomRecette") String nomRecette,
                @JsonProperty("ingredients") ArrayList<Aliment> ingredients){
        this.nomRecette = nomRecette;
        this.ingredients = ingredients;
    }


    @Override
    public String toString() {
        return "Recette{" +
                "nomDuRcette='" + nomRecette + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }


    public String getNomRecette() {
        return nomRecette;
    }

    public ArrayList<Aliment> getIngredients() {
        return ingredients;
    }

    public void setNomRecette(String nomRecette) {
        this.nomRecette = nomRecette;
    }

    public void setIngredients(ArrayList<Aliment> ingredients) {
        this.ingredients = ingredients;
    }
}
