package views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.CoursController;
import models.Animateur;
import models.Cours;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;

public class UpdateCoursView {

	public JFrame frUpdateCours;
	private JTextField textCode;
	private JTextField textDesignation;
	private JTextField textAnim;
	
	public static int selectedCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCoursView window = new UpdateCoursView();
					window.frUpdateCours.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public static boolean setCode(int code) {
		
		if(code == 0) {
			return false;
		}else {
			selectedCode = code;
			return true;
		}
	}

	/**
	 * Create the application.
	 */
	public UpdateCoursView() {
		try {
			Cours coursSelected = Cours.getCours(selectedCode);
			initialize(coursSelected);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Cours coursSelected) {
		frUpdateCours = new JFrame();
		frUpdateCours.setBounds(100, 100, 508, 417);
		frUpdateCours.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		frUpdateCours.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(9, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCode = new JLabel("Code Cours");
		panel_2.add(lblCode);
		
		textCode = new JTextField();
		String codee = Integer.toString(coursSelected.getCode());
		textCode.setText(codee);
		panel_2.add(textCode);
		textCode.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblDesignation = new JLabel("Designation");
		panel_1.add(lblDesignation);
		
		textDesignation = new JTextField();
		textDesignation.setText(coursSelected.getDesignation());
		panel_1.add(textDesignation);
		textDesignation.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Animateur Responsable");
		panel_3.add(lblNewLabel_1);
		
		textAnim = new JTextField();
		String aniim = Integer.toString(coursSelected.getAnimateurResponsable().getCinAnim());
		textAnim.setText(aniim);
		panel_3.add(textAnim);
		textAnim.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		/************************************************* Valider *************************************************/
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnValider.setForeground(new Color(245, 245, 245));
		btnValider.setBackground(new Color(0, 128, 0));
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textCode.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Code Cours is empty !!!" );
				}
				else if (textDesignation.getText().trim().isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "Designation Cours is empty !!!" );
				}
				else if(textAnim.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Animateur responsable Cours is empty !!!" );
				}
				else {
					try {
						//instancier un cours à modifier dans la base d données:
						Cours newCours = new Cours();
						newCours.setCodeString(textCode.getText());
						newCours.setDesignation(textDesignation.getText());
						int int_anim = Integer.valueOf(textAnim.getText());
						newCours.setAnimateurResponsable(Animateur.getAnimateur(int_anim));
						
						//instancier le controleur:
						CoursController cc = new CoursController();
							if(cc.updateCours(newCours))
							{
								JOptionPane.showMessageDialog(null, "Cours modifié "
										+ " avec succès.");
							}
					
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Cours non modifié"
								+ "  suite à cette erreur : \n"+ e1.getMessage());					
					}
	//					catch (ParseException e1) {
	//					JOptionPane.showMessageDialog(null, "Animateur non ajouté"
	//							+ "  suite à cette erreur : \n"+ e1.getMessage());
	//				}
				}
				frUpdateCours.setVisible(false);
				
			}
		});
		panel_4.add(btnValider);
		
		
		/************************************************* Annuler *************************************************/
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnAnnuler.setForeground(new Color(245, 245, 245));
		btnAnnuler.setBackground(new Color(255, 0, 0));
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frUpdateCours.setVisible(false);
				
			}
		});
		panel_4.add(btnAnnuler);
	}

}
