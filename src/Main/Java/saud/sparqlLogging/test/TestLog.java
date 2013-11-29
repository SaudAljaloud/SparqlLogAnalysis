package main.java.saud.sparqlLogging.test;

import java.util.ArrayList;

import main.java.saud.sparqlLogging.model.Query;


public class TestLog {
	
	public static void main(String[] args) {
		String log1 = "\"/sparql?query=PREFIX++%3A+++++%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F%3E%0APREFIX++dc%3A+++%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Felements%2F1.1%2F%3E%0APREFIX++dbpedia-owl%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E%0APREFIX++geo%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2003%2F01%2Fgeo%2Fwgs84_pos%23%3E%0APREFIX++foaf%3A+%3Chttp%3A%2F%2Fxmlns.com%2Ffoaf%2F0.1%2F%3E%0APREFIX++dbpedia-prop%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2F%3E%0APREFIX++yago%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fclass%2Fyago%2F%3E%0APREFIX++rdfs%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%0APREFIX++umbel-sc%3A+%3Chttp%3A%2F%2Fumbel.org%2Fumbel%2Fsc%2F%3E%0APREFIX++dbpedia%3A+%3Chttp%3A%2F%2Fdbpedia.org%2F%3E%0APREFIX++xsd%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3E%0APREFIX++owl%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3E%0APREFIX++rdf%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%0APREFIX++skos%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E%0A%0ASELECT+DISTINCT++%3Fcompany+%3Fwebaddress+%3Flabel+%3FcompanyName+%3Fsymbol+%3FsameAsUri+%3FlinkUrl%0AWHERE%0A++%7B+%7B+++%7B+%3AIBM++dbpedia-prop%3Aredirect++%3Fcompany+.%7D%0A++++++UNION%0A++++++++%7B+%3AInternational_Business_Machines_Corporation%0A++++++++++++++++++++dbpedia-prop%3Aredirect++%3Fcompany+.%0A++++++++%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++dbpedia-prop%3Ahomepage++%3Chttp%3A%2F%2Fwww.ibm.com%3E+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++dbpedia-prop%3Ahomepage++%3Chttp%3A%2F%2Fwww.ibm.com%2F%3E+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++dbpedia-prop%3Asymbol++%22IBM%22+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++rdfs%3Alabel++%22International+Business+Machines+Corporation%22%40en+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++rdfs%3Alabel++%22IBM%22%40en+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++rdfs%3Alabel++%22Ibm%22%40en+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++dbpedia-prop%3Aname++%22International+Business+Machines+Corporation%22%40en+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++dbpedia-prop%3AcompanyName++%22International+Business+Machines+Corporation%22%40en+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++foaf%3Aname++%22International+Business+Machines+Corporation%22+.%7D%0A++++%7D%0A++++%7B+%3Fcompany++rdf%3Atype++%3Ftype+.%0A++++++FILTER+regex%28%3Ftype%2C+%22.%2B%2F%28%28Company%29%7C%28Business%29%7C%28Company.*%29%7C%28CompaniesBasedIn.*%29%7C%28.*CompaniesOf.*%29%29%24%22%2C+%22i%22%29%0A++++%7D%0A++++%7B+%3Fcompany++rdfs%3Alabel++%3Flabel+.%0A++++++FILTER+%28+lang%28%3Flabel%29+%3D+%22en%22+%29%0A++++%7D%0A++++OPTIONAL%0A++++++%7B+++%7B+%3Fcompany++dbpedia-prop%3Ahomepage++%3Fwebaddress+.%7D%0A++++++++UNION%0A++++++++++%7B+%3Fcompany++dbpedia-prop%3AcompanyName++%3FcompanyName+.%7D%0A++++++++UNION%0A++++++++++%7B+%3Fcompany++dbpedia-prop%3Asymbol++%3Fsymbol+.%7D%0A++++++++UNION%0A++++++++++%7B+%3Fcompany++owl%3AsameAs++%3FsameAsUri+.%7D%0A++++++++UNION%0A++++++++++%7B+%3Fcompany++foaf%3Apage++%3FlinkUrl+.%7D%0A++++++%7D%0A++%7D%0A\"\n" + 
				"";		
////		Query q1 = new Query(log1.replaceAll("%.?HTTP/1..", ""));
////		ArrayList<String> a1 = q1.extractRegexes();
////		for (int i = 0; i < a1.size(); i++) {
////			System.out.println(a1.get(i));
////		}
//		
//		
//		String a1 = "/sparql?query=PREFIX++%3A+++";
//		String a2 = a1.replaceFirst(".*\\?query=", "");
//		String log2 = log1.rep
//		System.out.println(a2);
		
	}

}
