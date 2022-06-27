package fr.salledesport;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MenuPrincipale extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipale frame = new MenuPrincipale();
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
	public MenuPrincipale() {
		setTitle("Gestion Salle de Sport");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Pauline MARROT\\Downloads\\gym-icon.png.crdownload"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Pauline MARROT\\Downloads\\weightlifting-g2a62496fe_640.jpg"));
		lblNewLabel.setBounds(0, 10, 798, 339);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("COACH");
		btnNewButton.setForeground(new Color(102, 204, 102));
		btnNewButton.setBackground(new Color(51, 153, 102));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coach coach = new Coach();
				coach.setVisible(true);
			}
		});
		btnNewButton.setBounds(69, 369, 174, 60);
		panel.add(btnNewButton);
		
		JButton btnPaiement = new JButton("PAIEMENT");
		btnPaiement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paiement paiement = new Paiement();
				paiement.setVisible(true);
			}
		});
		btnPaiement.setForeground(new Color(102, 204, 102));
		btnPaiement.setFont(new Font("Verdana", Font.BOLD, 20));
		btnPaiement.setBackground(new Color(51, 153, 102));
		btnPaiement.setBounds(535, 369, 174, 60);
		panel.add(btnPaiement);
		
		JButton btnMembres = new JButton("MEMBRES");
		btnMembres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Membres membre = new Membres();
				membre.setVisible(true);
			}
		});
		btnMembres.setForeground(new Color(102, 204, 102));
		btnMembres.setFont(new Font("Verdana", Font.BOLD, 20));
		btnMembres.setBackground(new Color(51, 153, 102));
		btnMembres.setBounds(303, 369, 174, 60);
		panel.add(btnMembres);
		
		JLabel lblNewLabel_1 = new JLabel("GESTION SALLE DE SPORT");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 455, 798, 51);
		panel.add(lblNewLabel_1);
	}
}
