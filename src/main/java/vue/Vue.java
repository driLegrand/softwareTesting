package vue;

import modele.ActionsBDImpl;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modele.ProgrammeurBean;
import java.awt.Color;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JComponent;

/**
 * Classe gérant la vue de la mise à jour des données des programmeurs
 *
 * @author Daouya-Pauline
 */
public class Vue extends GestionVueAbstraite {

    private JButton btnAfficherTous;
    private JScrollPane scroll;
    private ProgrammeurBean progrBean;
    private JButton btnValiderEcranAjouter;
    private JButton btnValiderEcranSupprimer;
    private JButton btnValiderEcranModifier;
    private int gestionErreur;

    private JButton btnRechercher;
    private JButton btnReinitialiser;
    private JButton btnAnnuler;
    private JLabel labelMatricule;
    private JTextField champMatricule;
    private JLabel labelNom;
    private JTextField champNom;
    private JLabel labelPrenom;
    private JTextField champPrenom;
    private JLabel labelAdresse;
    private JTextField champAdresse;
    private JLabel labelPseudo;
    private JTextField champPseudo;
    private JLabel labelResponsable;
    private JTextField champResponsable;
    private JLabel labelHobby;
    private JTextField champHobby;
    private JLabel labelDate_naiss;
    private JTextField champJourDate_naiss;
    private JComboBox comboMoisDate_naiss;
    private JTextField champAnneeDate_naiss;
    private JLabel labelDate_emb;
    private JTextField champJourDate_emb;
    private JComboBox comboMoisDate_emb;
    private JTextField champAnneeDate_emb;
    private List<JComponent> listComponents;

    /**
     * Ajoute les clabels et champs du panel à la liste listComponents
     */
    public void addToList() {
        listComponents = new ArrayList<>();
        listComponents.add(labelMatricule);
        listComponents.add(champMatricule);
        listComponents.add(labelNom);
        listComponents.add(champNom);
        listComponents.add(labelPrenom);
        listComponents.add(champPrenom);
        listComponents.add(labelAdresse);
        listComponents.add(champAdresse);
        listComponents.add(labelPseudo);
        listComponents.add(champPseudo);
        listComponents.add(labelResponsable);
        listComponents.add(champResponsable);
        listComponents.add(labelHobby);
        listComponents.add(champHobby);
        listComponents.add(labelDate_naiss);
        listComponents.add(champJourDate_naiss);
        listComponents.add(comboMoisDate_naiss);
        listComponents.add(champAnneeDate_naiss);
        listComponents.add(labelDate_emb);
        listComponents.add(champJourDate_emb);
        listComponents.add(comboMoisDate_emb);
        listComponents.add(champAnneeDate_emb);
    }

    /**
     * Met en place le panel permettant de mettre à jour les données des
     * programmeurs
     */
    @Override
    public void display() {
        paneGenerique = new JPanel();

        labelMatricule = new JLabel("Matricule");
        champMatricule = new JTextField();
        labelNom = new JLabel("Nom");
        champNom = new JTextField();
        labelPrenom = new JLabel("Prénom");
        champPrenom = new JTextField();
        labelAdresse = new JLabel("Adresse");
        champAdresse = new JTextField();
        labelPseudo = new JLabel("Pseudo");
        champPseudo = new JTextField();
        labelResponsable = new JLabel("Responsable");
        champResponsable = new JTextField();
        labelHobby = new JLabel("Hobby");
        champHobby = new JTextField();
        labelDate_naiss = new JLabel("Date de naissance");
        champJourDate_naiss = new JTextField("jour");
        Object[] mois = new Object[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        comboMoisDate_naiss = new JComboBox(mois);
        champAnneeDate_naiss = new JTextField("année");
        labelDate_emb = new JLabel("Date d'embauche");
        champJourDate_emb = new JTextField("jour");
        comboMoisDate_emb = new JComboBox(mois);
        champAnneeDate_emb = new JTextField("année");
        addToList();
        addTo(paneGenerique, listComponents);
        paneGenerique.setLayout(null);
        setFieldBounds(labelMatricule, 10, 10, 80);
        setFieldBounds(champMatricule, 70, 10, 100);
        setFieldBounds(labelNom, 40, 60, 80);
        setFieldBounds(champNom, 140, 60, 100);
        setFieldBounds(labelPrenom, 260, 60, 80);
        setFieldBounds(champPrenom, 390, 60, 100);
        setFieldBounds(labelAdresse, 40, 90, 80);
        setFieldBounds(champAdresse, 140, 90, 100);
        setFieldBounds(labelPseudo, 260, 90, 80);
        setFieldBounds(champPseudo, 390, 90, 100);
        setFieldBounds(labelResponsable, 40, 120, 80);
        setFieldBounds(champResponsable, 140, 120, 100);
        setFieldBounds(labelDate_naiss, 260, 120, 100);
        setFieldBounds(champJourDate_naiss, 390, 120, 50);
        setFieldBounds(comboMoisDate_naiss, 460, 120, 40);
        setFieldBounds(champAnneeDate_naiss, 520, 120, 60);
        setFieldBounds(labelHobby, 40, 150, 80);
        setFieldBounds(champHobby, 140, 150, 100);
        setFieldBounds(labelDate_emb, 260, 150, 120);
        setFieldBounds(champJourDate_emb, 390, 150, 100);
        setFieldBounds(champJourDate_emb, 390, 150, 50);
        setFieldBounds(comboMoisDate_emb, 460, 150, 40);
        setFieldBounds(champAnneeDate_emb, 520, 150, 60);
    }

    /**
     * Préconfigure le setBounds d'un label ou champ du panel
     *
     * @param component
     * @param x
     * @param y
     * @param width
     */
    public void setFieldBounds(JComponent component, int x, int y, int width) {
        component.setBounds(x, y, width, 20);
    }

    /**
     * Préconfigure le setBounds d'un bouton du panel
     *
     * @param button
     * @param x
     */
    public void setButtonBounds(JButton button, int x) {
        button.setBounds(x, 200, 100, 30);
    }

    /**
     * Met en place le panel permettant d'afficher les programmeurs
     */
    public void displayAfficherTous() {
        paneAfficher = new JPanel();
        zoneAffichageProgrammeurs = new JTextArea();
        zoneAffichageProgrammeurs = new JTextArea(10, 70);
        scroll = new JScrollPane(zoneAffichageProgrammeurs);
        paneAfficher.add(scroll);
    }

    /**
     * Met en place le panel permettant de modifier les données des programmeurs
     */
    public void displayModifier() {
        btnRechercher = new JButton("Rechercher");
        btnReinitialiser = new JButton("Réinitialiser");
        btnValiderEcranModifier = new JButton("Valider");
        btnAnnuler = new JButton("Annuler");
        paneGenerique.add(btnRechercher);
        paneGenerique.add(btnReinitialiser);
        paneGenerique.add(btnValiderEcranModifier);
        paneGenerique.add(btnAnnuler);
        btnRechercher.addActionListener(this);
        btnAnnuler.addActionListener(this);
        btnReinitialiser.setEnabled(false);
        btnValiderEcranModifier.setEnabled(false);
        setButtonBounds(btnRechercher, 85);
        setButtonBounds(btnReinitialiser, 190);
        setButtonBounds(btnValiderEcranModifier, 295);
        setButtonBounds(btnAnnuler, 400);
    }

    /**
     * Met en place le panel permettant d'enregistrer les données des
     * programmeurs mises à jour
     */
    public void displayModifierFinal() {
        btnRechercher = new JButton("Rechercher");
        btnReinitialiser = new JButton("Réinitialiser");
        btnValiderEcranModifier = new JButton("Valider");
        btnAnnuler = new JButton("Annuler");
        paneGenerique.add(btnRechercher);
        paneGenerique.add(btnReinitialiser);
        paneGenerique.add(btnValiderEcranModifier);
        paneGenerique.add(btnAnnuler);
        btnRechercher.addActionListener(this);
        btnValiderEcranModifier.addActionListener(this);
        btnReinitialiser.setEnabled(false);
        btnAnnuler.addActionListener(this);
        setButtonBounds(btnRechercher, 85);
        setButtonBounds(btnReinitialiser, 190);
        setButtonBounds(btnValiderEcranModifier, 295);
        setButtonBounds(btnAnnuler, 400);
    }

    /**
     * Met en place le panel permettant d'ajouter des programmeurs
     */
    public void displayAjouter() {
        btnRechercher = new JButton("Rechercher");
        btnReinitialiser = new JButton("Réinitialiser");
        btnValiderEcranAjouter = new JButton("Valider");
        btnAnnuler = new JButton("Annuler");
        paneGenerique.add(btnRechercher);
        paneGenerique.add(btnReinitialiser);
        paneGenerique.add(btnValiderEcranAjouter);
        paneGenerique.add(btnAnnuler);
        btnRechercher.setEnabled(false);
        btnReinitialiser.addActionListener(this);
        btnValiderEcranAjouter.addActionListener(this);
        btnAnnuler.addActionListener(this);
        setButtonBounds(btnRechercher, 85);
        setButtonBounds(btnReinitialiser, 190);
        setButtonBounds(btnValiderEcranAjouter, 295);
        setButtonBounds(btnAnnuler, 400);
    }

    /**
     * Met en place le panel permettant de supprimer les données des
     * programmeurs
     */
    public void displaySupprimer() {
        btnRechercher = new JButton("Rechercher");
        btnReinitialiser = new JButton("Réinitialiser");
        btnValiderEcranSupprimer = new JButton("Valider");
        btnAnnuler = new JButton("Annuler");
        paneGenerique.add(btnRechercher);
        paneGenerique.add(btnReinitialiser);
        paneGenerique.add(btnValiderEcranSupprimer);
        paneGenerique.add(btnAnnuler);
        addToList();
        disableAll(listComponents);
        labelMatricule.setEnabled(true);
        champMatricule.setEnabled(true);
        btnValiderEcranSupprimer.addActionListener(this);
        btnAnnuler.addActionListener(this);
        setButtonBounds(btnRechercher, 85);
        setButtonBounds(btnReinitialiser, 190);
        setButtonBounds(btnValiderEcranSupprimer, 295);
        setButtonBounds(btnAnnuler, 400);
    }

    /**
     * Gère les évènements engendré par l'utilisateur
     *
     * @param event Evènement généré par l'utilisateur
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == itemTous) {
            //affichage du nouveau panel           
            getContentPane().removeAll();
            this.displayAfficherTous();
            this.setContentPane(paneAfficher);
            this.revalidate();
            this.repaint();
            dt = new ActionsBDImpl();
            contenuTextArea = dt.afficherProgrammeurs();
            zoneAffichageProgrammeurs.setText(contenuTextArea);
            dt.fermerRessources();
        } else if (event.getSource() == itemModifier) {
            getContentPane().removeAll();
            this.display();
            this.displayModifier();
            this.setContentPane(paneGenerique);
            this.revalidate();
            this.repaint();
        } else if (event.getSource() == itemSupprimer) {
            getContentPane().removeAll();
            this.display();
            this.displaySupprimer();
            this.setContentPane(paneGenerique);
            this.revalidate();
            this.repaint();
        } else if (event.getSource() == itemAjouter || event.getSource() == btnReinitialiser) {
            getContentPane().removeAll();
            this.display();
            this.displayAjouter();
            this.setContentPane(paneGenerique);
            this.revalidate();
            this.repaint();
        } else if (event.getSource() == itemQuitter) {
            choixPopUp = JOptionPane.showConfirmDialog(this, "Vérification", "Voulez-vous vraiment quitter?", JOptionPane.YES_NO_OPTION);
            if (choixPopUp == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else if (event.getSource() == btnAfficherTous) {
            dt = new ActionsBDImpl();
            contenuTextArea = dt.afficherProgrammeurs();
            zoneAffichageProgrammeurs.setText(contenuTextArea);
            dt.fermerRessources();
        } else if (event.getSource() == btnRechercher) {
            dt = new ActionsBDImpl();
            progrBean = dt.getProgrammeur(this.champMatricule.getText());
            if (progrBean == null) {
                JOptionPane.showMessageDialog(this, "Programmeur introuvable", "Echec", JOptionPane.ERROR_MESSAGE);
            } else {
                getContentPane().removeAll();
                this.display();
                this.displayModifierFinal();
                this.setContentPane(paneGenerique);
                this.revalidate();
                this.repaint();
                this.champMatricule.setText(progrBean.getMatricule());
                this.champNom.setText(progrBean.getNom());
                this.champPrenom.setText(progrBean.getPrenom());
                this.champAdresse.setText(progrBean.getAdresse());
                this.champPseudo.setText(progrBean.getPseudo());
                this.champResponsable.setText(progrBean.getResponsable());
                this.champHobby.setText(progrBean.getHobby());
                Date date_naiss = progrBean.getDate_naiss();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date_naiss);
                this.champJourDate_naiss.setText(Integer.toString(cal.get(Calendar.DAY_OF_MONTH)));
                this.comboMoisDate_naiss.setSelectedIndex(cal.get(Calendar.MONTH));
                this.champAnneeDate_naiss.setText(Integer.toString(cal.get(Calendar.YEAR)));
                Date date_emb = progrBean.getDate_emb();
                cal.setTime(date_emb);
                this.champJourDate_emb.setText(Integer.toString(cal.get(Calendar.DAY_OF_MONTH)));
                this.comboMoisDate_emb.setSelectedIndex(cal.get(Calendar.MONTH));
                this.champAnneeDate_emb.setText(Integer.toString(cal.get(Calendar.YEAR)));
            }
            dt.fermerRessources();
        }
        if (event.getSource() == btnValiderEcranModifier) {
            if (this.champMatricule.getText().isEmpty() || this.champNom.getText().isEmpty() || this.champPrenom.getText().isEmpty() || this.champAdresse.getText().isEmpty() || this.champPseudo.getText().isEmpty() || this.champResponsable.getText().isEmpty() || this.champHobby.getText().isEmpty() || this.champJourDate_naiss.getText().equals("jour") || this.champJourDate_naiss.getText().isEmpty() || this.comboMoisDate_naiss.getSelectedItem().toString().isEmpty() || this.champAnneeDate_naiss.getText().equals("année") || this.champAnneeDate_naiss.getText().isEmpty() || this.champJourDate_emb.getText().equals("jour") || this.champJourDate_emb.getText().isEmpty() || this.comboMoisDate_emb.getSelectedItem().toString().isEmpty() || this.champAnneeDate_emb.getText().equals("année") || this.champAnneeDate_emb.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tous les champs doivent être remplis", "Echec", JOptionPane.ERROR_MESSAGE);
            } else {
                dt = new ActionsBDImpl();
                gestionErreur = dt.modifierProgrammeur(this.champMatricule.getText(), this.champNom.getText(), this.champPrenom.getText(), this.champAdresse.getText(), this.champPseudo.getText(), this.champResponsable.getText(), this.champHobby.getText(), this.champJourDate_naiss.getText(), this.comboMoisDate_naiss.getSelectedItem().toString(), this.champAnneeDate_naiss.getText(), this.champJourDate_emb.getText(), this.comboMoisDate_emb.getSelectedItem().toString(), this.champAnneeDate_emb.getText());
                dt.fermerRessources();

                if (gestionErreur == 0) {
                    JOptionPane.showMessageDialog(this, "Modification réussie !", "Succès!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Une erreur s'est produite", "Echec", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (event.getSource() == btnValiderEcranAjouter) {
            if (this.champMatricule.getText().isEmpty() || this.champNom.getText().isEmpty() || this.champPrenom.getText().isEmpty() || this.champAdresse.getText().isEmpty() || this.champPseudo.getText().isEmpty() || this.champResponsable.getText().isEmpty() || this.champHobby.getText().isEmpty() || this.champJourDate_naiss.getText().equals("jour") || this.champJourDate_naiss.getText().isEmpty() || this.comboMoisDate_naiss.getSelectedItem().toString().isEmpty() || this.champAnneeDate_naiss.getText().equals("année") || this.champAnneeDate_naiss.getText().isEmpty() || this.champJourDate_emb.getText().equals("jour") || this.champJourDate_emb.getText().isEmpty() || this.comboMoisDate_emb.getSelectedItem().toString().isEmpty() || this.champAnneeDate_emb.getText().equals("année") || this.champAnneeDate_emb.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Tous les champs doivent être remplis", "Echec", JOptionPane.ERROR_MESSAGE);
            } else {
                dt = new ActionsBDImpl();
                progrBean = dt.getProgrammeur(this.champMatricule.getText());
                dt.fermerRessources();
                if (progrBean != null) {
                    JOptionPane.showMessageDialog(this, "Attention ce matricule existe déjà ", "Echec", JOptionPane.ERROR_MESSAGE);
                } else {
                    dt = new ActionsBDImpl();
                    gestionErreur = dt.ajouterProgrammeur(this.champMatricule.getText(), this.champNom.getText(), this.champPrenom.getText(), this.champAdresse.getText(), this.champPseudo.getText(), this.champResponsable.getText(), this.champHobby.getText(), this.champJourDate_naiss.getText(), this.comboMoisDate_naiss.getSelectedItem().toString(), this.champAnneeDate_naiss.getText(), this.champJourDate_emb.getText(), this.comboMoisDate_emb.getSelectedItem().toString(), this.champAnneeDate_emb.getText());
                    dt.fermerRessources();
                    if (gestionErreur == 0) {
                        JOptionPane.showMessageDialog(this, "Ajouté avec succès !", "Succès!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Une erreur s'est produite", "Echec", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        if (event.getSource() == btnValiderEcranSupprimer) {
            dt = new ActionsBDImpl();
            progrBean = dt.getProgrammeur(this.champMatricule.getText());
            dt.fermerRessources();
            if (progrBean == null) {
                JOptionPane.showMessageDialog(this, "Programmeur introuvable", "Echec", JOptionPane.ERROR_MESSAGE);
            } else {
                dt = new ActionsBDImpl();
                gestionErreur = dt.supprimerProgrammeur(this.champMatricule.getText());
                dt.fermerRessources();
                if (gestionErreur == 0) {
                    JOptionPane.showMessageDialog(this, "Suppression réussie !", "Succès!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Une erreur s'est produite", "Echec", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (event.getSource() == btnAnnuler) {
            getContentPane().removeAll();
            colorer(paneAccueil, Color.GRAY);
            this.revalidate();
            this.repaint();
        }
    }
}
