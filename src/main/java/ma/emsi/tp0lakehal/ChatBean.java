package ma.emsi.tp0lakehal;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;


@Named
@ViewScoped
public class ChatBean implements Serializable {

    private String roleSysteme;
    private boolean roleChoisi = false;
    private String question;
    private String reponse;
    private String conversation = "";



    public String getRoleSysteme() {
        return roleSysteme;
    }

    public void setRoleSysteme(String roleSysteme) {
        this.roleSysteme = roleSysteme;
    }

    public boolean isRoleChoisi() {
        return roleChoisi;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getConversation() {
        return conversation;
    }

    public void setConversation(String conversation) {
        this.conversation = conversation;
    }


    public String envoyerQuestion() {

        if (!roleChoisi) {
            roleChoisi = true;
        }


        String reponseGeneree = traiterQuestion(question, roleSysteme);


        this.reponse = reponseGeneree;


        conversation += "Utilisateur : " + question + "\n";
        conversation += "API : " + reponseGeneree + "\n\n";


        return null;
    }


    private String traiterQuestion(String question, String role) {

        StringBuilder resultat = new StringBuilder();
        for (char c : question.toCharArray()) {
            if (Character.isUpperCase(c)) {
                resultat.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                resultat.append(Character.toUpperCase(c));
            } else {
                resultat.append(c);
            }
        }


        return "|| " + role + " : " + resultat.toString() + " ||";
    }


    public String effacer() {
        this.question = "";
        this.reponse = "";
        return null;
    }


    public String nouveauChat() {
      
        return "index.xhtml";
    }
}