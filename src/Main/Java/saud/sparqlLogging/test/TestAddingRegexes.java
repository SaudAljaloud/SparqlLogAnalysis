package main.Java.saud.sparqlLogging.test;

import java.util.ArrayList;

import main.Java.saud.sparqlLogging.model.Query;
import main.Java.saud.sparqlLogging.model.Regex;
import main.Java.saud.sparqlLogging.model.Stats;


/**
Auther: saudaljaloud
Email: sza1g10@ecs.soton.ac.uk
 */
public class TestAddingRegexes {

	/**
	 * @param args
	 */
	Regex regex = new Regex();
	private int ingenuneQueries = 0;

	public int getIngenuneQueries() {
		return ingenuneQueries;
	}

	public void addIngenuneQueries() {
		this.ingenuneQueries += 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestAddingRegexes test = new TestAddingRegexes();
		String q = "0bb60b927938ed14daaea6a7484d89cb - - [23/Jan/2011 16:00:00 +0100] \"/sparql?query=PREFIX++%3A+++++%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F%3E%0APREFIX++dc%3A+++%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Felements%2F1.1%2F%3E%0APREFIX++dbpedia-owl%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E%0APREFIX++geo%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2003%2F01%2Fgeo%2Fwgs84_pos%23%3E%0APREFIX++foaf%3A+%3Chttp%3A%2F%2Fxmlns.com%2Ffoaf%2F0.1%2F%3E%0APREFIX++dbpedia-prop%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2F%3E%0APREFIX++yago%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fclass%2Fyago%2F%3E%0APREFIX++rdfs%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%0APREFIX++umbel-sc%3A+%3Chttp%3A%2F%2Fumbel.org%2Fumbel%2Fsc%2F%3E%0APREFIX++dbpedia%3A+%3Chttp%3A%2F%2Fdbpedia.org%2F%3E%0APREFIX++xsd%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3E%0APREFIX++owl%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3E%0APREFIX++rdf%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%0APREFIX++skos%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E%0A%0ASELECT+DISTINCT++%3Fstation+%3FsameAsUri+%3FlinkUrl+%3Fair%0AWHERE%0A++%7B+++%7B+%3ACoby_Portable_AM%0A++++++++++++++++++dbpedia-prop%3Aredirect++%3Fstation+.%0A++++++%7D%0A++++UNION%0A++++++%7B+%3ACOBY_PORTABLE_AM%0A++++++++++++++++++dbpedia-prop%3Aredirect++%3Fstation+.%0A++++++%7D%0A++++UNION%0A++++++%7B+%3Fstation++rdfs%3Alabel++%22Coby+Portable+AM%22%40en+.%7D%0A++++UNION%0A++++++%7B+%3Fstation++rdfs%3Alabel++%22Coby+Portable+AM+%28radio%29%22%40en+.%7D%0A++++UNION%0A++++++%7B+%3Fstation++rdfs%3Alabel++%22Coby+Portable+AM+%28radio+station%29%22%40en+.%7D%0A++++UNION%0A++++++%7B+%3Fstation++dbpedia-prop%3Aname++%22Coby+Portable+AM%22%40en+.%7D%0A++++UNION%0A++++++%7B+%3Fstation++foaf%3Aname++%22Coby+Portable+AM%22+.%7D%0A++++UNION%0A++++++%7B+%3Fstation++rdfs%3Alabel++%22COBY+PORTABLE+AM%22%40en+.%7D%0A++++UNION%0A++++++%7B+%3Fstation++rdfs%3Alabel++%22COBY+PORTABLE+AM+%28radio+station%29%22%40en+.%7D%0A++++UNION%0A++++++%7B+%3Fstation++foaf%3Aname++%22COBY+PORTABLE+AM%22+.%7D%0A++++++%7B+%3Fstation++rdf%3Atype++dbpedia-owl%3ARadioStation+.%7D%0A++++UNION%0A++++++%7B+%3Fstation++rdf%3Atype++%3FstationType+.%0A++++++++FILTER+regex%28%3FstationType%2C+%22http%3A%2F%2Fdbpedia.org%2Fclass%2Fyago%2F.*radio.*station.*%22%2C+%22i%22%29%0A++++++%7D%0A++++UNION%0A++++++%7B+%3Fstation++skos%3Asubject++%3Fsubject+.%0A++++++++FILTER+regex%28%3Fsubject%2C+%22http%3A%2F%2Fdbpedia.org%2Fresource%2FCategory.*radio.*%22%2C+%22i%22%29%0A++++++%7D%0A++++UNION%0A++++++%7B+%3Fstation++dbpedia-prop%3AwikiPageUsesTemplate++%3Ftemplate+.%0A++++++++FILTER+regex%28%3Ftemplate%2C+%22http%3A%2F%2Fdbpedia.org%2Fresource%2FTemplate%3A%28infobox_%29%3Fradio_station%22%2C+%22i%22%29%0A++++++%7D%0A++++OPTIONAL%0A++++++%7B+++%7B+%3Fstation++owl%3AsameAs++%3FsameAsUri+.%7D%0A++++++++UNION%0A++++++++++%7B+%3Fstation++foaf%3Apage++%3FlinkUrl+.%7D%0A++++++%7D%0A++++OPTIONAL%0A++++++%7B+%3Fstation++dbpedia-prop%3Aairdate++%3Fair+.%7D%0A++%7D%0A\" 200 512 \"-\" \"Java\"\n" + 
				"";
		test.run(q);
		String q2 = "24421db916270013928f2d0fdc1433a1 - - [23/Jan/2011 09:00:00 +0100] \"/sparql?query=PREFIX++%3A+++++%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F%3E%0APREFIX++dc%3A+++%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Felements%2F1.1%2F%3E%0APREFIX++dbpedia-owl%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E%0APREFIX++geo%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2003%2F01%2Fgeo%2Fwgs84_pos%23%3E%0APREFIX++foaf%3A+%3Chttp%3A%2F%2Fxmlns.com%2Ffoaf%2F0.1%2F%3E%0APREFIX++dbpedia-prop%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2F%3E%0APREFIX++yago%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fclass%2Fyago%2F%3E%0APREFIX++rdfs%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%0APREFIX++umbel-sc%3A+%3Chttp%3A%2F%2Fumbel.org%2Fumbel%2Fsc%2F%3E%0APREFIX++dbpedia%3A+%3Chttp%3A%2F%2Fdbpedia.org%2F%3E%0APREFIX++xsd%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3E%0APREFIX++owl%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3E%0APREFIX++rdf%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%0APREFIX++skos%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E%0A%0ASELECT+DISTINCT++%3Fcur+%3FsameAsUri+%3FlinkUrl%0AWHERE%0A++%7B+++%7B+%3AUSD++dbpedia-prop%3Aredirect++%3Fcur+.%7D%0A++++UNION%0A++++++%7B+%3Fcur++dbpedia-prop%3AisoCode++%22USD%22%40en+.%7D%0A++++UNION%0A++++++%7B+%3Fcur++rdfs%3Alabel++%22USD%22%40en+.%7D%0A++++UNION%0A++++++%7B+%3Fcur++dbpedia-prop%3Aname++%22USD%22%40en+.%7D%0A++++UNION%0A++++++%7B+%3Fcur++foaf%3Aname++%22USD%22+.%7D%0A++++++%7B+%3Fcur++rdf%3Atype++dbpedia-owl%3ACurrency+.%7D%0A++++UNION%0A++++++%7B+%3Fcur++rdf%3Atype++%3FcurType+.%0A++++++++FILTER+regex%28%3FcurType%2C+%22http%3A%2F%2Fdbpedia.org%2Fclass%2Fyago%2FCurrency.*%22%2C+%22i%22%29%0A++++++%7D%0A++++UNION%0A++++++%7B+%3Fcur++dbpedia-prop%3AwikiPageUsesTemplate++%3Ftemplate+.%0A++++++++FILTER+regex%28%3Ftemplate%2C+%22http%3A%2F%2Fdbpedia.org%2Fresource%2FTemplate%3Ainfobox_currency%22%2C+%22i%22%29%0A++++++%7D%0A++++OPTIONAL%0A++++++%7B+++%7B+%3Fcur++owl%3AsameAs++%3FsameAsUri+.%7D%0A++++++++UNION%0A++++++++++%7B+%3Fcur++foaf%3Apage++%3FlinkUrl+.%7D%0A++++++%7D%0A++%7D%0A\" 200 1024 \"-\" \"Java\"\n" + 
				"";
		test.run(q2);
		test.regex.printRegexesToScreen();
		Stats st = new Stats(test.regex.getRegexes(), test.regex.getFlag());
//		st.printStats(2, test.reg);

		
	}
	public void run(String q) {

		
		Query query = new Query(q);
		if (!query.isIngenuneQueryDecoding()) {
			query.jena(query.getQueryString());
			regex.addRegexes(query.regex);
			if (query.isIngenuneQueryDecoding() == true){
				addIngenuneQueries();
			}
		}
		else{
			addIngenuneQueries();
		}
		
		

	}
	
	public void run2() {
		
		ArrayList<String> a1 = new ArrayList<>();
		ArrayList<String> a2 = new ArrayList<>();
		a1.add("saud");
		a1.add("aljaloud");
		a2.add("saud1");
		a2.add("aljaloud");
		a1.addAll(a2);
		for (String string : a1) {
			System.out.println(string);
		}

		
		
	}

}
