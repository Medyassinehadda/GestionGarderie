package views;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

import controllers.AnimateurController;
import models.Adresse;
import models.Animateur;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class AnimateurListView {

	JFrame frmGestionAnimateurs;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();
	private int selectedCIN=0; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimateurListView window = new AnimateurListView();
					window.frmGestionAnimateurs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public AnimateurListView() throws ClassNotFoundException, SQLException {
		initialize();
		remplirJTable();
	}
	
	private void remplirJTable() throws SQLException, ClassNotFoundException
	{ 
		model = new DefaultTableModel();
		model.addColumn("CIN");
		model.addColumn("Nom");
		model.addColumn("Prénom");
		model.addColumn("Téléphone");
		model.addColumn("Père");
		model.addColumn("Date Naissance");
		model.addColumn("Numero Rue");
		model.addColumn("Libelle Adresse");
		model.addColumn("Ville");
		model.addColumn("Code Postal");
		model.addColumn("Gouvernorat");
		model.addColumn("Image");
	        AnimateurController C = new AnimateurController();
	        ArrayList<Animateur> liste = C.listerAnimateur();
	        for (int i=0;i<liste.size();i++)
	        {
	        Animateur currentAnimateur = liste.get(i);
	        Adresse currentAdresse = Adresse.getAdresse(currentAnimateur.getCinAnim());
	        
	        model.addRow(new Object[]{currentAnimateur.getCinAnim(),
	        currentAnimateur.getNomAnim(), currentAnimateur.getPrenomAnim(),
	        currentAnimateur.getTelAnim(),
	        currentAnimateur.getPereAnim(),
	        currentAnimateur.getDateNaisAnim().toString(),
	        currentAdresse.getNum(),
	        currentAdresse.getDesignation(),
	        currentAdresse.getVille(),
	        currentAdresse.getCodePostal(),
	        currentAdresse.getGouvernorat(),
	        currentAnimateur.getImageAnim()});
	        }
	        table.setModel(model);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionAnimateurs = new JFrame();
		frmGestionAnimateurs.getContentPane().setBackground(new Color(0, 102, 102));
		frmGestionAnimateurs.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				try {
					remplirJTable();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());					
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());					
				}
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		frmGestionAnimateurs.setTitle("Gestion animateurs");
		frmGestionAnimateurs.setBounds(100, 100, 1126, 655);
		frmGestionAnimateurs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGestionAnimateurs.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204,204,204));
		panel.setBounds(332, 37, 436, 37);
		frmGestionAnimateurs.getContentPane().add(panel);
		
		
		/************************************************* Add *************************************************/
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(50, 5, 100, 27);
		btnAdd.setBackground(new Color(220,220,220));
		btnAdd.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddAnimateurView window = new AddAnimateurView();
					window.frmAddupdateAnimateur.setVisible(true);
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, ee.getMessage());
				}
			}
		});
		panel.setLayout(null);
		panel.add(btnAdd);
		
		
		
		/************************************************* Update *************************************************/
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(160, 5, 100, 27);
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnUpdate.setBackground(new Color(220,220,220));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedCIN == 0)
				{
					JOptionPane.showMessageDialog(null,
							"Veuillez selectionner le CIN d'un animateur !!");
				}
				else
				{
					try {
						Animateur an = new Animateur();
						System.out.println("hedha el cin : "+selectedCIN);
						an = Animateur.getAnimateur(selectedCIN);
						
						System.out.println("class listview : "+an);
						
						boolean x = UpdateAnimateurView.setCin(selectedCIN);
						UpdateAnimateurView window = new UpdateAnimateurView();

						if (x) {
							System.out.println("cin diff to 0");
						}else {
							System.out.println("cin is null");
						}
						window.frmUpdateAnimateur.setVisible(true);
					} catch (Exception ee) {
						JOptionPane.showMessageDialog(null, ee.getMessage());
						System.out.println("cin is null");
					}
				}
				
			}
		});
		
		panel.add(btnUpdate);
		
		
		/************************************************* Delete *************************************************/
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(270, 5, 100, 27);
		btnDelete.setBackground(new Color(220,220,220));
		btnDelete.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//on recupere le cin de l'animateur à supprimer:
				if(selectedCIN == 0)
				{
					JOptionPane.showMessageDialog(null,
							"Veuillez selectionner le CIN d'un animateur !!");
				}
				else
				{
					
					try {
						AnimateurController ac = new AnimateurController();
						
						if(ac.deleteAnimateur(selectedCIN))
						{
							JOptionPane.showMessageDialog(null,
									"Animateur supprimé avec succès");
						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,
								e1.getMessage());
					}
				}
			}
		});
		panel.add(btnDelete);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204,204,204));
		panel_1.setBounds(34, 131, 1052, 385);
		frmGestionAnimateurs.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1032, 365);
		panel_1.add(scrollPane);
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				selectedCIN = (int)table.getValueAt(table.getSelectedRow(),
						table.getSelectedColumn());
				System.out.println(selectedCIN);
			}
		});
		
		scrollPane.setViewportView(table);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGestionAnimateurs.setVisible(false);
			}
		});
		btnAnnuler.setForeground(new Color(245, 245, 245));
		btnAnnuler.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnAnnuler.setBackground(Color.RED);
		btnAnnuler.setBounds(509, 550, 115, 27);
		frmGestionAnimateurs.getContentPane().add(btnAnnuler);
	}
}
