package main.Java.saud.sparqlLogging.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Regex {

	private ArrayList<String> regexes = new ArrayList<>();
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
			out.createNewFile();
			System.out.println("Writing all regexes to path:" + dir);
			FileWriter fw = new FileWriter(out.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			System.out.println("Number of regexes is: " + regexes.size());
			for(int i=0;i<regexes.size();i++){
				bw.write(regexes.get(i));
				bw.newLine();
			}
			
			bw.close();
			System.out.println("Finishing writing the regex file");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printRegexesToScreen() {
		
			System.out.println("Number of regexes is: " + regexes.size());
			for(int i=0;i<regexes.size();i++){
				System.out.println(regexes.get(i));
			}
			System.out.println("Finishing writing the regex file");

		
	}

}
