package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelExporter {

	/*
	 * Constructor
	 */

	public ExcelExporter() {}

	public void export(ArrayList<Application> apps, File file) throws IOException {
		FileWriter out = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(out);

		bw.write("NAME" + '\t');
		bw.write("URL" + '\t');
		bw.write("USER" + '\t');
		bw.write("PASSWORD" + '\t');
		bw.write("EXTRA INFO" + '\t');

		bw.write('\n');

		for (int i = 0; i < apps.size(); i++) {
			for (int j = 0; j < apps.get(i).getUsers().size(); j++) {
				bw.write(apps.get(i).getName() + '\t'); 
				bw.write(apps.get(i).getURL() + '\t');
				bw.write(apps.get(i).getUsers().get(j).getUser() + '\t');
				bw.write(apps.get(i).getUsers().get(j).getPass() + '\t');
				bw.write(apps.get(i).getUsers().get(j).getExtra() + '\t');
				bw.write('\n');
			}			
		}
		bw.close();
	}
}
