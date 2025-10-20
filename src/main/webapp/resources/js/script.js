function copyToClipboard(elementId) {
    const element = document.getElementById(elementId);
    if (element) {
        element.select();
        element.setSelectionRange(0, 99999);

        try {
            document.execCommand('copy');
            alert('Contenu copié dans le presse-papiers !');
        } catch (err) {
            alert('Erreur lors de la copie : ' + err);
        }
    }
}