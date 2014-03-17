package Main.Java.saud.sparqlLogging.test;

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
		
		String q3 = "PREFIX dbo: <http://dbpedia.org/ontology/>\n" + 
				"\n" + 
				"PREFIX dbp: <http://dbpedia.org/property/>\n" + 
				"\n" + 
				"PREFIX res: <http://dbpedia.org/resource/>\n" + 
				"\n" + 
				"PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
				"\n" + 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + 
				"\n" + 
				"SELECT COUNT as ?uri \n" + 
				"\n" + 
				"WHERE {\n" + 
				"\n" + 
				"        ?uri rdf:type dbo:Person .\n" + 
				"\n" + 
				"        { ?uri rdf:type yago:PresidentsOfTheUnitedStates. }\n" + 
				"\n" + 
				"        UNION\n" + 
				"\n" + 
				"        { ?uri rdf:type dbo:President.\n" + 
				"\n" + 
				"          ?uri dbp:title res:President_of_the_United_States. }\n" + 
				"\n" + 
				"        ?uri rdfs:label ?string. \n" + 
				"\n" + 
				"        FILTER (lang(?string) = 'en' && !regex(?string,'Presidency count','i') && !regex(?string,'and the')) .\n" + 
				"\n" + 
				"}";
		String q2 = q3.replaceAll("(?i)count\\((.*?)\\)|as|(?i)count", "");

		String q4 = "ORDER BY ?r%HTTP/1.1";
		String q5 = q4.replaceAll("(%.?)?HTTP/1..", "");
		
		System.out.println(q5);

	}

}
