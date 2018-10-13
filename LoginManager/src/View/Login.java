package View;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.FileManagement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FileManagement fm;
	private String pass;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/Image/icon.png")));
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));

		JButton btnLogin = new JButton("Iniciar sesión");
		btnLogin.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		
		passwordField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(141)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLogin, Alignment.TRAILING)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(198)
							.addComponent(lblLogin)))
					.addContainerGap(140, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblLogin)
					.addGap(55)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLogin)
					.addContainerGap(111, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

		/* Actions */

		fm = new FileManagement();
		fm.readLogin();
		this.pass = fm.getLoginPass();

		/* Buttons */

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stubs
				if (correct(passwordField.getPassword())) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								View frame = new View(fm);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "La contraseña no coincide", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
	}

	private boolean correct(char[] pass) {
		return (String.valueOf(pass).equals(this.pass));
	}
}