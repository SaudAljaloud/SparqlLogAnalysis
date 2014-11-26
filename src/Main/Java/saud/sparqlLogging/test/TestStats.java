package Main.Java.saud.sparqlLogging.test;

import java.util.ArrayList;

import Main.Java.saud.sparqlLogging.model.Stats;

/**
 * User: Saud Aljaloud email: sza1g10@ecs.soton.ac.uk
 */

public class TestStats {

	public static void main(String[] args) {

		ArrayList<String> regexes = new ArrayList<>();

		regexes.add("^java");
		regexes.add("saud aljaloud");
		regexes.add("234234.34");
		regexes.add("sdfsdfsd$f");
		regexes.add("[^gsfg]");
		regexes.add(".*sdfsdfsf.*");
		regexes.add(".+?saud");
		regexes.add("^java$");
		regexes.add("[]");
		regexes.add("");
		regexes.add("*yago");
		regexes.add("^http://www.this.is.a.url");
		regexes.add("^www.saud.com");
		regexes.add("+sasa");
		regexes.add("^dffffdf$");
		regexes.add("^fghhhdgh");
		regexes.add("^fghfghfgh");
		regexes.add("\"\"");
		regexes.add("\"^*\"");

		Stats s1 = new Stats(regexes, 0);
		s1.printStats(regexes.size(), 0, 0);

	}
}
