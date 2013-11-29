package main.java.saud.sparqlLogging.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import main.java.saud.sparqlLogging.main.CopyOfLogFolder;

import org.slf4j.Logger;

public class Regex {
	Logger log = org.slf4j.LoggerFactory.getLogger(Regex.class);
	public ArrayList<String> regexes = new ArrayList<>();

	public ArrayList<String> getRegexes() {
		return regexes;
	}

	public void addRegex(String regex) {
		regexes.add(regex);
	}

	public void addRegexes(ArrayList<String> reg) {
		regexes.addAll(reg);
	}

	public int flag = 0;

	public int getFlag() {
		return flag;
	}

	public void addFlag(int flag) {
		this.flag = this.flag + flag;
	}

	public void printRegexesToFile(String dir) {
		dir = dir + "/Regexes.txt";
		File out = new File(dir);
		try {
			if (!out.exists()) {
				out.createNewFile();
			}
			FileWriter fw = new FileWriter(out.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < regexes.size(); i++) {
				bw.write(regexes.get(i));
				bw.newLine();
			}

			bw.close();


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printRegexesToScreen() {

		System.out.println("Number of regexes is: " + regexes.size());
		for (int i = 0; i < regexes.size(); i++) {
			System.out.println(regexes.get(i));
		}
		System.out.println("Finishing writing the regex file");

	}

}
