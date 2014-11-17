package main1.Java.saud.sparqlLogging.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Main.Java.saud.sparqlLogging.model.QueryForExtractingSPARQLRegex;

public class SparqlRegexExtraction {

	static String DIR;
	// static int MAXBEFOREFLUSH = 100000000;
	String currentPath = null;
	int numberOfLines = 0;

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

	private ArrayList<String> SparqlRegexQuereis = new ArrayList<>();

	public ArrayList<String> getSparqlRegexQuereis() {
		return SparqlRegexQuereis;
	}

	public void AddSparqlRegexQuery(String SparqlRegexQuery) {
		this.SparqlRegexQuereis.add(SparqlRegexQuery);
	}

	public static void main(String[] args) {
		SparqlRegexExtraction main = new SparqlRegexExtraction();

		if (args[0].equals("--help")) {
			main.usage();
			System.exit(0);
		} else {
			main.getFilesFromDir(args[0]);

		}
	}

	private void getFilesFromDir(String path) {

		this.currentPath = path;

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

			printingStats();
		} else {
			System.out.println("The path: " + path + " is not a directory");
		}

	}

	private void processfile(String filePath) {

		try {
			File in = new File(filePath);
			BufferedReader reader = new BufferedReader(new FileReader(in));
			String line = null;
			String constructedQuery = null;
			while ((line = reader.readLine()) != null) {
				constructedQuery = line;
				processQuery(constructedQuery);
			}

			reader.close();
			reader = null;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void processQuery(String constructedQuery) {
		QueryForExtractingSPARQLRegex SparqlregexQ;
		numberOfLines += 1;
		if (constructedQuery.toLowerCase().contains("regex")) {

			SparqlregexQ = new QueryForExtractingSPARQLRegex(constructedQuery);
			if (!SparqlregexQ.isIngenuneQueryDecoding()) {
				SparqlregexQ.jena(SparqlregexQ.getQueryString());
				if (!SparqlregexQ.isIngenuneQuerySyntax()) {

					AddSparqlRegexQuery(SparqlregexQ.getQueryString());

				} else {
					AddIngenuneQueriesSyntax(SparqlregexQ.getIngenuneQuerySyntax());
				}

			} else {
				AddIngenuneQueriesDecoding(SparqlregexQ.getIngenuneQueryDecoding());
			}
		}

	}

	public void printingStats() {

		File resultDir = new File(currentPath + "/SPARQLRegexQueries");
		resultDir.mkdir();
		File in = new File(resultDir + "/QueriesContainingRegex.txt");

		try {
			in.createNewFile();
			FileWriter fw = new FileWriter(in.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (String string : SparqlRegexQuereis) {
				bw.write(string);
				bw.newLine();
				bw.write("=========================================");
				bw.newLine();

			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String IngenuneQueriesDecodingDir = resultDir
				+ "/IngenuneQueriesDecoding.txt";
		File IngenuneQueriesDecodingOut = new File(IngenuneQueriesDecodingDir);
		try {
			IngenuneQueriesDecodingOut.createNewFile();
			FileWriter fw = new FileWriter(
					IngenuneQueriesDecodingOut.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (String string : ingenuneQueriesDecoding) {
				bw.write(string);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String IngenuneQueriesSyntaxDir = resultDir
				+ "/IngenuneQueriesSyntax.txt";
		File IngenuneQueriesSyntaxOut = new File(IngenuneQueriesSyntaxDir);
		try {
			IngenuneQueriesSyntaxOut.createNewFile();
			FileWriter fw = new FileWriter(
					IngenuneQueriesSyntaxOut.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (String string : ingenuneQueriesSyntax) {
				bw.write(string);
				bw.newLine();
				bw.write("=========================================");
				bw.newLine();

			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void usage() {
		System.out.println("Usage:");

	}

}
