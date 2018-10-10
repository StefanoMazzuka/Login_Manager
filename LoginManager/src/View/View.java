package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Application;
import Controller.FileManagement;
import Controller.User;

import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNewApplication;
	private JTextField textFieldNewUser;
	private JTextField textFieldNewPass;
	private JTextField textFieldNewURL;
	private ArrayList<Application> applications = new ArrayList<Application>();
	private FileManagement fm = new FileManagement();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 396);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("Archivo");
		mnFile.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		menuBar.add(mnFile);

		JMenuItem mntmNew = new JMenuItem("Nuevo");
		mntmNew.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		mnFile.add(mntmNew);

		JMenuItem mntmSearch = new JMenuItem("Buscar");
		mntmSearch.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		mnFile.add(mntmSearch);

		JMenuItem mntmExport = new JMenuItem("Exportar");
		mntmExport.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		mnFile.add(mntmExport);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panelSearch = new JPanel();
		contentPane.add(panelSearch, "panelSearch");
		panelSearch.setLayout(new BorderLayout(0, 0));

		JPanel panelInput = new JPanel();
		panelSearch.add(panelInput, BorderLayout.NORTH);
		GridBagLayout gbl_panelInput = new GridBagLayout();
		gbl_panelInput.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panelInput.rowHeights = new int[]{0, 0, 0};
		gbl_panelInput.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelInput.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelInput.setLayout(gbl_panelInput);

		JLabel lblTitle = new JLabel("LOGIN MANAGER");
		lblTitle.setFont(new Font("Agency FB", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 0;
		panelInput.add(lblTitle, gbc_lblTitle);

		JLabel lblApplication = new JLabel("Aplicaci\u00F3n");
		lblApplication.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		GridBagConstraints gbc_lblApplication = new GridBagConstraints();
		gbc_lblApplication.anchor = GridBagConstraints.EAST;
		gbc_lblApplication.insets = new Insets(0, 0, 0, 5);
		gbc_lblApplication.gridx = 0;
		gbc_lblApplication.gridy = 1;
		panelInput.add(lblApplication, gbc_lblApplication);

		JComboBox comboBoxApplications = new JComboBox();
		GridBagConstraints gbc_comboBoxApplications = new GridBagConstraints();
		gbc_comboBoxApplications.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxApplications.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxApplications.gridx = 1;
		gbc_comboBoxApplications.gridy = 1;
		panelInput.add(comboBoxApplications, gbc_comboBoxApplications);

		JButton btnSearch = new JButton("Buscar");
		btnSearch.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.anchor = GridBagConstraints.WEST;
		gbc_btnSearch.gridx = 2;
		gbc_btnSearch.gridy = 1;
		panelInput.add(btnSearch, gbc_btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		panelSearch.add(scrollPane, BorderLayout.CENTER);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		JPanel panelNew = new JPanel();
		contentPane.add(panelNew, "panelNew");
		GridBagLayout gbl_panelNew = new GridBagLayout();
		gbl_panelNew.columnWidths = new int[]{1, 1, 1, 0};
		gbl_panelNew.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 60, 0, 0, 0};
		gbl_panelNew.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelNew.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panelNew.setLayout(gbl_panelNew);

		JLabel lblTitleNew = new JLabel("NUEVO LOGIN");
		lblTitleNew.setFont(new Font("Agency FB", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTitleNew = new GridBagConstraints();
		gbc_lblTitleNew.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitleNew.gridx = 1;
		gbc_lblTitleNew.gridy = 0;
		panelNew.add(lblTitleNew, gbc_lblTitleNew);

		JLabel lblExistApplication = new JLabel("Aplicaci\u00F3n existente");
		lblExistApplication.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		GridBagConstraints gbc_lblExistApplication = new GridBagConstraints();
		gbc_lblExistApplication.insets = new Insets(0, 0, 5, 5);
		gbc_lblExistApplication.anchor = GridBagConstraints.EAST;
		gbc_lblExistApplication.gridx = 0;
		gbc_lblExistApplication.gridy = 1;
		panelNew.add(lblExistApplication, gbc_lblExistApplication);

		JComboBox comboBoxApplicationsSave = new JComboBox();
		GridBagConstraints gbc_comboBoxApplicationsSave = new GridBagConstraints();
		gbc_comboBoxApplicationsSave.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxApplicationsSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxApplicationsSave.gridx = 1;
		gbc_comboBoxApplicationsSave.gridy = 1;
		panelNew.add(comboBoxApplicationsSave, gbc_comboBoxApplicationsSave);

		JRadioButton rdbtnExistApplication = new JRadioButton("");
		GridBagConstraints gbc_rdbtnExistApplication = new GridBagConstraints();
		gbc_rdbtnExistApplication.anchor = GridBagConstraints.WEST;
		gbc_rdbtnExistApplication.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnExistApplication.gridx = 2;
		gbc_rdbtnExistApplication.gridy = 1;
		panelNew.add(rdbtnExistApplication, gbc_rdbtnExistApplication);

		JLabel lblNoExistApplication = new JLabel("Nueva aplicaci\u00F3n");
		lblNoExistApplication.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNoExistApplication = new GridBagConstraints();
		gbc_lblNoExistApplication.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoExistApplication.anchor = GridBagConstraints.EAST;
		gbc_lblNoExistApplication.gridx = 0;
		gbc_lblNoExistApplication.gridy = 2;
		panelNew.add(lblNoExistApplication, gbc_lblNoExistApplication);

		textFieldNewApplication = new JTextField();
		GridBagConstraints gbc_textFieldNewApplication = new GridBagConstraints();
		gbc_textFieldNewApplication.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNewApplication.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNewApplication.gridx = 1;
		gbc_textFieldNewApplication.gridy = 2;
		panelNew.add(textFieldNewApplication, gbc_textFieldNewApplication);
		textFieldNewApplication.setColumns(10);

		JRadioButton rdbtnNoExistApplication = new JRadioButton("");
		GridBagConstraints gbc_rdbtnNoExistApplication = new GridBagConstraints();
		gbc_rdbtnNoExistApplication.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNoExistApplication.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNoExistApplication.gridx = 2;
		gbc_rdbtnNoExistApplication.gridy = 2;
		panelNew.add(rdbtnNoExistApplication, gbc_rdbtnNoExistApplication);

		JLabel lblNewUser = new JLabel("Usuario");
		lblNewUser.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewUser = new GridBagConstraints();
		gbc_lblNewUser.anchor = GridBagConstraints.EAST;
		gbc_lblNewUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewUser.gridx = 0;
		gbc_lblNewUser.gridy = 3;
		panelNew.add(lblNewUser, gbc_lblNewUser);

		textFieldNewUser = new JTextField();
		GridBagConstraints gbc_textFieldNewUser = new GridBagConstraints();
		gbc_textFieldNewUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNewUser.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNewUser.gridx = 1;
		gbc_textFieldNewUser.gridy = 3;
		panelNew.add(textFieldNewUser, gbc_textFieldNewUser);
		textFieldNewUser.setColumns(10);

		JLabel lblImportant1 = new JLabel("*");
		lblImportant1.setForeground(Color.RED);
		lblImportant1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		GridBagConstraints gbc_lblImportant1 = new GridBagConstraints();
		gbc_lblImportant1.anchor = GridBagConstraints.WEST;
		gbc_lblImportant1.insets = new Insets(0, 0, 5, 0);
		gbc_lblImportant1.gridx = 2;
		gbc_lblImportant1.gridy = 3;
		panelNew.add(lblImportant1, gbc_lblImportant1);

		JLabel lblNewPass = new JLabel("Contrase\u00F1a");
		lblNewPass.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewPass = new GridBagConstraints();
		gbc_lblNewPass.anchor = GridBagConstraints.EAST;
		gbc_lblNewPass.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewPass.gridx = 0;
		gbc_lblNewPass.gridy = 4;
		panelNew.add(lblNewPass, gbc_lblNewPass);

		textFieldNewPass = new JTextField();
		GridBagConstraints gbc_textFieldNewPass = new GridBagConstraints();
		gbc_textFieldNewPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNewPass.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNewPass.gridx = 1;
		gbc_textFieldNewPass.gridy = 4;
		panelNew.add(textFieldNewPass, gbc_textFieldNewPass);
		textFieldNewPass.setColumns(10);

		JLabel lblImportant2 = new JLabel("*");
		lblImportant2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblImportant2.setForeground(Color.RED);
		GridBagConstraints gbc_lblImportant2 = new GridBagConstraints();
		gbc_lblImportant2.anchor = GridBagConstraints.WEST;
		gbc_lblImportant2.insets = new Insets(0, 0, 5, 0);
		gbc_lblImportant2.gridx = 2;
		gbc_lblImportant2.gridy = 4;
		panelNew.add(lblImportant2, gbc_lblImportant2);

		JLabel lblNewUrl = new JLabel("URL");
		lblNewUrl.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewUrl = new GridBagConstraints();
		gbc_lblNewUrl.anchor = GridBagConstraints.EAST;
		gbc_lblNewUrl.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewUrl.gridx = 0;
		gbc_lblNewUrl.gridy = 5;
		panelNew.add(lblNewUrl, gbc_lblNewUrl);

		textFieldNewURL = new JTextField();
		GridBagConstraints gbc_textFieldNewURL = new GridBagConstraints();
		gbc_textFieldNewURL.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNewURL.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNewURL.gridx = 1;
		gbc_textFieldNewURL.gridy = 5;
		panelNew.add(textFieldNewURL, gbc_textFieldNewURL);
		textFieldNewURL.setColumns(10);

		JLabel lblNewExtraInfo = new JLabel("Informaci\u00F3n extra");
		lblNewExtraInfo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewExtraInfo = new GridBagConstraints();
		gbc_lblNewExtraInfo.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewExtraInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewExtraInfo.gridx = 0;
		gbc_lblNewExtraInfo.gridy = 6;
		panelNew.add(lblNewExtraInfo, gbc_lblNewExtraInfo);

		JScrollPane scrollPaneNew = new JScrollPane();
		scrollPaneNew.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPaneNew = new GridBagConstraints();
		gbc_scrollPaneNew.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneNew.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneNew.gridx = 1;
		gbc_scrollPaneNew.gridy = 6;
		panelNew.add(scrollPaneNew, gbc_scrollPaneNew);

		JTextArea textAreaNewExtraInfo = new JTextArea();
		scrollPaneNew.setViewportView(textAreaNewExtraInfo);
		textAreaNewExtraInfo.setWrapStyleWord(true);
		textAreaNewExtraInfo.setLineWrap(true);
		textAreaNewExtraInfo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));

		JButton btnSave = new JButton("Guardar");
		btnSave.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.anchor = GridBagConstraints.EAST;
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 7;
		panelNew.add(btnSave, gbc_btnSave);

		JLabel lblEmpty = new JLabel("Stefano Mazzuka");
		lblEmpty.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		GridBagConstraints gbc_lblEmpty = new GridBagConstraints();
		gbc_lblEmpty.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblEmpty.gridx = 2;
		gbc_lblEmpty.gridy = 8;
		panelNew.add(lblEmpty, gbc_lblEmpty);

		JPanel panelButtons = new JPanel();
		panelSearch.add(panelButtons, BorderLayout.SOUTH);
		GridBagLayout gbl_panelButtons = new GridBagLayout();
		gbl_panelButtons.columnWidths = new int[]{195, 0, 0};
		gbl_panelButtons.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelButtons.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelButtons.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelButtons.setLayout(gbl_panelButtons);

		JButton btnURL = new JButton("");
		GridBagConstraints gbc_btnURL = new GridBagConstraints();
		gbc_btnURL.fill = GridBagConstraints.BOTH;
		gbc_btnURL.insets = new Insets(0, 0, 5, 5);
		gbc_btnURL.gridx = 0;
		gbc_btnURL.gridy = 0;
		panelButtons.add(btnURL, gbc_btnURL);
		btnURL.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));

		JButton btnDeleteApp = new JButton("Borrar aplicaci\u00F3n");
		btnDeleteApp.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		GridBagConstraints gbc_btnDeleteApp = new GridBagConstraints();
		gbc_btnDeleteApp.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeleteApp.fill = GridBagConstraints.BOTH;
		gbc_btnDeleteApp.gridx = 1;
		gbc_btnDeleteApp.gridy = 0;
		panelButtons.add(btnDeleteApp, gbc_btnDeleteApp);

		JComboBox comboBoxCopy = new JComboBox();
		comboBoxCopy.setToolTipText("Usuario");
		GridBagConstraints gbc_comboBoxCopy = new GridBagConstraints();
		gbc_comboBoxCopy.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxCopy.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCopy.gridx = 0;
		gbc_comboBoxCopy.gridy = 1;
		panelButtons.add(comboBoxCopy, gbc_comboBoxCopy);

		JButton btnCopyUser = new JButton("Copiar usuario");
		btnCopyUser.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		GridBagConstraints gbc_btnCopyUser = new GridBagConstraints();
		gbc_btnCopyUser.insets = new Insets(0, 0, 5, 0);
		gbc_btnCopyUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCopyUser.gridx = 1;
		gbc_btnCopyUser.gridy = 1;
		panelButtons.add(btnCopyUser, gbc_btnCopyUser);
		
		JButton btnDeleteUser = new JButton("Borrar usuario");
		btnDeleteUser.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		GridBagConstraints gbc_btnDeleteUser = new GridBagConstraints();
		gbc_btnDeleteUser.anchor = GridBagConstraints.WEST;
		gbc_btnDeleteUser.insets = new Insets(0, 0, 0, 5);
		gbc_btnDeleteUser.gridx = 0;
		gbc_btnDeleteUser.gridy = 2;
		panelButtons.add(btnDeleteUser, gbc_btnDeleteUser);

		JButton btnCopyPass = new JButton("Copiar clave");
		btnCopyPass.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		GridBagConstraints gbc_btnCopyPass = new GridBagConstraints();
		gbc_btnCopyPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCopyPass.gridx = 1;
		gbc_btnCopyPass.gridy = 2;
		panelButtons.add(btnCopyPass, gbc_btnCopyPass);

		/* Actions */

		applications = fm.getApplications();
		updateComboBoxes(comboBoxApplications, comboBoxApplicationsSave);
		
		textArea.setText(app(comboBoxApplications.getSelectedIndex()));
		textArea.setCaretPosition(0);
		btnDeleteApp.setName(String.valueOf(comboBoxApplications.getSelectedIndex()));
		String URL = getURL(comboBoxApplications.getSelectedIndex());
		btnURL.setText(URL);
		btnURL.setName(URL);
		
		updateComboBoxCopy(comboBoxCopy, comboBoxApplications);
		rdbtnNoExistApplication.setSelected(true);

		mntmNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) contentPane.getLayout();
				card.show(contentPane, "panelNew");
			}
		});

		mntmSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) contentPane.getLayout();
				card.show(contentPane, "panelSearch");
			}
		});

		rdbtnExistApplication.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rdbtnNoExistApplication.setSelected(false);
			}
		});

		rdbtnNoExistApplication.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rdbtnExistApplication.setSelected(false);
			}
		});

		/* Buttons */

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.setText(app(comboBoxApplications.getSelectedIndex()));
				textArea.setCaretPosition(0);
				String URL = getURL(comboBoxApplications.getSelectedIndex());
				if (!URL.equals("-")) {
					btnURL.setVisible(true);
					btnURL.setText(URL);
					btnURL.setName(URL);
				}
				updateComboBoxCopy(comboBoxCopy, comboBoxApplications);
			}
		});

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (textFieldNewUser.getText().equals("") || textFieldNewPass.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Hay campos obligatorios vac�os *", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					String userName = textFieldNewUser.getText();
					String pass = textFieldNewPass.getText();
					String URL = textFieldNewURL.getText();
					String extra = textAreaNewExtraInfo.getText();
					User user = new User();
					user.setUser(userName);
					user.setPass(pass);
					user.setExtra(extra);

					String name;
					if(rdbtnExistApplication.isSelected()) {
						name = String.valueOf(comboBoxApplicationsSave.getSelectedItem());
						Application app = new Application();
						app.setName(name);
						app.setURL(URL);
						app.setUser(user);
						addExistApp(app, comboBoxApplicationsSave.getSelectedIndex());
					}
					else {
						if (textFieldNewApplication.getText().equals("")) name = "Nueva Aplicaci�n";
						else name = textFieldNewApplication.getText();
						Application app = new Application();
						app.setName(name);
						app.setURL(URL);
						app.setUser(user);
						if (addNoExistApp(app)) 
							JOptionPane.showMessageDialog(null, name + " ya existe", "Error", JOptionPane.ERROR_MESSAGE);
					}				
					updateComboBoxes(comboBoxApplications, comboBoxApplicationsSave);
					textFieldNewUser.setText("");
					textFieldNewPass.setText("");
					textFieldNewURL.setText("");
					textAreaNewExtraInfo.setText("");
					textFieldNewApplication.setText("");
				}
			}
		});

		btnDeleteApp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int option = JOptionPane.showConfirmDialog(null, "�Desea eliminar la aplicaci�n?", 
						"ATENCI�N", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					deleteApplication(comboBoxApplications.getSelectedIndex());
					updateComboBoxes(comboBoxApplications, comboBoxApplicationsSave);
					textArea.setText("");
				}
			}
		});

		btnDeleteUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int option = JOptionPane.showConfirmDialog(null, "�Desea eliminar el usuario " + getUser(comboBoxCopy, comboBoxApplications) + "?", 
						"ATENCI�N", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					deleteUser(comboBoxApplications.getSelectedIndex(), comboBoxCopy.getSelectedIndex());
					updateComboBoxCopy(comboBoxCopy, comboBoxApplications);
					textArea.setText(app(comboBoxApplications.getSelectedIndex()));
					textArea.setCaretPosition(0);
				}
			}
		});
		
		btnURL.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					java.awt.Desktop.getDesktop().browse(
							java.net.URI.create(btnURL.getName()));
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "El formato de la URL debe ser: " + '\n' + "www.miPagina.com", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnCopyUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StringSelection stringSelection = new StringSelection (String.valueOf(comboBoxCopy.getSelectedItem()));
				Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
				clpbrd.setContents (stringSelection, null);
			}
		});

		btnCopyPass.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StringSelection stringSelection = new StringSelection (getPass(comboBoxCopy, comboBoxApplications));
				Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
				clpbrd.setContents (stringSelection, null);
			}
		});
	}

	private void updateComboBoxes(JComboBox<String> comboBoxApplications, JComboBox<String> comboBoxApplicationsSave) {	
		ArrayList<String> data = new ArrayList<String>();

		for (int i = 0; i < this.applications.size(); i++) {
			data.add(applications.get(i).getName());
		}

		comboBoxApplications.setModel(new DefaultComboBoxModel<>(new Vector<String>(data)));
		comboBoxApplicationsSave.setModel(new DefaultComboBoxModel<>(new Vector<String>(data)));
	}
	private void updateComboBoxCopy(JComboBox<String> comboBoxCopy, JComboBox<String> comboBoxApplications) {
		ArrayList<User> users = this.applications.get(comboBoxApplications.getSelectedIndex()).getUsers();
		ArrayList<String> data = new ArrayList<String>();

		for (int i = 0; i < users.size(); i++) {
			data.add(users.get(i).getUser());
		}

		comboBoxCopy.setModel(new DefaultComboBoxModel<>(new Vector<String>(data)));
	}
	private String getUser(JComboBox<String> comboBoxCopy, JComboBox<String> comboBoxApplications) {
		ArrayList<User> users = this.applications.get(comboBoxApplications.getSelectedIndex()).getUsers();
		return users.get(comboBoxCopy.getSelectedIndex()).getUser();
	}
	private String getPass(JComboBox<String> comboBoxCopy, JComboBox<String> comboBoxApplications) {
		ArrayList<User> users = this.applications.get(comboBoxApplications.getSelectedIndex()).getUsers();
		return users.get(comboBoxCopy.getSelectedIndex()).getPass();
	}
	private String app(int application) {
		Application app = this.applications.get(application);
		String text = '\t' + "APLICACI�N " + app.getName() + '\n' + '\n' ;

		ArrayList<User> users = app.getUsers();

		for (int i = 0; i < users.size(); i++) {
			text += users.get(i).toString();
		}

		return text;
	}
	private String getURL(int i) {
		return this.applications.get(i).getURL();
	}
	private void deleteApplication(int i) {
		this.applications.remove(i);
	}
	private void deleteUser(int i, int j) {
		this.applications.get(i).getUsers().remove(j);
	}
	private void addExistApp(Application app, int i) {	
		this.applications.get(i).setUser(app.getUsers().get(0));
		this.applications.get(i).setURL(app.getURL());
	}
	private boolean addNoExistApp(Application app) {
		boolean exist = false;
		for (int i = 0; i < this.applications.size(); i++) {
			if (this.applications.get(i).getName().equals(app.getName())) {
				exist = true;
				i = this.applications.size();
			}
		}

		if (!exist) this.applications.add(app);
		return exist;
	}
}