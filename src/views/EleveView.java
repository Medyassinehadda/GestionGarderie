package views;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EleveView {

	public JFrame frEleveView;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EleveView window = new EleveView();
					window.frEleveView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EleveView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frEleveView = new JFrame();
		frEleveView.getContentPane().setFont(new Font("Dialog", Font.BOLD, 17));
		frEleveView.getContentPane().setBackground(new Color(0, 102, 102));
		frEleveView.getContentPane().setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(204, 204, 204));
		panelMenu.setBounds(208, 0, 304, 578);
		frEleveView.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblGarderie = new JLabel("");
		lblGarderie.setBounds(104, 10, 96, 96);
		panelMenu.add(lblGarderie);
		frEleveView.setBackground(new Color(0, 102, 102));
		
		frEleveView.setBounds(100, 100, 693, 615);
		lblGarderie.setIcon(new ImageIcon("C:\\Users\\lenov\\Downloads\\icons8-child-safe-zone-96.png"));
		
		/**** Ajouter ****/
		JPanel panelAjout = new JPanel();
		panelAjout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					AddEleveView window = new AddEleveView();
					window.frAddEleve.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		panelAjout.setBackground(new Color(220, 220, 220));
		panelAjout.setBounds(0, 134, 304, 63);
		panelMenu.add(panelAjout);
		panelAjout.setLayout(null);
		
		JLabel lblaAjout = new JLabel("Ajouter");
		lblaAjout.setForeground(new Color(0, 128, 128));
		lblaAjout.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblaAjout.setBounds(106, 10, 198, 33);
		panelAjout.add(lblaAjout);
		
		
		/**** Modifier ****/
		JPanel panelModif = new JPanel();
		panelModif.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					EleveListView window = new EleveListView();
					window.frmGestionEleve.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		panelModif.setBackground(new Color(220, 220, 220));
		panelModif.setBounds(0, 200, 304, 63);
		panelMenu.add(panelModif);
		panelModif.setLayout(null);
		
		JLabel lblModif = new JLabel("Modifier");
		lblModif.setBounds(100, 10, 141, 35);
		lblModif.setForeground(new Color(0, 128, 128));
		lblModif.setFont(new Font("Arial Black", Font.BOLD, 20));
		panelModif.add(lblModif);
		
		/**** Spprimer ****/
		JPanel panelLister = new JPanel();
		panelLister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					EleveListView window = new EleveListView();
					window.frmGestionEleve.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}	
			}
		});
		panelLister.setBackground(new Color(220, 220, 220));
		panelLister.setBounds(0, 266, 304, 63);
		panelMenu.add(panelLister);
		panelLister.setLayout(null);
		
		JLabel lblSupp = new JLabel("Supprimer");
		lblSupp.setForeground(new Color(0, 128, 128));
		lblSupp.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblSupp.setBounds(100, 10, 141, 35);
		panelLister.add(lblSupp);
		
		/**** Lister ****/
		JPanel panelClasse = new JPanel();
		panelClasse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					EleveListView window = new EleveListView();
					window.frmGestionEleve.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		panelClasse.setBackground(new Color(220, 220, 220));
		panelClasse.setBounds(0, 332, 304, 63);
		panelMenu.add(panelClasse);
		panelClasse.setLayout(null);
		
		JLabel lblLister = new JLabel("Lister");
		lblLister.setForeground(new Color(0, 128, 128));
		lblLister.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblLister.setBounds(113, 10, 141, 35);
		panelClasse.add(lblLister);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setForeground(new Color(245, 245, 245));
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frEleveView.setVisible(false);
			}
		});
		btnAnnuler.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnAnnuler.setBackground(new Color(255, 0, 0));
		btnAnnuler.setBounds(104, 472, 111, 46);
		panelMenu.add(btnAnnuler);
		frEleveView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
