package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import models.MyConnection;

import javax.swing.JMenu;
import java.sql.SQLException;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class HomeViewTest {

	private JFrame frame;
	
	private JMenuItem mntmModifierAnim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeViewTest window = new HomeViewTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}

	public static MyConnection myConnection = null;
	/**
	 * Create the application.
	 */
	public HomeViewTest() throws ClassNotFoundException, SQLException {
		myConnection = new MyConnection();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBackground(new Color(0, 128, 128));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setTitle("Application - Gestion Garderie");
		frame.setBounds(100, 100, 501, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(112, 128, 144));
		frame.setJMenuBar(menuBar);
		
		
		/************************************************* Animateurs *************************************************/
		
		JMenu mnAnimateur = new JMenu("Animateurs");
		menuBar.add(mnAnimateur);
		
		/*** Ajouter animateur ***/
		
		JMenuItem mntmAjouterAnim = new JMenuItem("Ajouter");
		mntmAjouterAnim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddAnimateurView window = new AddAnimateurView();
					window.frmAddupdateAnimateur.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		
		mnAnimateur.add(mntmAjouterAnim);
		
		
		/*** Modifier animateur ***/
		mntmModifierAnim = new JMenuItem("Modifier");
		mntmModifierAnim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UpdateAnimateurView window = new UpdateAnimateurView();
					window.frmUpdateAnimateur.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		
		mnAnimateur.add(mntmModifierAnim);
		
		
		/*** Supprimer animateur ***/
		
		JMenuItem mntmSupprimerAnim = new JMenuItem("Supprimer");
		mntmSupprimerAnim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AnimateurListView window = new AnimateurListView();
					window.frmGestionAnimateurs.setVisible(true);
					
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		mnAnimateur.add(mntmSupprimerAnim);
		
		
		/*** Lister animateur ***/
		
		JMenuItem mntmListerAnim = new JMenuItem("Lister");
		mntmListerAnim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AnimateurListView window = new AnimateurListView();
					window.frmGestionAnimateurs.setVisible(true);
					
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		
	
		mnAnimateur.add(mntmListerAnim);
		
		
		
		/************************************************* Eleves *************************************************/
		
		JMenu mnEleve = new JMenu("Eleves");
		menuBar.add(mnEleve);
		
		/*** Ajouter Eleves ***/
		
		JMenuItem mntmAjouterEleves = new JMenuItem("Ajouter");
		mntmAjouterEleves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddEleveView window = new AddEleveView();
					window.frAddEleve.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		mnEleve.add(mntmAjouterEleves);
		
		/*** Modifier Eleves ***/
		
		JMenuItem mntmModifierEleves = new JMenuItem("Modifier");
		mntmModifierEleves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UpdateEleveView window = new UpdateEleveView();
					window.frUpdateEleve.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		mnEleve.add(mntmModifierEleves);
		
		/*** Supprimer Eleves ***/
		
		JMenuItem mntmSupprimerEleves = new JMenuItem("Supprimer");
		mntmSupprimerEleves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EleveListView window = new EleveListView();
					window.frmGestionEleve.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}		
			}
		});
		mnEleve.add(mntmSupprimerEleves);
		
		/*** Lister Eleves ***/
		
		JMenuItem mntmListerEleve = new JMenuItem("Lister");
		mntmListerEleve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EleveListView window = new EleveListView();
					window.frmGestionEleve.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		mnEleve.add(mntmListerEleve);
		
		
		
		/************************************************* Classes *************************************************/
		
		JMenu mnClasse = new JMenu("Classes");
		menuBar.add(mnClasse);
		
		/*** Ajouter Classe ***/
		
		JMenuItem mntmAjouterClasse = new JMenuItem("Ajouter");
		mntmAjouterClasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnClasse.add(mntmAjouterClasse);
		
		JMenuItem mntmModifierClasses = new JMenuItem("Modifier");
		mntmModifierClasses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnClasse.add(mntmModifierClasses);
		
		JMenuItem mntmSupprimerClasses = new JMenuItem("Supprimer");
		mnClasse.add(mntmSupprimerClasses);
		
		JMenuItem mntmListerClasses = new JMenuItem("Lister");
		mnClasse.add(mntmListerClasses);
		
		
		
		/************************************************* Cours *************************************************/
		
		JMenu mnCours = new JMenu("Cours");
		menuBar.add(mnCours);
		
		/*** Ajouter Cours ***/
		
		JMenuItem mntmAjouterCours = new JMenuItem("Ajouter");
		mntmAjouterCours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddCoursView window = new AddCoursView();
					window.frAddCours.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		mnCours.add(mntmAjouterCours);
		
		/*** Modifier Cours ***/
		
		JMenuItem mntmModifierCours = new JMenuItem("Modifier");
		mntmModifierCours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UpdateCoursView window = new UpdateCoursView();
					window.frUpdateCours.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		
		mnCours.add(mntmModifierCours);
		
		/*** Supprimer Cours ***/
		
		JMenuItem mntmSupprimerCours = new JMenuItem("Supprimer");
		mntmSupprimerCours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ListCoursView window = new ListCoursView();
					window.frmGestionCours.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		mnCours.add(mntmSupprimerCours);
		
		/*** Lister Cours ***/
		
		JMenuItem mntmListerCours = new JMenuItem("Lister");
		mntmListerCours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ListCoursView window = new ListCoursView();
					window.frmGestionCours.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		mnCours.add(mntmListerCours);
		
		
		
		/************************************************* Payement *************************************************/
		
		JMenu mnPayement = new JMenu("Payement");
		menuBar.add(mnPayement);
	}

}
