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

public class CourseJsonReader {

    /**
     * Lit le fichier json et renvoie une liste de course
     * @return la liste des noms des courses
     */
    public static ArrayList<String> getListeCourse(){
        ArrayList<String> ingredients = new ArrayList<>();
        try {
            //Lecture du fichier JSON existant
            File file = new File("src/main/resources/json/courses.json");
            ObjectMapper objectMapper = new ObjectMapper();

            //sérialisation
            ArrayList<Aliment> aliments  = objectMapper.readValue(file, new TypeReference<ArrayList<Aliment>>() {});


            for (Aliment aliment : aliments) {
                ingredients.add(aliment.getNom());

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    /**
     * Lit le fichier json et renvoie une liste de course
     * @return la liste des courses
     */
    public static ArrayList<Aliment> getCourse(){
        ArrayList<Aliment> ingredients = new ArrayList<>();
        try {
            //Lecture du fichier JSON existant
            File file = new File("src/main/resources/json/courses.json");
            ObjectMapper objectMapper = new ObjectMapper();

            //sérialisation
            ArrayList<Aliment> aliments  = objectMapper.readValue(file, new TypeReference<ArrayList<Aliment>>() {});

            ingredients = aliments;


        }catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    /**
     * Ajoute un aliment au fichier json
     * @param aliment à ajouter
     */
    public static void addCourse(Aliment aliment){
        try {
            //Lecture du fichier JSON existant
            File file = new File("src/main/resources/json/courses.json");
            ObjectMapper objectMapper = new ObjectMapper();

            //sérialisation
            ArrayList<Aliment> aliments  = objectMapper.readValue(file, new TypeReference<ArrayList<Aliment>>() {});

            //ajoute une recette
            aliments.add(aliment);

            //mise à jour du fichier json
            JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(
                    new File("src/main/resources/json/courses.json"), JsonEncoding.UTF8);
            jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
            objectMapper.writeValue(jsonGenerator, aliments);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Supprime un aliment du fichier json
     * @param index l'index de l'aliment
     */
    public static void removeAliment(int index){
        try {
            //Lecture du fichier JSON existant
            File file = new File("src/main/resources/json/courses.json");
            ObjectMapper objectMapper = new ObjectMapper();

            //sérialisation
            ArrayList<Aliment> courses  = objectMapper.readValue(file, new TypeReference<ArrayList<Aliment>>() {});

            //retire l'aliment
            courses.remove(index);
            //mise à jour du fichier json
            JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(
                    new File("src/main/resources/json/courses.json"), JsonEncoding.UTF8);
            jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
            objectMapper.writeValue(jsonGenerator, courses);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Supprime un aliment du fichier json
     * @param aliment aliment
     */
    public static void removeAliment(String aliment){
        try {
            //Lecture du fichier JSON existant
            File file = new File("src/main/resources/json/courses.json");
            ObjectMapper objectMapper = new ObjectMapper();

            //sérialisation
            ArrayList<Aliment> courses  = objectMapper.readValue(file, new TypeReference<ArrayList<Aliment>>() {});

            //retire l'aliment
            Boolean retirer = false;
            for(int i=0; i<courses.size(); i++){
                if(!retirer && courses.get(i).getNom().equals(aliment)){
                    courses.remove(i);
                    retirer = true;
                }
            }

            //mise à jour du fichier json
            JsonGenerator jsonGenerator = objectMapper.getFactory().createGenerator(
                    new File("src/main/resources/json/courses.json"), JsonEncoding.UTF8);
            jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
            objectMapper.writeValue(jsonGenerator, courses);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cherche la recette correspondante au nom de recette
     * @param index de la recette
     * @return recette
     */
    public static Aliment getAliment(int index){
        Aliment aliments = new Aliment("","", 0,0);
        try {
            //Lecture du fichier JSON existant
            File file = new File("src/main/resources/json/courses.json");
            ObjectMapper objectMapper = new ObjectMapper();

            //sérialisation
            ArrayList<Aliment> courses  = objectMapper.readValue(file, new TypeReference<ArrayList<Aliment>>() {});

            System.out.println("course size " + courses.size());
            aliments =  courses.get(index);

        }catch (IOException e) {
            e.printStackTrace();
        }
        return aliments;
    }

}
