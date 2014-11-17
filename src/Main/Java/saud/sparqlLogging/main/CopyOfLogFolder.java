package Main.Java.saud.sparqlLogging.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;

import Main.Java.saud.sparqlLogging.model.Query;
import Main.Java.saud.sparqlLogging.model.Regex;
import Main.Java.saud.sparqlLogging.model.Stats;

public class CopyOfLogFolder {
	Logger log = org.slf4j.LoggerFactory.getLogger(CopyOfLogFolder.class);
	Regex regex = new Regex();

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

	int numberOfLines = 0;
	String disFile = null;

	public static void main(String[] args) {
		CopyOfLogFolder arg = new CopyOfLogFolder();

		if (args.length == 0) {
			System.out.println("insert one argument as the path to the folder");
			System.exit(0);
		} else {
			arg.ExtractRegexFromDirToFile(args[0]);
		}

	}

	private String currentPath = null;
	private int flagCounter = 0;

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
	}

	int MAXARRAYSIZE = 500000;

	private void forEachLog(String filePath) {
		File in = new File(filePath);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) {
				numberOfLines += 1;
				if (line.toLowerCase().contains("regex")) {
					Query query = new Query(line);
					if (!query.isIngenuneQueryDecoding()) {
						query.jena(query.getQueryString());
						if (!query.isIngenuneQuerySyntax()) {
							regex.addRegexes(query.regex);
							flagCounter = flagCounter + query.getFlag();
							if (MAXARRAYSIZE <= regex.regexes.size()) {
								flushToFile();
								regex = new Regex();
							}
						} else {
							AddIngenuneQueriesSyntax(query
									.getIngenuneQuerySyntax());
						}

					} else {
						AddIngenuneQueriesDecoding(query
								.getIngenuneQueryDecoding());
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

	public void flushToFile() {
		String resultPath = currentPath + "/Result";
		File resultPathFile = new File(resultPath);
		if (!resultPathFile.exists()) {
			resultPathFile.mkdir();
		}
		regex.printRegexesToFile(resultPath);

	}

	public void finishingWritingToFile() {
		flushToFile();

		ArrayList<String> finalRegexes = new ArrayList<>();

		File in = new File(currentPath + "/Result/Regexes.txt");

		try {
			BufferedReader reader = new BufferedReader(new FileReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) {
				finalRegexes.add(line);
			}
			reader.close();
			Stats st = new Stats(finalRegexes, flagCounter);
			st.printStats(numberOfLines, getIngenuneQueriesDecoding().size(),
					getIngenuneQueriesSyntax().size());
			st.printStatsToFile(currentPath, numberOfLines,
					getIngenuneQueriesDecoding(), getIngenuneQueriesSyntax());
		} catch (IOException e) {

		}
	}
}