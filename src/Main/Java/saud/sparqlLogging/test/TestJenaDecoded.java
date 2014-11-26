package Main.Java.saud.sparqlLogging.test;

import java.util.ArrayList;

import Main.Java.saud.sparqlLogging.model.Query;
import Main.Java.saud.sparqlLogging.model.Regex;

/**
 * User: Saud Aljaloud email: sza1g10@ecs.soton.ac.uk
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

		String q2 = "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX bpOntologies: <http://bioportal.bioontology.org/ontologies/>\n"
				+ "\n"
				+ "        \n"
				+ "        SELECT DISTINCT ?s ?label\n"
				+ "        \n"
				+ "        FROM <http://bioportal.bioontology.org/ontologies/SMD_NPLSM>\n"
				+ "        FROM bpOntologies:globals\n"
				+ "        \n"
				+ "        WHERE {\n"
				+ "		    	\n"
				+ "	    	 GRAPH <http://bioportal.bioontology.org/ontologies/SMD_NPLSM> {\n"
				+ "	    	 	?s a owl:Class .\n"
				+ "	    	 }\n"
				+ "	         \n"
				+ "	         ?s rdfs:label ?label .\n"
				+ "                         \n"
				+ "       	}\n"
				+ "       	\n"
				+ "        LIMIT  51\n"
				+ "	    OFFSET 0\n"
				+ "        \n"
				+ "	\n"
				+ "#### execution time for Q12826-pid6902: 3.290919s, returned 51 rows.";

		String q3 = "# timestamp: 2011-02-14T12:34:41\nPREFIX xs: <http://www.w3.org/2001/XMLSchema#>PREFIX : <http://purl.org/NET/flyatlas/schema#> PREFIX fb: <http://purl.org/net/open-biomed/id/flybase/feature/Drosophila_melanogaster/SO_0000704/> SELECT distinct *WHERE { {{?affy_id :gene fb:FBgn0036925 . }union {?affy_id :gene fb:FBgn0000042 . }union {?affy_id :gene fb:FBgn0000055 . }union {?affy_id :gene fb:FBgn0001197 . }union {?affy_id :gene fb:FBgn0002865 . }union {?affy_id :gene fb:FBgn0028902 . }union {?affy_id :gene fb:FBgn0003889 . }union {?affy_id :gene fb:FBgn0004828 . }union {?affy_id :gene fb:FBgn0011224 . }union {?affy_id :gene fb:FBgn0011227 . }union {?affy_id :gene fb:FBgn0011270 . }union {?affy_id :gene fb:FBgn0052445 . }}{?affy_id   :gene ?gene ;   a :ProbeData ;   :fly_present ?whole_present ;   :fly_mean ?whole_mean ;   :fly_sem ?whole_sem  ;  :testis_to_all ?testis_to_all ; ?tissue [     :call ?tissue_change ;     :mean ?tissue_mean ;     :sem ?tissue_sem ;     :present ?tissue_present ;     :ratio ?tissue_ratio ;     :to_testis ?tissue_testis_ratio   ]  }}";

		String query4 = "PREFIX owl: <http://www.w3.org/2002/07/owl#> "
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> "
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
				+ "PREFIX foaf: <http://xmlns.com/foaf/0.1/> "
				+ "PREFIX dc: <http://purl.org/dc/elements/1.1/> "
				+ "PREFIX : <http://dbpedia.org/resource/> "
				+ "PREFIX dbpedia2: <http://dbpedia.org/property/> "
				+ "PREFIX dbpedia: <http://dbpedia.org/> "
				+ "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"
				+ " SELECT distinct ?x "
				+ "FROM <http://dbpedia.org> "
				+ "WHERE {"
				+ " ?x rdfs:label ?y."
				+ " ?y bif:contains '\"asuminen\"' ."
				+ " FILTER (regex(?x, \"http://dbpedia.org/resource/\"))"
				+ " FILTER (!regex(?x, \"http://dbpedia.org/resource/Category:\"))"
				+ " FILTER (lang(?y)=\"fi\") " + "} " + "LIMIT 10";
		String q6 = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> PREFIX ont: <http://dbpedia.org/ontology/> PREFIX foaf: <http://xmlns.com/foaf/0.1/> PREFIX xsd:    <http://www.w3.org/2001/XMLSchema#> SELECT ?page ?place ?name ?date ?placelabel WHERE {?person ont:birthDate ?date; foaf:page ?page; ont:birthPlace ?place; foaf:name ?name . ?place rdfs:label ?placelabel .FILTER (lang(?placelabel) = \"en\") . FILTER( ( ( datatype(?date) = xsd:date ) || ( datatype(?date) = xsd:dateTime ) )  && ( regex(str(?date), \"1982-01-11\") )&& (regex(str(?place),\"Australia\") || regex(str(?place),\"Melbourne\")) ) }";
		String q7 = "SELECT DISTINCT ?s ?o WHERE { \n"
				+ "	?s  <http://www.w3.org/2000/01/rdf-schema#label> ?o . \n"
				+ "	?o bif:contains 'author and of'.\n"
				+ "	FILTER ( (regex(str(?o), '^author', 'i'))  || (regex(str(?o), '^of', 'i'))  ). \n"
				+ "	FILTER (!regex(str(?s), '^http://dbpedia.org/resource/Category:')). \n"
				+ "	FILTER (!regex(str(?s), '^http://dbpedia.org/resource/List')).\n"
				+ "	FILTER (!regex(str(?s), '^http://sw.opencyc.org/')). \n"
				+ "	FILTER (lang(?o) = 'en').  \n" + "	}\n" + "Limit 10";

		String q8 = "PREFIX  rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX  owl:  <http://www.w3.org/2002/07/owl#>\n"
				+ "\n"
				+ "SELECT DISTINCT  ?s ?label\n"
				+ "WHERE\n"
				+ "  { GRAPH <http://bioportal.bioontology.org/ontologies/ABA>\n"
				+ "      { ?s <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> owl:Class .\n"
				+ "        ?s rdfs:label ?label\n" + "      }\n"
				+ "    FILTER regex(?label, \"Nucleus\")\n" + "  }\n"
				+ "LIMIT   10";

		Query query = new Query(q8, false);
		query.jena(query.getQueryString());
		// System.out.println(query.getQueryString());
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
