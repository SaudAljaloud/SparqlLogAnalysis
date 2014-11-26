package Main.Java.saud.sparqlLogging.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Saud Aljaloud email: sza1g10@ecs.soton.ac.uk
 */

public class Stats {

	private int regexesNumber = 0;

	private int startWith = 0;
	private int endWith = 0;
	private int negation = 0;
	private int url = 0;
	private int ingenuen = 0;

	private int justStar = 0;
	private int dotStar = 0;
	private int dotStarQuestion = 0;

	private int justPlus = 0;
	private int dotPlus = 0;
	private int dotPlusQuestion = 0;

	private double averageLength = 0;
	private double averageLengthOfRegexLiteral = 0;
	private int maxLength = 0;

	private int notEnglishString = 0;
	private int exactSearch = 0;
	private int justLetters = 0;
	private int justNumbers = 0;

	private int noMetaChar = 0;
	private int alternation = 0;
	private int restrictedQuantifiers = 0;
	private int grouping = 0;
	private int backRef = 0;
	private int quantifiers = 0;
	private int reluctantQuantifiers = 0;
	private int characterClass = 0;

	private int flag = 0;

	public int getCharacterClass() {
		return characterClass;
	}

	public void addCharacterClass() {
		this.characterClass += 1;
	}

	public int getReluctantQuantifiers() {
		return reluctantQuantifiers;
	}

	public void addReluctantQuantifiers() {
		this.reluctantQuantifiers += 1;
	}

	public int getQantifiers() {
		return quantifiers;
	}

	public void addQantifiers() {
		this.quantifiers += 1;
	}

	public int getBackref() {
		return backRef;
	}

	public void addBackref() {
		this.backRef += 1;
	}

	public int getGrouping() {
		return grouping;
	}

	public void addGrouping() {
		this.grouping += 1;
	}

	public int getRestrictedQuantifiers() {
		return restrictedQuantifiers;
	}

	public void addRestrictedQuantifiers() {
		this.restrictedQuantifiers += 1;
	}

	public int getAlternation() {
		return alternation;
	}

	public void addAlternation() {
		this.alternation += 1;
	}

	public int getNoMetaChar() {
		return noMetaChar;
	}

	public void addNoMetaChar() {
		this.noMetaChar += 1;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getJustNumbers() {
		return justNumbers;
	}

	public void addJustNumbers() {
		this.justNumbers += 1;
	}

	public int getJustLetters() {
		return justLetters;
	}

	public void addJustLetters() {
		this.justLetters += 1;
	}

	public int getExactSearch() {
		return exactSearch;
	}

	public void addExactSearch() {
		this.exactSearch += 1;
	}

	public int getNotEnglishString() {
		return notEnglishString;
	}

	public void addNotEnglishString() {
		this.notEnglishString += 1;
	}

	public int getStartWith() {
		return startWith;
	}

	public void addStartWith() {
		this.startWith += 1;
	}

	public int getEndWith() {
		return endWith;
	}

	public void addEndWith() {
		this.endWith += 1;
	}

	public int getNegation() {
		return negation;
	}

	public void addNegation() {
		this.negation += 1;
	}

	public int getUrl() {
		return url;
	}

	public void addUrl() {
		this.url += 1;
	}

	public int getIngenuen() {
		return ingenuen;
	}

	public void addIngenuen() {
		this.ingenuen += 1;
	}

	public int getJustStar() {
		return justStar;
	}

	public void addJustStar() {
		this.justStar += 1;
	}

	public int getDotStar() {
		return dotStar;
	}

	public void addDotStar() {
		this.dotStar += 1;
	}

	public int getDotStarQuestion() {
		return dotStarQuestion;
	}

	public void addDotStarQuestion() {
		this.dotStarQuestion += 1;
	}

	public int getJustPlus() {
		return justPlus;
	}

	public void addJustPlus() {
		this.justPlus += 1;
	}

	public int getDotPlus() {
		return dotPlus;
	}

	public void addDotPlus() {
		this.dotPlus += 1;
	}

	public int getDotPlusQuestion() {
		return dotPlusQuestion;
	}

	public void addDotPlusQuestion() {
		this.dotPlusQuestion += 1;
	}

	public double getAverageLength() {
		return averageLength;
	}

	private void calculateAverageLength(int regexesLength) {
		this.averageLength = averageLength / regexesLength;
	}

	public void setAverageLength(int length) {
		this.averageLength += length;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void addMaxLength(int length) {
		if (this.maxLength < length)
			this.maxLength = length;
	}

	public int getRegexesNumber() {
		return regexesNumber;
	}

	public void setRegexesNumber(int regexesNumber) {
		this.regexesNumber = regexesNumber;
	}

	public double getAverageLengthOfRegexLiteral() {
		return averageLengthOfRegexLiteral;
	}

	public void setAverageLengthOfRegexLiteral(String regex) {

		int counter = 0;
		int max = 0;
		Character ch1 = '$';
		Character ch2 = '^';
		Character ch3 = '.';
		Character ch4 = '*';
		Character ch5 = '+';
		Character ch6 = '^';
		Character ch7 = '/';
		Character ch8 = '?';
		Character ch9 = ')';
		Character ch10 = '(';
		for (int i = 0; i < regex.length(); i++) {
			Character org = regex.charAt(i);
			if (!org.equals(ch1) && !org.equals(ch2) && !org.equals(ch3)
					&& !org.equals(ch4) && !org.equals(ch5) && !org.equals(ch6)
					&& !org.equals(ch7) && !org.equals(ch8) && !org.equals(ch9)
					&& !org.equals(ch10)) {
				counter++;
			} else {
				if (counter > max)
					max = counter;
				counter = 0;
			}

		}
		if (counter > max) {
			max = counter;
		}

		this.averageLengthOfRegexLiteral = (getAverageLengthOfRegexLiteral() + max) / 2;

	}

	// constrctor
	public Stats(ArrayList<String> regexes, int flag) {

		setRegexesNumber(regexes.size());
		setFlag(flag);

		for (int i = 0; i < regexes.size(); i++) {
			Pattern p = Pattern
					.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
			Matcher m = p.matcher(regexes.get(i));
			if (!m.find()) {
				addIngenuen();

			} else {
				p = Pattern.compile("([^\\\\]|^)\\[.+?[^\\\\]\\]");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addCharacterClass();
				}
				p = Pattern
						.compile("[^\\\\]((\\?\\?)|(\\*\\?)|(\\+\\?)|(\\}\\?))");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addReluctantQuantifiers();
				}
				p = Pattern.compile("[^\\\\][\\*\\?\\+]");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addQantifiers();
				}
				p = Pattern
						.compile("(\\\\(.*?\\\\).*\\1)|(\\\\(.*?\\\\).*\\2)");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addBackref();
				}
				p = Pattern.compile("([^\\\\]|^)\\(.+?[^\\\\]\\)");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addGrouping();
				}
				p = Pattern.compile("[^\\\\]\\{[0-9, ]+?\\}");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addRestrictedQuantifiers();
				}
				p = Pattern.compile("[^\\\\]\\|.");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addAlternation();
				}
				p = Pattern.compile("^\\^.+");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addStartWith();
				}
				p = Pattern.compile(".+\\$$");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addEndWith();
				}
				p = Pattern.compile("\\[\\^");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addNegation();
				}
				p = Pattern.compile("(?i)http|www\\.");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addUrl();
				}
				p = Pattern.compile("([^\\.\\\\]|^)\\*");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addJustStar();
				}
				p = Pattern.compile("([^\\.\\\\]|^)\\+");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addJustPlus();
				}
				p = Pattern.compile("([^\\\\]|^)\\.\\+[^\\?]?");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addDotPlus();
				}
				p = Pattern.compile("([^\\\\]|^)\\.\\*[^\\?]?");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addDotStar();
				}
				p = Pattern.compile("([^\\\\]|^)\\.\\*\\?");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addDotStarQuestion();
				}
				p = Pattern.compile("([^\\\\]|^)\\.\\+\\?");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addDotPlusQuestion();
				}
				// p = Pattern.compile("[^\\w]");
				// m = p.matcher(regexes.get(i));
				if (!isASCII(regexes.get(i))) {
					addNotEnglishString();
				}
				// p = Pattern.compile("^\\^.+\\$$");
				p = Pattern.compile("^\\^[a-zA-Z0-9 ]+\\$$");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addExactSearch();
				}
				p = Pattern.compile("^[A-Za-z ]+$");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addJustLetters();
				}
				p = Pattern.compile("^[0-9 ]+$");
				m = p.matcher(regexes.get(i));
				if (m.find()) {
					addJustNumbers();
				}
				p = Pattern
						.compile("(\\||\\.|\\?|\\*|\\+|\\{|\\}|\\(|\\)|\\[|\\])");
				m = p.matcher(regexes.get(i));
				if (!m.find()) {
					addNoMetaChar();
				}

				setAverageLength(regexes.get(i).length());
				addMaxLength(regexes.get(i).length());
				setAverageLengthOfRegexLiteral(regexes.get(i));

			}
		}
		calculateAverageLength(getRegexesNumber());
	}

	public void printStats2() {

		System.out.println("All stats:");
		System.out.println("Ingenuen Queries" + "\t" + "Just *" + "\t"
				+ "Just +" + "\t" + "Start-With" + "\t" + "End-With" + "\t"
				+ "Negation" + "\t" + ".*" + "\t" + ".+" + "\t" + ".+?" + "\t"
				+ ".*?" + "\t" + "URL" + "\t"
				+ "Average Length of entire regex" + "\t" + "Max Length");
		System.out.println(getIngenuen() + "\t" + getJustStar() + "\t"
				+ getJustPlus() + "\t" + getStartWith() + "\t" + getEndWith()
				+ "\t" + getNegation() + "\t" + getDotStar() + "\t"
				+ getDotPlus() + "\t" + getDotPlusQuestion() + "\t"
				+ getDotStarQuestion() + "\t" + getUrl() + "\t"
				+ getAverageLength() + "\t" + getMaxLength());

	}

	public static boolean isASCII(String s) {
		boolean ret = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 128) {
				ret = false;
				break;
			}
		}
		return ret;
	}

	public void printStats(int numberOfLines, int IngenuneQueriesDecoding,
			int IngenuneQueriesSyntax) {

		System.out.println("All stats:");
		System.out.println("Number of lines being processed is:\t"
				+ numberOfLines);
		System.out.println("Number of ingenune Queries while Decoding:\t"
				+ IngenuneQueriesDecoding);
		System.out.println("Number of ingenune Queries in Syntax:\t"
				+ IngenuneQueriesSyntax);
		System.out.println("Number of overall regexes is:\t"
				+ getRegexesNumber());
		System.out.println("=======================================");
		System.out.println("Ingenuen Regexes:" + "\t" + getIngenuen());
		System.out.println("Just *:" + "\t" + getJustStar());
		System.out.println("Just +:" + "\t" + getJustPlus());
		System.out.println(".+:" + "\t" + getDotPlus());
		System.out.println(".*:" + "\t" + getDotStar());
		System.out.println(".+?:" + "\t" + getDotPlusQuestion());
		System.out.println(".*?:" + "\t" + getDotStarQuestion());
		System.out.println("Start-With:" + "\t" + getStartWith());
		System.out.println("End-With:" + "\t" + getEndWith());
		System.out.println("Average Length of entire regex:" + "\t"
				+ getAverageLength());
		System.out.println("Average Length of regex literal:" + "\t"
				+ getAverageLengthOfRegexLiteral());
		System.out.println("Max Length:" + "\t" + getMaxLength());
		System.out.println("Negation:" + "\t" + getNegation());
		System.out.println("URL:" + "\t" + getUrl());
		System.out
				.println("Not English String:" + "\t" + getNotEnglishString());
		System.out.println("Exact Search:" + "\t" + getExactSearch());
		System.out.println("Just Letters:" + "\t" + getJustLetters());
		System.out.println("Just Numbers:" + "\t" + getJustNumbers());
		System.out.println("No meta char:" + "\t" + getNoMetaChar());
		System.out.println("Alternation:" + "\t" + getAlternation());
		System.out.println("Restricted Quantifiers:" + "\t"
				+ getRestrictedQuantifiers());
		System.out.println("grouping:" + "\t" + getGrouping());
		System.out.println("Character Class:" + "\t" + getCharacterClass());
		System.out.println("Back-ref:" + "\t" + getBackref());
		System.out.println("Quantifers:" + "\t" + getQantifiers());
		System.out.println("Reluctant Quantifers:" + "\t"
				+ getReluctantQuantifiers());

	}

	public void printStatsToFile(String dir, int numberOfLines,
			ArrayList<String> IngenuneQueriesDecoding,
			ArrayList<String> IngenuneQueriesSyntax) {

		int sumOfIngenuneQueries = IngenuneQueriesDecoding.size()
				+ IngenuneQueriesSyntax.size();
		String StatsDir = dir + "/Result/Stats.txt";
		File StatsOut = new File(StatsDir);
		try {
			StatsOut.createNewFile();
			System.out.println("Writing the Stats file to: " + dir);
			FileWriter fw = new FileWriter(StatsOut.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write("All stats:");
			bw.newLine();
			bw.write("Number of overall regexes is:\t" + getRegexesNumber());
			bw.newLine();
			bw.write("Number of lines being processed is:\t" + numberOfLines);
			bw.newLine();
			bw.write("Number of ingenune Queries:\t" + sumOfIngenuneQueries);
			bw.newLine();
			bw.write("=======================================");
			bw.newLine();
			bw.write("Ingenuen Regexes:" + "\t" + getIngenuen());
			bw.newLine();
			bw.write("Just *:" + "\t" + getJustStar());
			bw.newLine();
			bw.write("Just +:" + "\t" + getJustPlus());
			bw.newLine();
			bw.write(".+:" + "\t" + getDotPlus());
			bw.newLine();
			bw.write(".*:" + "\t" + getDotStar());
			bw.newLine();
			bw.write(".+?:" + "\t" + getDotPlusQuestion());
			bw.newLine();
			bw.write(".*?:" + "\t" + getDotStarQuestion());
			bw.newLine();
			bw.write("Start-With:" + "\t" + getStartWith());
			bw.newLine();
			bw.write("End-With:" + "\t" + getEndWith());
			bw.newLine();
			bw.write("Average Length of entire regex:" + "\t"
					+ getAverageLength());
			bw.newLine();
			bw.write("Average Length of regex literal:" + "\t"
					+ getAverageLengthOfRegexLiteral());
			bw.newLine();
			bw.write("Max Length:" + "\t" + getMaxLength());
			bw.newLine();
			bw.write("Negation:" + "\t" + getNegation());
			bw.newLine();
			bw.write("URL:" + "\t" + getUrl());
			bw.newLine();
			bw.write("flag:" + "\t" + getFlag());
			bw.newLine();
			bw.write("Not English String:" + "\t" + getNotEnglishString());
			bw.newLine();
			bw.write("Exact Search:" + "\t" + getExactSearch());
			bw.newLine();
			bw.write("Just Letters:" + "\t" + getJustLetters());
			bw.newLine();
			bw.write("Just Numbers:" + "\t" + getJustNumbers());
			bw.newLine();
			bw.write("No meta char:" + "\t" + getNoMetaChar());
			bw.newLine();
			bw.write("Alternation:" + "\t" + getAlternation());
			bw.newLine();
			bw.write("Restricted Quantifiers:" + "\t"
					+ getRestrictedQuantifiers());
			bw.newLine();
			bw.write("grouping:" + "\t" + getGrouping());
			bw.newLine();
			bw.write("Character Class:" + "\t" + getCharacterClass());
			bw.newLine();
			bw.write("Back-ref:" + "\t" + getBackref());
			bw.newLine();
			bw.write("Quantifers:" + "\t" + getQantifiers());
			bw.newLine();
			bw.write("Reluctant Quantifers:" + "\t" + getReluctantQuantifiers());
			bw.newLine();

			bw.write("=======================================");

			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String IngenuneQueriesDecodingDir = dir
				+ "/Result/IngenuneQueriesDecoding.txt";
		File IngenuneQueriesDecodingOut = new File(IngenuneQueriesDecodingDir);
		try {
			IngenuneQueriesDecodingOut.createNewFile();
			FileWriter fw = new FileWriter(
					IngenuneQueriesDecodingOut.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (String string : IngenuneQueriesDecoding) {
				bw.write(string);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String IngenuneQueriesSyntaxDir = dir
				+ "/Result/IngenuneQueriesSyntax.txt";
		File IngenuneQueriesSyntaxOut = new File(IngenuneQueriesSyntaxDir);
		try {
			IngenuneQueriesSyntaxOut.createNewFile();
			FileWriter fw = new FileWriter(
					IngenuneQueriesSyntaxOut.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for (String string : IngenuneQueriesSyntax) {
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

}
