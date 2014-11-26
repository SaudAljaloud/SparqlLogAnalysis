package Main.Java.saud.sparqlLogging.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Main.Java.saud.sparqlLogging.model.StatsFromArrayList;

/**
 * User: Saud Aljaloud email: sza1g10@ecs.soton.ac.uk
 */

public class GenerateStats {

	public static void main(String[] args) {
		GenerateStats arg = new GenerateStats();

		if (args.length == 0) {
			System.out.println("insert one argument as the path to the file");
			System.exit(0);
		} else {
			arg.loadRegexIntoArrayList(args[0]);
		}

	}

	public void loadRegexIntoArrayList(String filePath) {

		ArrayList<String> finalRegexes = new ArrayList<>();

		File in = new File(filePath);

		try {
			BufferedReader reader = new BufferedReader(new FileReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) {
				finalRegexes.add(line);
			}
			reader.close();
			StatsFromArrayList st = new StatsFromArrayList(finalRegexes);
			st.printStats();
		} catch (IOException e) {

		}
	}
}
