package ma.emsi.tp0lakehal.jsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

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
            reponse = "⚠️ Choisissez d’abord un rôle avant d’envoyer un message.";
            return;
        }
        if (question == null || question.isEmpty()) {
            reponse = "⚠️ Écrivez une question avant d’envoyer.";
            return;
        }

        // Simulation de la réponse IA
        reponse = "Réponse automatique du rôle " + role + " : " + question.toUpperCase();
        conversation += "Moi: " + question + "\n" + "Bot: " + reponse + "\n\n";
        question = "";
    }

    // Getters et setters nécessaires à JSF
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public boolean isRoleSelected() { return roleSelected; }
    public void setRoleSelected(boolean roleSelected) { this.roleSelected = roleSelected; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getReponse() { return reponse; }
    public void setReponse(String reponse) { this.reponse = reponse; }

    public String getConversation() { return conversation; }
    public void setConversation(String conversation) { this.conversation = conversation; }
}
