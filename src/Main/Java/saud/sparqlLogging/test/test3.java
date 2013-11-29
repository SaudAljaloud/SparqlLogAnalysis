package main.java.saud.sparqlLogging.test;

import java.util.ArrayList;

/**
Auther: saudaljaloud
Email: sza1g10@ecs.soton.ac.uk
 */
public class test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String q3 = "SELECT DISTINCT ?p COUNT(?p) AS ?numOfInstances " +
				"WHERE { ?s a <http://dbpedia.org/ontology/Place> . " +
				"?c ?p ?s . FILTER regex(?p, \"ontology\") } " +
				"ORDER BY DESC(?numOfInstances) " +
				"LIMIT 10";
		String q2 = q3.replaceAll("(?i)count\\((.*?)\\)|as", "");

		System.out.println(q2);

	}

}
