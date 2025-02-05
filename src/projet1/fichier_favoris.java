/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet1;

/**
 *
 * @author ASUS
 */
public class fichier_favoris {
     private String auteur;
    private String titre;
    private String tags;
    private String resume;
    private String commentaire;
    private String utilisateur;
    private String fichier;
    public fichier_favoris(String auteur, String titre, String tags, String resume, String commentaire,String fichier) {
        this.auteur = auteur;
        this.titre = titre;
        this.tags = tags;
        this.resume = resume;
        this.commentaire = commentaire;
        this.fichier = fichier;
        
    }

    public fichier_favoris() {
    }
    

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    
    public String getTitre() {
        return titre;
    }
    public String getFichier() {
        return fichier;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
    
}
