package ma.emsi.tp0lakehal.jsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalTime;

@Named("chatBean")
@SessionScoped
public class ChatBean implements Serializable {

    private String role;
    private boolean roleSelected;
    private String question;
    private String reponse;
    private String conversation;

    public void nouveauChat() {
        roleSelected = false;
        question = "";
        reponse = "";
        conversation = "";
    }

    public void envoyer() {

        if (role == null || role.isEmpty()) {
            reponse = "⚠️ Choisissez d'abord un rôle avant d'envoyer un message.";
            return;
        }


        if (question == null || question.isEmpty()) {
            reponse = "⚠️ Écrivez une question avant d'envoyer.";
            return;
        }


        LocalTime heure = LocalTime.now();
        int heureJour = heure.getHour();

        String conseil = "";
        if (heureJour >= 6 && heureJour < 12) {
            conseil = " Bon matin ! ";
        } else if (heureJour >= 12 && heureJour < 18) {
            conseil = "Bon après-midi ! ";
        } else if (heureJour >= 18 && heureJour < 22) {
            conseil = "Bonsoir ! ";
        } else {
            conseil = " Il est tard ! ";
        }

        // Ajoute une analyse simple de la longueur
        if (question.length() < 10) {
            conseil += "Votre question est courte. Pourriez-vous développer ?";
        } else if (question.length() < 50) {
            conseil += "Question claire et concise !";
        } else {
            conseil += "Question détaillée, j'analyse " + question.split("\\s+").length + " mots.";
        }

        reponse = conseil;
        conversation += "Moi: " + question + "\n" + "Bot: " + reponse + "\n\n";
        question = "";
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isRoleSelected() {
        return roleSelected;
    }

    public void setRoleSelected(boolean roleSelected) {
        this.roleSelected = roleSelected;
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
}