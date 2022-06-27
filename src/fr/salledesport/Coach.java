package fr.salledesport;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Coach extends JFrame {
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	DefaultTableModel df;

	private JPanel contentPane;
	private JTable table;
	private JTextField textNom;
	private JTextField textTel;
	private JTextField textAdresse;
	private JTextField textDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coach frame = new Coach();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Coach() {
	
		setTitle("Gestion Salle de Sport - Partie Coach");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Pauline MARROT\\Downloads\\gym-icon.png.crdownload"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 823, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTION COACH");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(5, 5, 799, 50);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 27));
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(5, 322, 799, 188);
		table.setSurrendersFocusOnKeystroke(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"REF", "NOM PRENOM", "TEL", "ADRESSE", "DATE NAISSANCE", "SEXE"},
			},
			new String[] {
				"REF", "NOM PRENOM", "TEL", "ADRESSE", "DATE DE NAISSANCE", "SEXE"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(97);
		table.setBorder(new EmptyBorder(2, 2, 2, 2));
		contentPane.add(table);
		
		JTextPane txtpnNomEtPrnom = new JTextPane();
		txtpnNomEtPrnom.setBackground(SystemColor.menu);
		txtpnNomEtPrnom.setFont(new Font("Verdana", Font.ITALIC, 19));
		txtpnNomEtPrnom.setText("Nom et Prénom");
		txtpnNomEtPrnom.setBounds(74, 81, 167, 30);
		contentPane.add(txtpnNomEtPrnom);
		
		JTextPane txtpnNumro = new JTextPane();
		txtpnNumro.setText("Date Naissance");
		txtpnNumro.setFont(new Font("Verdana", Font.ITALIC, 19));
		txtpnNumro.setBackground(SystemColor.menu);
		txtpnNumro.setBounds(364, 161, 156, 30);
		contentPane.add(txtpnNumro);
		
		JTextPane txtpnTlphone = new JTextPane();
		txtpnTlphone.setText("Téléphone");
		txtpnTlphone.setFont(new Font("Verdana", Font.ITALIC, 19));
		txtpnTlphone.setBackground(SystemColor.menu);
		txtpnTlphone.setBounds(74, 161, 116, 30);
		contentPane.add(txtpnTlphone);
		
		JTextPane txtpnNumro_1 = new JTextPane();
		txtpnNumro_1.setText("Adresse");
		txtpnNumro_1.setFont(new Font("Verdana", Font.ITALIC, 19));
		txtpnNumro_1.setBackground(SystemColor.menu);
		txtpnNumro_1.setBounds(395, 81, 116, 30);
		contentPane.add(txtpnNumro_1);
		
		JTextPane txtpnSexe = new JTextPane();
		txtpnSexe.setText("Sexe");
		txtpnSexe.setFont(new Font("Verdana", Font.ITALIC, 19));
		txtpnSexe.setBackground(SystemColor.menu);
		txtpnSexe.setBounds(25, 266, 69, 30);
		contentPane.add(txtpnSexe);
		
		textNom = new JTextField();
		textNom.setHorizontalAlignment(SwingConstants.CENTER);
		textNom.setFont(new Font("Verdana", Font.PLAIN, 14));
		textNom.setColumns(10);
		textNom.setBounds(25, 121, 242, 30);
		contentPane.add(textNom);
		
		textTel = new JTextField();
		textTel.setHorizontalAlignment(SwingConstants.CENTER);
		textTel.setFont(new Font("Verdana", Font.PLAIN, 14));
		textTel.setColumns(10);
		textTel.setBounds(25, 201, 242, 30);
		contentPane.add(textTel);
		
		textAdresse = new JTextField();
		textAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		textAdresse.setFont(new Font("Verdana", Font.PLAIN, 14));
		textAdresse.setColumns(10);
		textAdresse.setBounds(321, 121, 231, 30);
		contentPane.add(textAdresse);
		
		textDate = new JTextField();
		textDate.setHorizontalAlignment(SwingConstants.CENTER);
		textDate.setFont(new Font("Verdana", Font.PLAIN, 14));
		textDate.setColumns(10);
		textDate.setBounds(321, 201, 231, 30);
		contentPane.add(textDate);
		
		JComboBox<Object> comboBoxSexe = new JComboBox<Object>();
		comboBoxSexe.setFont(new Font("Verdana", Font.PLAIN, 19));
		comboBoxSexe.setModel(new DefaultComboBoxModel<Object>(new String[] {"Femme", "Homme"}));
		comboBoxSexe.setBounds(104, 266, 190, 30);
		contentPane.add(comboBoxSexe);
		
		JButton btnAjouter = new JButton("AJOUTER");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connecter();
					pst = con.prepareStatement("insert into coach(nom, adresse, naissance, telephone, sexe) values (?,?,?,?,?)");
					pst.setString(1,textNom.getText());
					pst.setString(2,textTel.getText());
					pst.setString(3,textAdresse.getText());
					pst.setString(4,textDate.getText());
					pst.setString(5,comboBoxSexe.getSelectedItem().toString());
					pst.executeUpdate();
					con.close(); // fermer la connexion BDD
					JOptionPane.showConfirmDialog(null, "Enregistrement reussi");
				}catch (Exception e1) {	
					e1.printStackTrace();
				}
			}
		});
		btnAjouter.setForeground(new Color(102, 204, 102));
		btnAjouter.setFont(new Font("Verdana", Font.BOLD, 20));
		btnAjouter.setBackground(new Color(51, 153, 102));
		btnAjouter.setBounds(607, 65, 174, 60);
		contentPane.add(btnAjouter);
		
		JButton btnModifier = new JButton("MODIFIER");
		btnModifier.setForeground(new Color(102, 204, 102));
		btnModifier.setFont(new Font("Verdana", Font.BOLD, 20));
		btnModifier.setBackground(new Color(51, 153, 102));
		btnModifier.setBounds(607, 144, 174, 60);
		contentPane.add(btnModifier);
		
		JButton btnAjouter_1_1 = new JButton("SUPRIMIER");
		btnAjouter_1_1.setForeground(new Color(102, 204, 102));
		btnAjouter_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		btnAjouter_1_1.setBackground(new Color(51, 153, 102));
		btnAjouter_1_1.setBounds(607, 222, 174, 60);
		contentPane.add(btnAjouter_1_1);
	}
	
	public void Connecter() {  // BDD 
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:sport.db");
			//JOptionPane.showMessageDialog(null,"Connexion reussie");
		}catch(Exception e ) {
			
			e.printStackTrace();
		}
		
	
	}
}
