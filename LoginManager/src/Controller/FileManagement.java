package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class FileManagement {

	private final String path = System.getProperty("user.dir") + File.separator + "data";
	private static String secretKey = "PonerLaClaveDeLong20";

	/* Constructor */

	public FileManagement() {}

	/* Methods */

	public static String encrypt(String text) {

		String base64EncryptedString = "";

		try {

			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
			byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

			SecretKey key = new SecretKeySpec(keyBytes, "DESede");
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, key);

			byte[] plainTextBytes = text.getBytes("utf-8");
			byte[] buf = cipher.doFinal(plainTextBytes);
			byte[] base64Bytes = Base64.getEncoder().encode(buf);
			base64EncryptedString = new String(base64Bytes);

		} catch (Exception ex) {
		}
		return base64EncryptedString;
	}
	public static String decrypt(String text) throws Exception {

		String base64EncryptedString = "";

		try {
			byte[] message = Base64.getDecoder().decode(text.getBytes("utf-8"));
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
			byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
			SecretKey key = new SecretKeySpec(keyBytes, "DESede");

			Cipher decipher = Cipher.getInstance("DESede");
			decipher.init(Cipher.DECRYPT_MODE, key);

			byte[] plainText = decipher.doFinal(message);

			base64EncryptedString = new String(plainText, "UTF-8");

		} catch (Exception ex) {
		}
		return base64EncryptedString;
	}
	public ArrayList<Application> readData() {
		ArrayList<Application> apps = new ArrayList<Application>();

		File file = new File(this.path);
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			if ((line = br.readLine()) != null) {
				try {
					line = decrypt(line);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				String[] data = line.split(";", -1);

				String name, url;
				for (int i = 0; i < data.length - 1; i += 5) {
					name = data[i];					
					url = data[i + 1];					

					User newUser = new User();
					newUser.setUser(data[i + 2]);
					newUser.setPass(data[i + 3]);
					newUser.setExtra(data[i + 4]);

					int pos = posApp(apps, name);

					Application app;
					if (pos == -1) { 
						app = new Application();
						app.setName(name);
						app.setUser(newUser);
						app.setURL(url);
						apps.add(app);
					}
					else apps.get(pos).setUser(newUser);
				}
			}

			fr.close();
			br.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return apps;
	}
	public void writeData(ArrayList<Application> apps) {

		File file = new File(this.path);

		String data = "";

		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(fw);

			for (int i = 0; i < apps.size(); i++) {	
				for (int j = 0; j < apps.get(i).getUsers().size(); j++) {
					data += apps.get(i).getName() + ";" 
							+ apps.get(i).getURL() + ";"
							+ apps.get(i).getUsers().get(j).getUser() + ";"
							+ apps.get(i).getUsers().get(j).getPass() + ";"
							+ apps.get(i).getUsers().get(j).getExtra() + ";";
				}
			}
			
			data = encrypt(data);	
			out.write(data);
			out.flush();
			out.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	private int posApp(ArrayList<Application> apps, String name) {
		int pos = -1;
		for (int i = 0; i < apps.size(); i++) {
			if (apps.get(i).getName().equals(name)) {
				pos = i;
				break;
			}
		}
		return pos;
	}
}