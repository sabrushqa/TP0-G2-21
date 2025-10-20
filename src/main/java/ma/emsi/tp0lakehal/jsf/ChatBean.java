package ma.emsi.tp0lakehal.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;

@Named("chatBean")
@ViewScoped
public class ChatBean implements Serializable {
    private String role = "";
    private boolean roleSelected = false;
    private String question;
    private String reponse;
    private StringBuilder conversation = new StringBuilder();

    public String getRole() { return role; }
    public void setRole(String role) {
        this.role = role;
        if (role != null && !role.isBlank()) roleSelected = true;
    }
    public boolean isRoleSelected() { return roleSelected; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getReponse() { return reponse; }
    public String getConversation() { return conversation.toString(); }

    // Action invoked when clicking "Envoyer"
    public String envoyer() {
        if (question == null || question.isBlank()) {
            reponse = "Erreur : la question est vide.";
            return null; // rester sur la même vue -> même instance viewScoped
        }
        // Traitement simple demandé par le TP :
        reponse = "|| " + role + " : " + transform(question) + " ||";
        // Ajoute à l'historique
        conversation.append("Vous: ").append(question).append("\n");
        conversation.append("API: ").append(reponse).append("\n\n");

        // effacer la question pour la prochaine saisie
        question = null;
        return null;
    }

    private String transform(String q) {
        // Ex : inverse la casse
        StringBuilder sb = new StringBuilder();
        for (char c : q.toCharArray()) {
            if (Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
            else sb.append(Character.toUpperCase(c));
        }
        return sb.toString();
    }

    // "Nouveau chat" : retourne "index.xhtml" pour forcer une nouvelle vue
    public String nouveauChat() {
        return "index.xhtml";
    }
}
