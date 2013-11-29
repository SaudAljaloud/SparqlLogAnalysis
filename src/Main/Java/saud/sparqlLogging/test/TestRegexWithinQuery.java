package main.Java.saud.sparqlLogging.test;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegexWithinQuery {

	public static void main(String[] args) {
		String q1 = "PREFIX  dc:  <http://purl.org/dc/elements/1.1/>\n" + 
				"SELECT  ?title\n" + 
				"WHERE   { ?x dc:title ?title\n" + 
				"          FILTER regex(?title, \"^SPARQL\", \"i\") \n" + 
				" FILTER regex(?title, \'^SPARQL\', \'i\') " +
				"        }			";
		ArrayList<String> regexesTemb = new ArrayList<>();
		Pattern pattern = Pattern.compile("(?i)regex.*?(\"(.*?)\".*\"(.*?)|\'(.*?)\')");
		Matcher matcher = pattern.matcher(q1);
		while (matcher.find()) {
			String a1 = matcher.group(3);
			String a2 = a1.replaceAll("\"|\'", "");
			System.out.println((a2));
		}
	}
}
