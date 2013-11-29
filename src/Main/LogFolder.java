package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Model.Query;
import Model.Regex;
import Model.Stats;

public class LogFolder {

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
		LogFolder arg = new LogFolder();

		if (args.length == 0) {
			System.out.println("insert one argument as the path to the folder");
			System.exit(0);
		} else {
			arg.ExtractRegexFromDirToFile(args[0]);
		}

	}

	private void ExtractRegexFromDirToFile(String path) {

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
					System.out.println("The file " + file.getName()
							+ " doesn't contain log");
			}
			String resultPath = path + "/Result";
			File resultPathFile = new File(resultPath);
			  if (!resultPathFile.exists()) {
				  resultPathFile.mkdir();
			  }
			regex.printRegexesToFile(resultPath);
			Stats st = new Stats(regex.getRegexes(), regex.getFlag());
			st.printStats(numberOfLines, getIngenuneQueriesDecoding().size(), getIngenuneQueriesSyntax().size());
			st.printStatsToFile(resultPath, numberOfLines, getIngenuneQueriesDecoding(),getIngenuneQueriesSyntax());

		} else {
			System.out.println("The path: " + path + " is not a directory");
		}

	}

	private void forEachLog(String filePath) {
		File in = new File(filePath);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) {
				numberOfLines+=1;
				if (line.toLowerCase().contains("regex")) {
					Query query = new Query(line);
					if (!query.isIngenuneQueryDecoding()) {
						query.jena(query.getQueryString());
						if (!query.isIngenuneQuerySyntax()) {
							regex.addRegexes(query.regex);
							regex.addFlag(query.getFlag());
						}
						else{
							AddIngenuneQueriesSyntax(query.getIngenuneQuerySyntax());
						}

					} else {
						AddIngenuneQueriesDecoding(query.getIngenuneQueryDecoding());
					}
				}

			}
			reader.close();
			reader = null;
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
