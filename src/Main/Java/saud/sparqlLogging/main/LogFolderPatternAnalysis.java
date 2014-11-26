package Main.Java.saud.sparqlLogging.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import Main.Java.saud.sparqlLogging.model.QueryWithPatternAnalysis;

/**
 * User: Saud Aljaloud email: sza1g10@ecs.soton.ac.uk
 */

public class LogFolderPatternAnalysis {
	Logger log = org.slf4j.LoggerFactory
			.getLogger(LogFolderPatternAnalysis.class);

	private String queryDataset;

	public String getQueryDataset() {
		return queryDataset;
	}

	private ArrayList<String> ingenuneQueriesDecoding = new ArrayList<>();

	public ArrayList<String> getIngenuneQueriesDecoding() {
		return ingenuneQueriesDecoding;
	}

	public void AddIngenuneQueriesDecoding(String ingenuneQueriesDecoding) {
		this.ingenuneQueriesDecoding.add(ingenuneQueriesDecoding);
	}

	private ArrayList<String> ingenuneQueriesSyntax = new ArrayList<>();

	public ArrayList<String> getIngenuneQueriesSyntax() {
		return ingenuneQueriesSyntax;
	}

	public void AddIngenuneQueriesSyntax(String ingenuneQueriesSyntax) {
		this.ingenuneQueriesSyntax.add(ingenuneQueriesSyntax);
	}

	public void setQueryDataset(String queryDataset) {
		this.queryDataset = queryDataset;
	}

	List<String> predicates = new ArrayList<>();

	public List<String> getPreidicates() {
		return predicates;
	}

	public void addPreidicatesList(List<String> s) {
		this.predicates.addAll(s);
	}

	int numberOfLines = 1;
	String disFile = null;

	public int subject = 0;
	public int predicat = 0;
	public int object = 0;

	public static void main(String[] args) {
		LogFolderPatternAnalysis arg = new LogFolderPatternAnalysis();

		if (args.length == 0) {
			System.out.println("insert one argument as the path to the folder");
			System.exit(0);
		} else {
			arg.ExtractRegexFromDirToFile(args[0]);
		}

	}

	private String currentPath = null;

	private void ExtractRegexFromDirToFile(String path) {

		this.currentPath = path;

		File folder = new File(path);
		if (folder.isDirectory()) {
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
				File file = listOfFiles[i];
				if (file.isFile() && file.getName().contains("log")) {
					System.out.println("The file will be processed is: "
							+ file.getPath());
					forEachLog(file.getPath());
					// Runtime.getRuntime().exec("purge");
					// System.gc();

				} else
					log.debug("The file " + file.getName()
							+ " doesn't contain log");
			}

		} else {
			System.out.println("The path: " + path + " is not a directory");
		}
		finishingWritingToFile();
		wtiteStats();
	}

	private void forEachLog(String filePath) {
		File in = new File(filePath);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) {
				numberOfLines += 1;
				if (line.toLowerCase().contains("regex")) {
					QueryWithPatternAnalysis query = new QueryWithPatternAnalysis(
							line);
					if (!query.isIngenuneQueryDecoding()) {
						query.jena(query.getQueryString());
						if (!query.isIngenuneQuerySyntax()) {
							addPreidicatesList(query.getPreidicates());
							subject += query.subject;
							predicat += query.predicat;
							object += query.object;

						}

					}

				}

				// write regexes to file when max is reached

			}
			reader.close();
			reader = null;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void wtiteStats() {

		// String predicatesPath = currentPath
		// + "/PatternAnalysis/predicates.txt";
		File predicatesPath = new File(currentPath + "/PatternAnalysis");
		File predicatesFile = new File(currentPath
				+ "/PatternAnalysis/stats.txt");
		try {
			if (!predicatesPath.exists()) {
				predicatesPath.mkdir();

			}

			FileWriter fw = new FileWriter(predicatesFile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Subjects:\t" + subject);
			bw.newLine();
			bw.write("Predicates:\t" + predicat);
			bw.newLine();
			bw.write("Objects:\t" + object);
			bw.newLine();

			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void finishingWritingToFile() {

		// String predicatesPath = currentPath
		// + "/PatternAnalysis/predicates.txt";
		File predicatesPath = new File(currentPath + "/PatternAnalysis");
		File predicatesFile = new File(currentPath
				+ "/PatternAnalysis/predicates.txt");
		try {
			if (!predicatesPath.exists()) {
				predicatesPath.mkdir();

			}

			FileWriter fw = new FileWriter(predicatesFile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (String string : predicates) {
				bw.write(string);
				bw.newLine();

			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}