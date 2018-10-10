package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FileManagement {

	private String path;

	/* Constructor */

	public FileManagement() {
		this.path = System.getProperty("user.dir") 
				+ File.separator + "logins.txt";
	}

	/* Methods */

	public ArrayList<Application> getApplications() {
		ArrayList<Application> apps = new ArrayList<Application>();

		File file = new File(this.path);
		if (file.exists()) {

			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);

				String line;
				while ((line = br.readLine()) != null) {
					String[] content = line.split(": ");
					Application app = new Application();
					if (content[0].equals("APPLICATION")) app.setName(content[1]);		
					while (!(line = br.readLine()).equals("---")) {
						content = line.split(": ");
						if (content[0].equals("URL")) app.setURL(content[1]);
						else {
							User user = new User();
							user.setUser(content[1]);
							line = br.readLine();
							content = line.split(": ");
							user.setPass(content[1]);
							line = br.readLine();
							content = line.split(": ");
							user.setExtra(content[1]);
							app.setUser(user);
						}
					}
					apps.add(app);
				}

				fr.close();
				br.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else JOptionPane.showMessageDialog(null, "El archivo logins.txt no existe.");

		return apps;
	}
	public void addApplication(Application app) {
		File file = new File(this.path);
		if (file.exists()) {
			ArrayList<String> lines = new ArrayList<String>();
			String line = null;

			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);

				while ((line = br.readLine()) != null)
					lines.add(line);

				lines.add("APPLICATION: " + app.getName());
				lines.add("USER: " + app.getUsers().get(0).getUser());
				lines.add("PASS: " + app.getUsers().get(0).getPass());
				lines.add("EXTRAINFO: " + app.getUsers().get(0).getExtra());
				lines.add("URL: " + app.getURL());
				lines.add("---");
				fr.close();
				br.close();

				FileWriter fw = new FileWriter(file);
				BufferedWriter out = new BufferedWriter(fw);

				for (String l : lines) {
					out.write(l);
				}

				out.flush();
				out.close();

				JOptionPane.showMessageDialog(null, "Archivo editado.");

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		else JOptionPane.showMessageDialog(null, "El archivo logins.txt no existe.");
	}
	public String showFile(String name) {
		File file = new File(this.path  + name + ".txt");
		if (file.exists()) {
			String content = "";

			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);

				String line;
				while ((line = br.readLine()) != null)
					content += line + '\n';

				fr.close();
				br.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return content;
		}

		else {
			JOptionPane.showMessageDialog(null, "El archivo no existe.");
			return "";
		}
	}
}