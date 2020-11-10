package vue;

/**
 * Classe servant de point d'entrée au programme
 */
public class Start{

    public static void main(String[] args) {
        GestionVueAbstraite ihm = new Vue();
        ihm.init();
    }
}