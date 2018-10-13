package Controller;

import java.awt.EventQueue;

import View.Login;

public class Main {

	public static void main(String[] args) {
		runLogin();
	}

	private static void runLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}