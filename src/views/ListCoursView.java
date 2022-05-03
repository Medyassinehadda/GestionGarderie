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

import controllers.CoursController;
import models.Animateur;
import models.Cours;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ListCoursView {

	public JFrame frmGestionCours;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();
	private int selectedCode=0; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListCoursView window = new ListCoursView();
					window.frmGestionCours.setVisible(true);
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
	public ListCoursView() throws ClassNotFoundException, SQLException {
		initialize();
		remplirJTable();
	}
	
	private void remplirJTable() throws SQLException, ClassNotFoundException
	{ 
		model = new DefaultTableModel();
		
		model.addColumn("Code");
		model.addColumn("Designation");
		model.addColumn("Animateur responsable");
		
			CoursController C = new CoursController();
	        ArrayList<Cours> liste = C.listerCours();
	        for (int i=0;i<liste.size();i++)
	        {
	        Cours currentCours = liste.get(i);
	        Animateur currentAnimateur = (currentCours.getAnimateurResponsable());
	        model.addRow(new Object[]{
	        		currentCours.getCode(),
	        		currentCours.getDesignation(),
	        		currentAnimateur.getNomAnim()+" "+currentAnimateur.getPrenomAnim()});
	        }
	        table.setModel(model);
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionCours = new JFrame();
		frmGestionCours.getContentPane().setBackground(new Color(0, 128, 128));
		frmGestionCours.setBackground(new Color(0, 128, 128));
		frmGestionCours.setBounds(100, 100, 729, 443);
		frmGestionCours.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionCours.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(151, 10, 436, 37);
		frmGestionCours.getContentPane().add(panel);
		
		
		/************************************************* Add *************************************************/
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(50, 5, 100, 27);
		btnNewButton.setBackground(new Color(220,220,220));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddCoursView window = new AddCoursView();
					window.frAddCours.setVisible(true);
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
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(220,220,220));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//on recupere le code de cours à supprimer:
				if(selectedCode == 0)
				{
					JOptionPane.showMessageDialog(null,
							"Veuillez selectionner une ligne !!");
				}
				else
					{
					try {
						Cours c = new Cours();
						c = Cours.getCours(selectedCode);
						
						UpdateCoursView.setCode(selectedCode);
						UpdateCoursView window = new UpdateCoursView();
						window.frUpdateCours.setVisible(true);
					}catch (Exception ee) {
						ee.printStackTrace();
					}
				}
			}
		});
		panel.add(btnNewButton_1);
		
		
		/************************************************* Delete *************************************************/
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(270, 5, 100, 27);
		btnNewButton_2.setBackground(new Color(220,220,220));
		btnNewButton_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//on recupere le code de cours à supprimer:
				if(selectedCode == 0)
				{
					JOptionPane.showMessageDialog(null,
							"Veuillez selectionner une ligne !!");
				}
				else
				{
					
					try {
						CoursController ac = new CoursController();
						if(ac.deleteCours(selectedCode))
						{
							JOptionPane.showMessageDialog(null,
									"Cours supprimé avec succès");
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
		panel_1.setBounds(151, 104, 436, 226);
		frmGestionCours.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(-8, 5, 452, 402);
		panel_1.add(scrollPane);
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedCode = (int)table.getValueAt(table.getSelectedRow(),
						table.getSelectedColumn());
			}
		});
		
		scrollPane.setViewportView(table);
	
	}

}
