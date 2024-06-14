package net.texala.employee_service.File;

import java.io.File;
import java.io.IOException;

public class FileUnits {

	public static final String FILE_PATH = "data.csv";

	public static void ensureFileExists() {
		File file = new File(FILE_PATH);
		try {
			if (!file.exists()) {
				file.createNewFile();

			}
		} catch (IOException e) {
			System.out.println("Error creating file: " + e.getMessage());
		}
	}
}
