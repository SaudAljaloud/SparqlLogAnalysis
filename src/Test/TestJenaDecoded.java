package Test;

import java.util.ArrayList;

import Model.Query;
import Model.Regex;

/**
 * Auther: saudaljaloud Email: sza1g10@ecs.soton.ac.uk
 */
public class TestJenaDecoded {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Regex regex = new Regex();

		String q = ""
				+ "PREFIX owl: <http://dbpedia.org/ontology/>\n"
				+ "SELECT ?coverartVar\n"
				+ "WHERE {\n"
				+ "?subject dbpedia2:name ?name .\n"
				+ "?subject dbpedia2:artist ?artist .\n"
				+ "?artist dbpedia2:name \"Hollies\"@en .\n"
				+ "?subject rdf:type <http://dbpedia.org/ontology/Album> .\n"
				+ "?subject dbpedia2:cover ?coverartVar .FILTER (regex(str(?name), \"fvdfgs sdv\", \"i\"))}Limit 10\n"
				+ "";
		
		String q2 = "SELECT DISTINCT ?s ?o WHERE { \n" + 
				"	?s  <http://www.w3.org/2000/01/rdf-schema#label> ?o . \n" + 
				"	?o <bif:contains> 'Einstein and \"Alber*\"'.\n" + 
				"	FILTER ( (regex(str(?o), '^Einstein', 'i'))  || (regex(str(?o), '^Alber', 'i'))  ). \n" + 
				"	FILTER (!regex(str(?s), '^http://dbpedia.org/resource/Category:')). \n" + 
				"	FILTER (!regex(str(?s), '^http://dbpedia.org/resource/List')).\n" + 
				"	FILTER (!regex(str(?s), '^http://sw.opencyc.org/')). \n" + 
				"	FILTER (lang(?o) = 'en').  \n" + 
				" }\n" + 
				"Limit 10";
		
		String q3 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
				"PREFIX dbpedia2: <http://dbpedia.org/property/>\n" + 
				"PREFIX owl: <http://dbpedia.org/ontology/>\n" + 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + 
				"SELECT DISTINCT ?name ,?coverartVar\n" + 
				"WHERE {\n" + 
				"?subject dbpedia2:name ?name .\n" + 
				"?subject rdfs:label ?label .\n" + 
				"{ ?subject dbpedia2:artist ?artist } UNION { ?subject owl:artist ?artist }\n" + 
				"{ ?artist rdfs:label \"Rihanna\"@en } UNION { ?artist dbpedia2:name \"Rihanna\"@en }\n" + 
				"?subject rdf:type <http://dbpedia.org/ontology/Album>\n" + 
				"OPTIONAL {?subject dbpedia2:cover ?coverartVar .}FILTER (regex(str(?name), \"Street Hitz 45\"@en, \"i\") || (regex(str(?label), \"Street Hitz 45\"@en, \"i\")))\n" + 
				"}Limit 10";

		Query query = new Query(q3, false);
		query.jena(query.getQueryString());
//		System.out.println(query.getQueryString());
		if (!query.isIngenuneQuerySyntax()) {
			regex.addRegexes(query.regex);
			regex.addFlag(query.getFlag());
			ArrayList<String> a1 = regex.getRegexes();
			System.out.println("========================");
			System.out.println(query.getQueryString());
			System.out.println("========================");
			for (String string : a1) {
				System.out.println("Regex: " + string);
			}
		} else {
			System.out.println(query.getIngenuneQuerySyntax());
		}

	}

}
