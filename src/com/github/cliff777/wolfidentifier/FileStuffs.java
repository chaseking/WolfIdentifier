package com.github.cliff777.wolfidentifier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStuffs {
	int id;
	File file = new File("plugins" + File.separator + "WolfIdentifier" + File.separator + "config.txt");

	public FileStuffs() {

		if(!file.exists()) {
			setupConfig();
		}else{
			readID(file);
		}
	}

	public int getID() {
		return id;
	}

	private void readID(File f) {
		String line = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			line = br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			error("IO Error setting up config! Disabling....");
		} catch (IOException e) {
			e.printStackTrace();
			error("IO Error setting up config! Disabling....");
		}

		if(line.contains(":")) {

			String[] args = line.split(":");

			try {

				if(args[0].equalsIgnoreCase("item-id") && isInt(args[1])) {
					id = Integer.parseInt(args[1]);
				}else{
					error("Config is wrongly formatted! Creating new config...");
					setupConfig();
				}

			}catch (Exception e) {
				error("Config is wrongly formatted! Creating new config...");
				setupConfig();
			}

		}else{
			error("Config is wrongly formatted! Creating new config...");
			setupConfig();
		}

	}

	void setupConfig() {

		try {
			new File("plugins" + File.separator + "WolfIdentifier").mkdir();
			file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write("item-id:280");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean isInt(String test) {
		
		try{
			Integer.parseInt(test);
			return true;
		}catch (Exception e) {
			return false;
		}

	}

	private void error(String error) {
		WolfMain.plugin.out(error);
		WolfMain.plugin.getServer().getPluginManager().disablePlugin(WolfMain.plugin);
	}
}
