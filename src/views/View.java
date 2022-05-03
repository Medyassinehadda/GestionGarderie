package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class View {

	private JFrame frame;
	private JTextField txt_cin;
	private JTextField txt_nom;
	private JTextField txt_prenom;
	private JTextField txt_pere;
	private JTextField txt_telephone;
	private JTextField txt_datenaissance;
	private JTextField txt_image;
	private JTextField txt_Ville;
	private JTextField txt_Governorat;
	private JTextField txt_Rue;
	private JTextField txt_Adresse;
	private JTextField txt_Libelle;
	private JTextField txt_Postale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(0, 102, 102));
		frame.getContentPane().setBackground(new Color(0, 102, 102));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(50, 10, 680, 812);
		frame.getContentPane().add(panel);
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
		
		txt_cin = new JTextField();
		txt_cin.setBounds(252, 13, 349, 40);
		panel_1.add(txt_cin);
		txt_cin.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(220, 220, 220));
		panel_1_1.setBounds(10, 80, 660, 60);
		panel.add(panel_1_1);
		
		JLabel lblNomAnimateur = new JLabel("Nom");
		lblNomAnimateur.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNomAnimateur.setBounds(45, 10, 54, 40);
		panel_1_1.add(lblNomAnimateur);
		
		txt_nom = new JTextField();
		txt_nom.setColumns(10);
		txt_nom.setBounds(252, 13, 349, 40);
		panel_1_1.add(txt_nom);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(220, 220, 220));
		panel_1_1_1.setBounds(10, 150, 660, 60);
		panel.add(panel_1_1_1);
		
		JLabel lblPr_Anim = new JLabel("Prenom ");
		lblPr_Anim.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblPr_Anim.setBounds(45, 10, 78, 40);
		panel_1_1_1.add(lblPr_Anim);
		
		txt_prenom = new JTextField();
		txt_prenom.setColumns(10);
		txt_prenom.setBounds(252, 13, 349, 40);
		panel_1_1_1.add(txt_prenom);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBackground(new Color(220, 220, 220));
		panel_1_1_2.setBounds(10, 220, 660, 60);
		panel.add(panel_1_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Prenom Pere");
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(45, 10, 120, 40);
		panel_1_1_2.add(lblNewLabel_1_2);
		
		txt_pere = new JTextField();
		txt_pere.setColumns(10);
		txt_pere.setBounds(252, 13, 349, 40);
		panel_1_1_2.add(txt_pere);
		
		JPanel panel_1_1_3 = new JPanel();
		panel_1_1_3.setLayout(null);
		panel_1_1_3.setBackground(new Color(220, 220, 220));
		panel_1_1_3.setBounds(10, 290, 660, 60);
		panel.add(panel_1_1_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Telephone ");
		lblNewLabel_1_3.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(45, 10, 96, 40);
		panel_1_1_3.add(lblNewLabel_1_3);
		
		txt_telephone = new JTextField();
		txt_telephone.setColumns(10);
		txt_telephone.setBounds(252, 13, 349, 40);
		panel_1_1_3.add(txt_telephone);
		
		JPanel panel_1_1_4 = new JPanel();
		panel_1_1_4.setLayout(null);
		panel_1_1_4.setBackground(new Color(220, 220, 220));
		panel_1_1_4.setBounds(10, 360, 660, 60);
		panel.add(panel_1_1_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("Date de naissance ");
		lblNewLabel_1_4.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(45, 10, 157, 40);
		panel_1_1_4.add(lblNewLabel_1_4);
		
		txt_datenaissance = new JTextField();
		txt_datenaissance.setColumns(10);
		txt_datenaissance.setBounds(252, 13, 352, 40);
		panel_1_1_4.add(txt_datenaissance);
		
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
		lblNewLabel_1_5_1.setBounds(379, 10, 104, 40);
		panel_1_1_5.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_1_1 = new JLabel("Libelle");
		lblNewLabel_1_5_1_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_5_1_1.setBounds(144, 56, 63, 40);
		panel_1_1_5.add(lblNewLabel_1_5_1_1);
		
		JLabel lblNewLabel_1_5_1_2 = new JLabel("ID Adresse");
		lblNewLabel_1_5_1_2.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_5_1_2.setBounds(134, 10, 90, 40);
		panel_1_1_5.add(lblNewLabel_1_5_1_2);
		
		txt_Rue = new JTextField();
		txt_Rue.setColumns(10);
		txt_Rue.setBounds(491, 13, 110, 37);
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
		
		txt_Adresse = new JTextField();
		txt_Adresse.setColumns(10);
		txt_Adresse.setBounds(252, 13, 110, 37);
		panel_1_1_5.add(txt_Adresse);
		
		txt_Libelle = new JTextField();
		txt_Libelle.setColumns(10);
		txt_Libelle.setBounds(252, 60, 110, 37);
		panel_1_1_5.add(txt_Libelle);
		
		txt_Postale = new JTextField();
		txt_Postale.setColumns(10);
		txt_Postale.setBounds(252, 107, 110, 37);
		panel_1_1_5.add(txt_Postale);
		
		JPanel panel_1_1_6 = new JPanel();
		panel_1_1_6.setLayout(null);
		panel_1_1_6.setBackground(new Color(220, 220, 220));
		panel_1_1_6.setBounds(10, 604, 660, 60);
		panel.add(panel_1_1_6);
		
		JLabel lblNewLabel_1_6 = new JLabel("Image");
		lblNewLabel_1_6.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_1_6.setBounds(45, 10, 146, 40);
		panel_1_1_6.add(lblNewLabel_1_6);
		
		txt_image = new JTextField();
		txt_image.setColumns(10);
		txt_image.setBounds(252, 13, 349, 40);
		panel_1_1_6.add(txt_image);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setForeground(new Color(245, 245, 245));
		btnValider.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnValider.setBackground(new Color(0, 128, 0));
		btnValider.setBounds(172, 738, 115, 27);
		panel.add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(new Color(245, 245, 245));
		btnAnnuler.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnAnnuler.setBackground(Color.RED);
		btnAnnuler.setBounds(381, 738, 115, 27);
		panel.add(btnAnnuler);
		frame.setBounds(100, 100, 837, 898);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
