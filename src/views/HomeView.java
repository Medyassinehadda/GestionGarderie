package views;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

import models.MyConnection;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class HomeView {

	public JFrame frmHomeView;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView window = new HomeView();
					window.frmHomeView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}

	public static MyConnection myConnection = null;
	
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public HomeView() throws ClassNotFoundException, SQLException {
		myConnection = new MyConnection();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHomeView = new JFrame();
		frmHomeView.getContentPane().setFont(new Font("Dialog", Font.BOLD, 17));
		frmHomeView.getContentPane().setBackground(new Color(0, 102, 102));
		frmHomeView.getContentPane().setLayout(null);
		frmHomeView.setResizable(false);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(204, 204, 204));
		panelMenu.setBounds(0, 0, 304, 578);
		frmHomeView.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblGarderie = new JLabel("");
		lblGarderie.setBounds(104, 5, 96, 96);
		panelMenu.add(lblGarderie);
		frmHomeView.setBackground(new Color(0, 102, 102));
		
		frmHomeView.setBounds(100, 100, 693, 615);
		lblGarderie.setIcon(new ImageIcon(HomeView.class.getResource("/views/icons.png")));
		
		/**** Animateur ****/
		JPanel panelAnimateur = new JPanel();
		panelAnimateur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					AnimateurView window = new AnimateurView();
					window.frAnimView.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		panelAnimateur.setBackground(new Color(220, 220, 220));
		panelAnimateur.setBounds(0, 134, 304, 63);
		panelMenu.add(panelAnimateur);
		panelAnimateur.setLayout(null);
		
		JLabel lblaAnim = new JLabel("ANIMATEURS");
		lblaAnim.setForeground(new Color(0, 128, 128));
		lblaAnim.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblaAnim.setBounds(77, 20, 198, 20);
		panelAnimateur.add(lblaAnim);
		
		
		/**** Eleves ****/
		JPanel panelEleve = new JPanel();
		panelEleve.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					EleveView window = new EleveView();
					window.frEleveView.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		panelEleve.setBackground(new Color(220, 220, 220));
		panelEleve.setBounds(0, 200, 304, 63);
		panelMenu.add(panelEleve);
		panelEleve.setLayout(null);
		
		JLabel lblEleve = new JLabel("ELEVES");
		lblEleve.setBounds(100, 10, 141, 35);
		lblEleve.setForeground(new Color(0, 128, 128));
		lblEleve.setFont(new Font("Arial Black", Font.BOLD, 20));
		panelEleve.add(lblEleve);
		
		/**** Cours ****/
		JPanel panelCours = new JPanel();
		panelCours.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					CoursView window = new CoursView();
					window.frCoursView.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		panelCours.setBackground(new Color(220, 220, 220));
		panelCours.setBounds(0, 266, 304, 63);
		panelMenu.add(panelCours);
		panelCours.setLayout(null);
		
		JLabel lblCours = new JLabel("COURS");
		lblCours.setForeground(new Color(0, 128, 128));
		lblCours.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblCours.setBounds(100, 10, 141, 35);
		panelCours.add(lblCours);
		
		/**** Classe ****/
		JPanel panelClasse = new JPanel();
		panelClasse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panelClasse.setBackground(new Color(220, 220, 220));
		panelClasse.setBounds(0, 332, 304, 63);
		panelMenu.add(panelClasse);
		panelClasse.setLayout(null);
		
		JLabel lblClasse = new JLabel("CLASSES");
		lblClasse.setForeground(new Color(0, 128, 128));
		lblClasse.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblClasse.setBounds(95, 10, 141, 35);
		panelClasse.add(lblClasse);
		
		/**** Payement ****/
		JPanel panelPeyement = new JPanel();
		panelPeyement.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panelPeyement.setBackground(new Color(220, 220, 220));
		panelPeyement.setBounds(0, 398, 304, 63);
		panelMenu.add(panelPeyement);
		panelPeyement.setLayout(null);
		
		JLabel lblPayement = new JLabel("PAIEMENT");
		lblPayement.setForeground(new Color(0, 128, 128));
		lblPayement.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblPayement.setBounds(80, 10, 141, 35);
		panelPeyement.add(lblPayement);
		
		JLabel lblNewLabel = new JLabel("Gestion Garderie");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(344, 219, 325, 111);
		frmHomeView.getContentPane().add(lblNewLabel);
		frmHomeView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
