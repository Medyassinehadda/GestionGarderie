package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.Adressecontroller;
import controllers.EleveController;
import models.Adresse;
import models.Eleve;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class AddEleveView {

	public JFrame frAddEleve;
	private JTextField textNom;
	private JTextField textNumero;
	private JTextField textDat_Nais;
	private JTextField textCin;
	
	private JTextField txt_Ville;
	private JTextField txt_Governorat;
	private JTextField txt_Rue;
	private JTextField txt_Libelle;
	private JTextField txt_Postale;
	
	private JTextField textPr_Pere;
	private JTextField textPr_Gr_Pere;
	private JTextField textPrenom;
	private JTextField textNom_Mere;
	private JTextField textPr_Mere;
	private JTextField textImage;
	private JTextField textFNiveauScolaire;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEleveView window = new AddEleveView();
					window.frAddEleve.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddEleveView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frAddEleve = new JFrame();
		frAddEleve.setTitle("Add Animateur");
		frAddEleve.setBackground(new Color(0, 102, 102));
		frAddEleve.getContentPane().setBackground(new Color(0, 102, 102));
		frAddEleve.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(50, 10, 680, 777);
		frAddEleve.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 220, 220));
		panel_1.setBounds(10, 10, 660, 60);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCin = new JLabel("Numero CIN");
		lblCin.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblCin.setBounds(45, 10, 146, 40);
		panel_1.add(lblCin);
		
		textCin = new JTextField();
		textCin.setBounds(252, 13, 349, 40);
		panel_1.add(textCin);
		textCin.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(220, 220, 220));
		panel_1_1.setBounds(10, 80, 320, 60);
		panel.add(panel_1_1);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNom.setBounds(45, 10, 54, 40);
		panel_1_1.add(lblNom);
		
		textNom = new JTextField();
		textNom.setColumns(10);
		textNom.setBounds(172, 13, 133, 40);
		panel_1_1.add(textNom);
		
		JPanel panel_1_1_3 = new JPanel();
		panel_1_1_3.setLayout(null);
		panel_1_1_3.setBackground(new Color(220, 220, 220));
		panel_1_1_3.setBounds(10, 290, 660, 60);
		panel.add(panel_1_1_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Telephone ");
		lblNewLabel_1_3.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(45, 10, 96, 40);
		panel_1_1_3.add(lblNewLabel_1_3);
		
		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(252, 13, 349, 40);
		panel_1_1_3.add(textNumero);
		
		JPanel panel_1_1_4 = new JPanel();
		panel_1_1_4.setLayout(null);
		panel_1_1_4.setBackground(new Color(220, 220, 220));
		panel_1_1_4.setBounds(10, 360, 660, 60);
		panel.add(panel_1_1_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("Date de naissance ");
		lblNewLabel_1_4.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(45, 10, 157, 40);
		panel_1_1_4.add(lblNewLabel_1_4);
		
		textDat_Nais = new JTextField();
		textDat_Nais.setColumns(10);
		textDat_Nais.setBounds(252, 13, 352, 40);
		panel_1_1_4.add(textDat_Nais);
		
		JPanel panel_1_1_5 = new JPanel();
		panel_1_1_5.setLayout(null);
		panel_1_1_5.setBackground(new Color(220, 220, 220));
		panel_1_1_5.setBounds(10, 430, 660, 164);
		panel.add(panel_1_1_5);
		
		JLabel lblNewLabel_1_5 = new JLabel("Adresse :");
		lblNewLabel_1_5.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(45, 10, 88, 40);
		panel_1_1_5.add(lblNewLabel_1_5);
		
		txt_Ville = new JTextField();
		txt_Ville.setColumns(10);
		txt_Ville.setBounds(491, 60, 110, 37);
		panel_1_1_5.add(txt_Ville);
		
		txt_Governorat = new JTextField();
		txt_Governorat.setColumns(10);
		txt_Governorat.setBounds(491, 107, 110, 37);
		panel_1_1_5.add(txt_Governorat);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Numero Rue");
		lblNewLabel_1_5_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_5_1.setBounds(143, 10, 104, 40);
		panel_1_1_5.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_1_1 = new JLabel("Libelle");
		lblNewLabel_1_5_1_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_5_1_1.setBounds(144, 56, 63, 40);
		panel_1_1_5.add(lblNewLabel_1_5_1_1);
		
		txt_Rue = new JTextField();
		txt_Rue.setColumns(10);
		txt_Rue.setBounds(252, 14, 110, 37);
		panel_1_1_5.add(txt_Rue);
		
		JLabel lblNewLabel_1_5_1_1_1 = new JLabel("Ville");
		lblNewLabel_1_5_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_5_1_1_1.setBounds(379, 60, 63, 40);
		panel_1_1_5.add(lblNewLabel_1_5_1_1_1);
		
		JLabel lblNewLabel_1_5_1_1_2 = new JLabel("Code Postale");
		lblNewLabel_1_5_1_1_2.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_5_1_1_2.setBounds(132, 103, 110, 40);
		panel_1_1_5.add(lblNewLabel_1_5_1_1_2);
		
		JLabel lblNewLabel_1_5_1_1_3 = new JLabel("Gouvernorat");
		lblNewLabel_1_5_1_1_3.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_5_1_1_3.setBounds(379, 104, 102, 40);
		panel_1_1_5.add(lblNewLabel_1_5_1_1_3);
		
		txt_Libelle = new JTextField();
		txt_Libelle.setColumns(10);
		txt_Libelle.setBounds(252, 60, 110, 37);
		panel_1_1_5.add(txt_Libelle);
		
		txt_Postale = new JTextField();
		txt_Postale.setColumns(10);
		txt_Postale.setBounds(252, 107, 110, 37);
		panel_1_1_5.add(txt_Postale);
		
		JPanel panel_1_1_7 = new JPanel();
		panel_1_1_7.setLayout(null);
		panel_1_1_7.setBackground(new Color(220, 220, 220));
		panel_1_1_7.setBounds(350, 80, 320, 60);
		panel.add(panel_1_1_7);
		
		JLabel lblPr_Eleve = new JLabel("Prenom ");
		lblPr_Eleve.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblPr_Eleve.setBounds(32, 10, 67, 40);
		panel_1_1_7.add(lblPr_Eleve);
		
		textPrenom = new JTextField();
		textPrenom.setColumns(10);
		textPrenom.setBounds(177, 10, 133, 40);
		panel_1_1_7.add(textPrenom);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(220, 220, 220));
		panel_1_1_1.setBounds(10, 150, 320, 60);
		panel.add(panel_1_1_1);
		
		JLabel lblPrenomPere = new JLabel("Prenom Pere");
		lblPrenomPere.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblPrenomPere.setBounds(41, 10, 121, 40);
		panel_1_1_1.add(lblPrenomPere);
		
		textPr_Pere = new JTextField();
		textPr_Pere.setColumns(10);
		textPr_Pere.setBounds(172, 13, 133, 40);
		panel_1_1_1.add(textPr_Pere);
		
		JPanel panel_1_1_8 = new JPanel();
		panel_1_1_8.setLayout(null);
		panel_1_1_8.setBackground(new Color(220, 220, 220));
		panel_1_1_8.setBounds(350, 150, 320, 60);
		panel.add(panel_1_1_8);
		
		textPr_Gr_Pere = new JTextField();
		textPr_Gr_Pere.setColumns(10);
		textPr_Gr_Pere.setBounds(177, 10, 133, 40);
		panel_1_1_8.add(textPr_Gr_Pere);
		
		JLabel lblPrenomGrandPere = new JLabel("Pr Grand Pere");
		lblPrenomGrandPere.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblPrenomGrandPere.setBounds(34, 10, 121, 40);
		panel_1_1_8.add(lblPrenomGrandPere);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBackground(new Color(220, 220, 220));
		panel_1_1_1_1.setBounds(10, 220, 320, 60);
		panel.add(panel_1_1_1_1);
		
		JLabel lblNomMere = new JLabel("Nom Mere");
		lblNomMere.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNomMere.setBounds(41, 10, 121, 40);
		panel_1_1_1_1.add(lblNomMere);
		
		textNom_Mere = new JTextField();
		textNom_Mere.setColumns(10);
		textNom_Mere.setBounds(172, 13, 133, 40);
		panel_1_1_1_1.add(textNom_Mere);
		
		JPanel panel_1_1_1_2 = new JPanel();
		panel_1_1_1_2.setLayout(null);
		panel_1_1_1_2.setBackground(new Color(220, 220, 220));
		panel_1_1_1_2.setBounds(350, 220, 320, 60);
		panel.add(panel_1_1_1_2);
		
		JLabel lblPrenomMere = new JLabel("Prenom Mere");
		lblPrenomMere.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblPrenomMere.setBounds(41, 10, 121, 40);
		panel_1_1_1_2.add(lblPrenomMere);
		
		textPr_Mere = new JTextField();
		textPr_Mere.setColumns(10);
		textPr_Mere.setBounds(172, 13, 133, 40);
		panel_1_1_1_2.add(textPr_Mere);
		
		JPanel panel_1_1_1_3 = new JPanel();
		panel_1_1_1_3.setLayout(null);
		panel_1_1_1_3.setBackground(new Color(220, 220, 220));
		panel_1_1_1_3.setBounds(10, 604, 320, 60);
		panel.add(panel_1_1_1_3);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblImage.setBounds(41, 10, 121, 40);
		panel_1_1_1_3.add(lblImage);
		
		textImage = new JTextField();
		textImage.setColumns(10);
		textImage.setBounds(172, 13, 133, 40);
		panel_1_1_1_3.add(textImage);
		
		JPanel panel_1_1_1_4 = new JPanel();
		panel_1_1_1_4.setLayout(null);
		panel_1_1_1_4.setBackground(new Color(220, 220, 220));
		panel_1_1_1_4.setBounds(350, 604, 320, 60);
		panel.add(panel_1_1_1_4);
		
		JLabel lblNiveauScolaire = new JLabel("Niveau Scolaire");
		lblNiveauScolaire.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNiveauScolaire.setBounds(29, 10, 133, 40);
		panel_1_1_1_4.add(lblNiveauScolaire);
		
		textFNiveauScolaire = new JTextField();
		textFNiveauScolaire.setColumns(10);
		textFNiveauScolaire.setBounds(172, 13, 133, 40);
		panel_1_1_1_4.add(textFNiveauScolaire);
		frAddEleve.setBounds(100, 100, 837, 898);
		frAddEleve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		/************************************************* Valider *************************************************/
		
		
		
		
		JButton btnValider = new JButton("Valider");
		btnValider.setForeground(new Color(245, 245, 245));
		btnValider.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnValider.setBackground(new Color(0, 128, 0));
		btnValider.setBounds(194, 712, 115, 27);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textCin.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "CIN Pere Eleve is empty !!!" );
				}
				else if (!(textCin.getText().matches("[0-9]{8}"))) 
				{
					JOptionPane.showMessageDialog(null, "CIN Pere Eleve false !!!" );
				}
				else if(textNom.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Nom Eleve is empty !!!" );
				}
				else if(textPrenom.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Prenom Eleve is empty !!!" );
				}
				else if(textPr_Pere.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Prenom Pere Eleve is empty !!!" );
				}
				else if(textPr_Gr_Pere.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Prenom Grand Pere Eleve is empty !!!" );
				}
				else if(textNom_Mere.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Nom Mere ELeve is empty !!!" );
				}
				
				else if(textPr_Mere.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Prenom Mere Eleve is empty !!!" );
				}
				else if(txt_Rue.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Rue adresse is empty !!!" );
				}
				else if(txt_Libelle.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Libelle adresse is empty !!!" );
				}
				else if(txt_Ville.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Ville adresse is empty !!!" );
				}
				else if(txt_Postale.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Postale adresse is empty !!!" );
				}
				else if (!(txt_Postale.getText().matches("[0-9]{4}"))) 
				{
					JOptionPane.showMessageDialog(null, "Postale adresse Eleve false !!!" );
				}
				else if(txt_Governorat.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Governorat adresse is empty !!!" );
				}
				else if(textDat_Nais.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Date de Naissance Eleve is empty !!!" );
				}
				else if(!(textDat_Nais.getText().matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")))
				{
					JOptionPane.showMessageDialog(null, "Date de Naissance Eleve false !!!" );
				}
				else if(textNumero.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Telephone Eleve is empty !!!" );
				}
				else if (!(textNumero.getText().matches("[0-9]{8}"))) 
				{
					JOptionPane.showMessageDialog(null, "Telephone Eleve false !!!" );
				}
				else if(textFNiveauScolaire.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Niveau Scolaire Eleve is empty !!!" );
				}
				else if (!(textFNiveauScolaire.getText().matches("[0-9]{1}"))) 
				{
					JOptionPane.showMessageDialog(null, "Niveau Scolaire Eleve false !!!" );
				}
				else if(textImage.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Image Eleve is empty !!!" );
				}else {
					try {
						//instancier un eleve à ajouter dans la base d données:
						Eleve newEleve = new Eleve();
						
						newEleve.setCinEleveString(textCin.getText());
						newEleve.setNom_eleve(textNom.getText());
						newEleve.setPrenom_elve(textPrenom.getText());
						newEleve.setPrpereEleve(textPr_Pere.getText());
						newEleve.setPrgrandEleve(textPr_Gr_Pere.getText());
						newEleve.setNommereEleve(textNom_Mere.getText());
						newEleve.setPrmereEleve(textPr_Mere.getText());
						//newEleve.setAdresseEleve(Adresse.getAdresse(textID_Adresse.getText()));
						
						Date newDate = Date.valueOf(textDat_Nais.getText());
						newEleve.setDateNaiEleve(newDate);
						/*** Adresse ***/
						//instancier un adresse à ajouter dans la base d données:
						Adresse newAdresse = new Adresse();
						int cin = Integer.valueOf(textCin.getText());
						newAdresse.setId_adresse(cin);
						newAdresse.setNum(txt_Rue.getText());
						newAdresse.setDesignation(txt_Libelle.getText());
						newAdresse.setVille(txt_Ville.getText());
						newAdresse.setCodePostalString(txt_Postale.getText());
						newAdresse.setGouvernorat(txt_Governorat.getText());
						/**************/
						newEleve.setAdresseEleve(newAdresse);
						newEleve.setTelEleveString(textNumero.getText());
						newEleve.setNivScolaireString(textFNiveauScolaire.getText());
						newEleve.setImageProfile(textImage.getText());
						//instancier le controleur:
						Adressecontroller ad = new Adressecontroller();
						if(ad.addAdresse(newAdresse))
						{
							EleveController ec = new EleveController();
							if (ec.addEleve(newEleve)) {
	
								JOptionPane.showMessageDialog(null, "Eleve ajouté "
										+ " avec succès.");
							}
						}
						
					}  catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Eleve non ajouté"
								+ "  suite à cette erreur : \n"+ e1.getMessage());	
					}
				}
				
				frAddEleve.setVisible(false);
			}
		});
		panel.add(btnValider);
		
		
		/************************************************* Annuler *************************************************/
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(new Color(245, 245, 245));
		btnAnnuler.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnAnnuler.setBackground(Color.RED);
		btnAnnuler.setBounds(382, 712, 115, 27);
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frAddEleve.setVisible(false);
				
			}
		});
		panel.add(btnAnnuler);
		
		
	}
}
