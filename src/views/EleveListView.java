package views;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.EleveController;
import models.Adresse;
import models.Eleve;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class EleveListView {

	public JFrame frmGestionEleve;
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
					EleveListView window = new EleveListView();
					window.frmGestionEleve.setVisible(true);
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
	public EleveListView() throws ClassNotFoundException, SQLException {
		initialize();
		remplirJTable();
	}
	
	private void remplirJTable() throws SQLException, ClassNotFoundException
	{ 
		model = new DefaultTableModel();
		
		model.addColumn("CIN");
		model.addColumn("Nom");
		model.addColumn("Prénom");
		model.addColumn("Date Naissance");
		model.addColumn("Numero Rue");
		model.addColumn("Libelle Adresse");
		model.addColumn("Ville");
		model.addColumn("Code Postal");
		model.addColumn("Gouvernorat");
		model.addColumn("Image");
		model.addColumn("Niveau Scolaire");
		model.addColumn("Téléphone");
		model.addColumn("Prénom Pere");
		model.addColumn("Prénom Grand Pere");
		model.addColumn("Nom Mere");
		model.addColumn("Prénom Mere");
		
	        EleveController C = new EleveController();
	        ArrayList<Eleve> liste = C.listerEleve();
	        for (int i=0;i<liste.size();i++)
	        {
	        Eleve currentEleve = liste.get(i);
	        Adresse currentAdresse = Adresse.getAdresse(currentEleve.getCinpere());
	        model.addRow(new Object[]{
	        		currentEleve.getCinpere(),
	        		currentEleve.getNom_eleve(),
	        		currentEleve.getPrenom_elve(),
	        		currentEleve.getDateNaiEleve().toString(),
	        		currentAdresse.getNum(),
	    	        currentAdresse.getDesignation(),
	    	        currentAdresse.getVille(),
	    	        currentAdresse.getCodePostal(),
	    	        currentAdresse.getGouvernorat(),
	        		currentEleve.getImageProfile(),
	        		currentEleve.getNvscolaire(),
	        		currentEleve.getNumtel(),
	        		currentEleve.getPrpereEleve(),
	        		currentEleve.getPrgrandEleve(),
	        		currentEleve.getNommereEleve(),
	        		currentEleve.getPrmereEleve()});
	        }
	        table.setModel(model);
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionEleve = new JFrame();
		frmGestionEleve.getContentPane().setBackground(new Color(0, 102, 102));
		frmGestionEleve.setBounds(100, 100, 1332, 641);
		frmGestionEleve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionEleve.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(411, 41, 436, 37);
		frmGestionEleve.getContentPane().add(panel);
		
		
		/************************************************* Add *************************************************/
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(50, 5, 100, 27);
		btnNewButton.setBackground(new Color(220,220,220));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddEleveView window = new AddEleveView();
					window.frAddEleve.setVisible(true);
				}catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		
		/************************************************* Update *************************************************/
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBounds(160, 5, 100, 27);
		btnNewButton_1.setBackground(new Color(220,220,220));
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedCIN == 0)
				{
					JOptionPane.showMessageDialog(null,
							"Veuillez selectionner le CIN d'un animateur !!");
				}
				else
				{
					try {
						Eleve el = new Eleve();
						System.out.println("hedha el cin : "+selectedCIN);
						el = Eleve.getEleve(selectedCIN);
						
						UpdateEleveView.setCin(selectedCIN);
						UpdateEleveView window = new UpdateEleveView();
						
						
						window.frUpdateEleve.setVisible(true);
					}catch (Exception ee) {
						JOptionPane.showMessageDialog(null, ee.getMessage());
						System.out.println("cin is null");
					}
				}
			}
		});
		panel.add(btnNewButton_1);
		
		
		/************************************************* Delete *************************************************/
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(270, 5, 100, 27);
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_2.setBackground(new Color(220,220,220));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//on recupere le cin de l'eleve à supprimer:
				if(selectedCIN == 0)
				{
					JOptionPane.showMessageDialog(null,
							"Veuillez selectionner une ligne !!");
				}
				else
				{
					
					try {
						EleveController ac = new EleveController();
						if(ac.deleteEleve(selectedCIN))
						{
							JOptionPane.showMessageDialog(null,
									"Eleve supprimé avec succès");
						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,
								e1.getMessage());
					}
				}
			}
		});
		panel.add(btnNewButton_2);
		
		
		/**********************************************************************************************************/
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		panel_1.setBounds(34, 131, 1249, 385);
		frmGestionEleve.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1229, 365);
		panel_1.add(scrollPane);
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedCIN = (int)table.getValueAt(table.getSelectedRow(),
						table.getSelectedColumn());
			}
		});
		
		scrollPane.setViewportView(table);
		
		/************************************************* Annuler *************************************************/
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGestionEleve.setVisible(false);
			}
		});
		btnAnnuler.setForeground(new Color(245, 245, 245));
		btnAnnuler.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnAnnuler.setBackground(Color.RED);
		btnAnnuler.setBounds(609, 549, 115, 27);
		frmGestionEleve.getContentPane().add(btnAnnuler);
		
		
		
	}

}
