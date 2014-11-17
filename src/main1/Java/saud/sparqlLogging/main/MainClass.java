package main1.Java.saud.sparqlLogging.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Main.Java.saud.sparqlLogging.model.Query;
import Main.Java.saud.sparqlLogging.model.QueryWithPatternAnalysis;
import Main.Java.saud.sparqlLogging.model.Regex;
import Main.Java.saud.sparqlLogging.model.Stats;

public class MainClass {

	static String DIR;
	static String operation;
	static String format;
	static int MAXBEFOREFLUSH = 100000000;
	String currentPath = null;
	int flagCounter = 0;
	int numberOfLines = 0;

	public static final String CLF_FORMAT = "CLF";
	public static final String BIOPORTAL_FORMAT = "BioPortal";
	public static final String OPENBIOMED_FORMAT = "OpenBioMed";
	public static final String EXTRACTREGEX_OP = "extractRegexes";
	public static final String PATTERNANALYSIS_OP = "patternAnalysis";

	// Start of variables for the pattern analysis
	public int subject = 0;
	public int predicat = 0;
	public int object = 0;

	List<String> predicates = new ArrayList<>();

	public List<String> getPreidicates() {
		return predicates;
	}

	public void addPreidicatesList(List<String> s) {
		this.predicates.addAll(s);
	}

	// End of variables for the pattern analysis

	Regex regex;

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

	public static void main(String[] args) {
		MainClass main = new MainClass();

		if (args.length == 1) {
			if (args[0].equals("--help")) {
				main.usage();
				System.exit(0);
			} else {
				if (new File(args[0]).exists()) {
					operation = EXTRACTREGEX_OP;
					format = CLF_FORMAT;
					main.getFilesFromDir(args[0]);
				} else {
					System.out.println(args[0] + " is not a directory!!");
					System.exit(0);
				}
			}

		} else if (args.length == 3) {
			DIR = args[0];
			operation = args[1];
			format = args[2];
			main.getFilesFromDir(args[0]);
		} else if (args.length == 3) {
			DIR = args[0];
			operation = args[1];
			format = args[2];
			MAXBEFOREFLUSH = Integer.valueOf(args[3]);
			main.getFilesFromDir(args[0]);
		} else {
			main.usage();
			System.exit(0);
		}
	}

	private void getFilesFromDir(String path) {

		this.currentPath = path;
		if (operation.equals(EXTRACTREGEX_OP)) {
			regex = new Regex();
		}
		File folder = new File(path);
		if (folder.isDirectory()) {
			File[] listOfFiles = folder.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
				File file = listOfFiles[i];
				if (file.isFile() && file.getName().contains("log")) {
					System.out.println("The file will be processed is: "
							+ file.getPath());
					processfile(file.getPath());

				} else
					System.out.println("The file " + file.getName()
							+ " doesn't contain log");
			}

		} else {
			System.out.println("The path: " + path + " is not a directory");
		}

		if (operation.equals(EXTRACTREGEX_OP)) {
			finishingWritingToFile();
		} else if (operation.equals(PATTERNANALYSIS_OP)) {

			printPatternAnalysisToScreen();
			writePatternAnalysisToFile();
		}
	}

	private void processfile(String filePath) {

		try {
			File in = new File(filePath);
			BufferedReader reader = new BufferedReader(new FileReader(in));
			String line = null;
			String constructedQuery = null;
			StringBuilder queryAppender = new StringBuilder();
			if (format.equals(BIOPORTAL_FORMAT)
					|| format.equals(OPENBIOMED_FORMAT)) {
				String delimiter = null;
				System.out.println(format);
				if (format.equals(BIOPORTAL_FORMAT)) {
					delimiter = "###";
				} else {
					delimiter = "------------";
				}

				int i = 0;
				while ((line = reader.readLine()) != null) {
					if (!line.contains(delimiter)) {
						queryAppender.append("\n");
						queryAppender.append(line);
						i++;
					} else if (i != 0) {

						i = 0;
						constructedQuery = queryAppender.toString();
						if (constructedQuery != "" && constructedQuery != " "
								&& constructedQuery != "\n"
								&& constructedQuery != null) {
							processQuery(constructedQuery);
							queryAppender = new StringBuilder();
						}
					}
				}
			} else if (format.equals(CLF_FORMAT)) {
				while ((line = reader.readLine()) != null) {
					constructedQuery = line;
					processQuery(constructedQuery);
				}
			}
			reader.close();
			reader = null;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void processQuery(String constructedQuery) {

		numberOfLines += 1;
		if (constructedQuery.toLowerCase().contains("regex")) {

			if (operation.equals(EXTRACTREGEX_OP)) {
				processRegexes(constructedQuery);

			} else if (operation.equals(PATTERNANALYSIS_OP)) {
				processPatternAnalysis(constructedQuery);
			}
		}

	}

	private void processRegexes(String constructedQuery) {
		Query query;
		if (format.equals(CLF_FORMAT)) {
			query = new Query(constructedQuery);
		} else {
			query = new Query(constructedQuery, false);
		}
		if (!query.isIngenuneQueryDecoding()) {
			query.jena(query.getQueryString());
			if (!query.isIngenuneQuerySyntax()) {
				regex.addRegexes(query.regex);
				flagCounter = flagCounter + query.getFlag();
				if (MAXBEFOREFLUSH <= regex.regexes.size()) {
					flushToFile();
					regex = new Regex();
				}
			} else {
				AddIngenuneQueriesSyntax(query.getIngenuneQuerySyntax());
			}

		} else {
			AddIngenuneQueriesDecoding(query.getIngenuneQueryDecoding());
		}
	}

	private void processPatternAnalysis(String constructedQuery) {
		QueryWithPatternAnalysis query = new QueryWithPatternAnalysis(
				constructedQuery);
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
		File resultDir = new File(currentPath + "/Result");
		resultDir.mkdir();
		File in = new File(resultDir + "/Regexes.txt");

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

	public void printPatternAnalysisToScreen() {

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

	public void writePatternAnalysisToFile() {

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

	private void usage() {
		System.out.println("Usage:");
		System.out
				.println("./bash <dir> [extractRegexes|patternAnalysis] [CLF|BioPortal|OpenBioMed] [ThreasholdNumber]");
		System.out.println("Dir has to be specified");
		System.out.println("Default: extractRegexes CLF inMemory");
	}

}
