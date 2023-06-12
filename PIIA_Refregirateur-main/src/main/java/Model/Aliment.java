package Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Aliment {
    public String nom;
    public String type;
    int taille ;
    int unite;


    public Aliment(@JsonProperty("nom") String nom,
                      @JsonProperty("type") String type,
                      @JsonProperty("taille") int taille,
                     @JsonProperty("unite") int unite){
        this.nom = nom;
        this.type = type;
        this.taille = taille;
        this.unite = unite;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public int getTaille() {
        return taille;
    }

    public int getUnite() {
        return unite;
    }
}
