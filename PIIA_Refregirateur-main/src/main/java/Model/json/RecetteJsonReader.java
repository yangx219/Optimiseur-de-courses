package Model.json;


import Model.Aliment;
import Model.Recette;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class RecetteJsonReader {


    /**
     * Lit le fichier json et renvoie tous les noms de recette
     * @return la liste des noms de recette
     */
    public static ArrayList<String> getNomRecette(){
        ArrayList<String> nomRecettes = new ArrayList<>();
        try {
            //Lecture du fichier JSON existant
            File file = new File("src/main/resources/json/recettes.json");
            ObjectMapper objectMapper = new ObjectMapper();

            //sérialisation
            ArrayList<Recette> recettes  = objectMapper.readValue(file, new TypeReference<ArrayList<Recette>>() {});


            for (Recette recette : recettes) {
                nomRecettes.add(recette.getNomRecette());
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return nomRecettes;
    }

    /**
     * Cherche la recette correspondante au nom de recette
     * @param index de la recette
     * @return recette
     */
    public static Recette getRecette(int index){
        try {
            //Lecture du fichier JSON existant
            File file = new File("src/main/resources/json/recettes.json");
            ObjectMapper objectMapper = new ObjectMapper();

            //sérialisation
            ArrayList<Recette> recettes  = objectMapper.readValue(file, new TypeReference<ArrayList<Recette>>() {});


            return recettes.get(index);

        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Cherche les ingrédients de la recette correspondante
     * @param index de la recette
     * @return nom des ingrédients
     */
    public static ArrayList<Aliment> getIngredients(int index){
        ArrayList<Aliment> ingredients = new ArrayList<>();
        try {
            //Lecture du fichier JSON existant
            File file = new File("src/main/resources/json/recettes.json");
            ObjectMapper objectMapper = new ObjectMapper();

            //sérialisation
            ArrayList<Recette> recettes  = objectMapper.readValue(file, new TypeReference<ArrayList<Recette>>() {});

            ingredients =  recettes.get(index).getIngredients();

        }catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    /**
     * Cherche les ingrédients de la recette correspondante
     * @param index de la recette
     * @return nom des ingrédients
     */
    public static ArrayList<String> getIngredientsNom(int index){
        ArrayList<String> noms = new ArrayList<>();
        try {
            //Lecture du fichier JSON existant
            File file = new File("src/main/resources/json/recettes.json");
            ObjectMapper objectMapper = new ObjectMapper();

            //sérialisation
            ArrayList<Recette> recettes  = objectMapper.readValue(file, new TypeReference<ArrayList<Recette>>() {});

            for(int i=0; i<recettes.get(index).getIngredients().size();i++){
                noms.add(recettes.get(index).getIngredients().get(i).getNom());
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return noms;
    }


    /**
     * Supprime une recette du fichier json
     * @param index l'index de la recette a supprimé
     */
    public static void removeRecette(int index){
        try {
            //Lecture du fichier JSON existant
            File file = new File("src/main/resources/json/recettes.json");
            ObjectMapper objectMapper = new ObjectMapper();

            //sérialisation
            ArrayList<Recette> recettes  = objectMapper.readValue(file, new TypeReference<ArrayList<Recette>>() {});

            //retire la recette
            recettes.remove(index);

            //mise à jour du fichier json
            JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(
                    new File("src/main/resources/json/recettes.json"), JsonEncoding.UTF8);
            jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
            objectMapper.writeValue(jsonGenerator, recettes);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ajoute une recette au fichier json
     * @param recette à ajouter
     */
    public static void addRecette(Recette recette){
        try {
            //Lecture du fichier JSON existant
            File file = new File("src/main/resources/json/recettes.json");
            ObjectMapper objectMapper = new ObjectMapper();

            //sérialisation
            ArrayList<Recette> recettes  = objectMapper.readValue(file, new TypeReference<ArrayList<Recette>>() {});

            //ajoute une recette
            recettes.add(recette);

            //mise à jour du fichier json
            JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(
                    new File("src/main/resources/json/recettes.json"), JsonEncoding.UTF8);
            jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
            objectMapper.writeValue(jsonGenerator, recettes);

        }catch (IOException e) {
            e.printStackTrace();
        }


    }

}
