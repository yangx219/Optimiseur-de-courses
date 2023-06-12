package Model.json;

import Model.Aliment;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RefrigerateurJsonReader {


    /**
     * Lit et récupère la liste des aliments du fichier json
     * @return la liste des aliments
     */
    public static ArrayList<Aliment> getAliment(){
        ArrayList<Aliment> aliments = new ArrayList<>();
        try{
            //Lecture du fichier JSON existant
            File file = new File("src/main/resources/json/refrigerateur.json");
            ObjectMapper objectMapper = new ObjectMapper();

            //sérialisation
            aliments  = objectMapper.readValue(file, new TypeReference<ArrayList<Aliment>>() {});

        }catch (IOException e) {
            e.printStackTrace();
        }
        return aliments;
    }

    /**
     * Lit et récupère la liste des aliments du fichier json
     * @return la liste des aliments
     */
    public static ArrayList<String> getAlimentNom(){
        ArrayList<String> aliments = new ArrayList<>();
        try{
            //Lecture du fichier JSON existant
            File file = new File("src/main/resources/json/refrigerateur.json");
            ObjectMapper objectMapper = new ObjectMapper();

            //sérialisation
            ArrayList<Aliment> liste  = objectMapper.readValue(file, new TypeReference<ArrayList<Aliment>>() {});

            for(int i=0; i<liste.size();i++){
                aliments.add(liste.get(i).getNom());
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return aliments;
    }

    /**
     * Ajoute un aliment au fichier json
     * @param aliment à ajouter
     */
    public static void addAliment(Aliment aliment){
        try {
            //Lecture du fichier JSON existant
            File file = new File("src/main/resources/json/refrigerateur.json");
            ObjectMapper objectMapper = new ObjectMapper();

            //sérialisation
            ArrayList<Aliment> aliments  = objectMapper.readValue(file, new TypeReference<ArrayList<Aliment>>() {});

            //ajoute un aliment
            aliments.add(aliment);

            //mise à jour du fichier json
            JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(
                    new File("src/main/resources/json/refrigerateur.json"), JsonEncoding.UTF8);
            jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
            objectMapper.writeValue(jsonGenerator, aliments);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Supprime une recette du fichier json
     * @param ingredients listes des noms des aliments a supprimer
     */
    public static void removeAliment(ArrayList<String> ingredients){
        try {
            //Lecture du fichier JSON existant
            File file = new File("src/main/resources/json/refrigerateur.json");
            ObjectMapper objectMapper = new ObjectMapper();

            //sérialisation
            ArrayList<Aliment> aliments  = objectMapper.readValue(file, new TypeReference<ArrayList<Aliment>>() {});


            //retire la recette
            for(int i=0; i<ingredients.size();i++){
                Boolean retirer = false;
                for(int j=0; j<aliments.size();j++){
                    if(aliments.get(j).getNom().equals(ingredients.get(i)) && !retirer){
                        aliments.remove(j);
                        retirer = true;
                    }

                }
            }

            //mise à jour du fichier json
            JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(
                    new File("src/main/resources/json/refrigerateur.json"), JsonEncoding.UTF8);
            jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
            objectMapper.writeValue(jsonGenerator, aliments);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
