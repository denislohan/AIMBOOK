package database;

import model.Distributor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Properties;

public class LocalFile implements InformationStore, Runnable {
	//private static Distributor distrbutor = null;

	@Override
	public boolean register(Distributor distributor) {
		//distrbutor = distributor;
		File myFile = new File(distributor.getCode() + "" + ".properties");
		Writer writer = null;
		try {
			writer = new FileWriter(myFile, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		OutputStream outputStream = null;
		InputStream inputStream = null;
		try {
			outputStream = new FileOutputStream(myFile);
			inputStream = new FileInputStream(myFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String code = distributor.getCode();
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		properties.setProperty(code + "_code", distributor.getCode());
		properties.setProperty(code + "_FN", distributor.getFirstName());
		properties.setProperty(code + "_SN", distributor.getSurname());
		properties.setProperty(code + "_Tel", distributor.getPhoneNumber());
		properties.setProperty(code + "_upLine", distributor.getUpLineCode());
		properties.setProperty(code + "_dbName", distributor.getDbName());

		try {
			properties.store(writer, " information of new Distributor");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	// ================================//

	public static void checkInternetAndSend() {

		Properties properties = new Properties();
		try {
			Files.list(Paths.get(".")).forEach(LocalFile::sendToDB);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ============================//

	private static void sendToDB(Path path) {

		DBConnector db;
		Distributor distributor = new Distributor();
		String fileName = path.getFileName().toString();
		File file = null;
		Properties prop = new Properties();

		if (fileName.contains("properties")) {
			try {
				file = new File(fileName);
				FileInputStream os = new FileInputStream(file);
				prop.load(os);
				String code = fileName.split(".p", 2)[0];
				String firstName = prop.getProperty(code + "_FN");
				distributor.setFirstName(firstName);
				String code_ = prop.getProperty(code + "_code");
				distributor.setCode(code_);
				String surName = prop.getProperty(code + "_SN");
				distributor.setSurname(surName);
				String tel = prop.getProperty(code + "_Tel");
				distributor.setPhoneNumber(tel);
				String upLine = prop.getProperty(code + "_upLine");
				distributor.setUpLineCode(upLine);
				String dbName = prop.getProperty(code + "_dbName");
				distributor.setDbName(dbName);

				os.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			db = new DBConnector(distributor.getDbName());
			boolean done = db.register(distributor);
			if (done && file != null)
				file.delete();
		}
	}

	// ===============================//
	@Override
	public void run() {
		while (true) {
			 
				checkInternetAndSend();
			
			try {
				Thread.currentThread();
				Thread.sleep(30000); // 30 seconds
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	// ==============================//

}

