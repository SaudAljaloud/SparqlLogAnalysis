package main.java.saud.sparqlLogging.test;

import java.util.ArrayList;

import main.java.saud.sparqlLogging.model.Query;
import main.java.saud.sparqlLogging.model.Regex;


/**
Auther: saudaljaloud
Email: sza1g10@ecs.soton.ac.uk
 */
public class TestJena {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Regex regex = new Regex();

		String q = "./2012-07-26.log:90d0dc66ba0505ef9733b876edc30915 - - [26/Jul/2012 04:00:00 +0200] \"/sparql?format=XML&default-graph-uri=http%3A%2F%2Fdbpedia.org&query=PREFIX+rdf%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%0APREFIX+dbpedia2%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2F%3E%0APREFIX+owl%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E%0ASELECT+%3FcoverartVar%0AWHERE+%7B%0A%3Fsubject+dbpedia2%3Aname+%3Fname+.%0A%3Fsubject+dbpedia2%3Aartist+%3Fartist+.%0A%3Fartist+dbpedia2%3Aname+%22Various%22%40en+.%0A%3Fsubject+rdf%3Atype+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2FAlbum%3E+.%0A%3Fsubject+dbpedia2%3Acover+%3FcoverartVar+.FILTER+%28regex%28str%28%3Fname%29%2C+%22Retro%3AActive+-+Rare+%26+Remixed%22%40en%2C+%22i%22%29%29%7DLimit+10\" 200 512 \"-\" \"bliss\"\n" + 
				"";
		String q2 = "e0fb027e80350190acb1e591d555a525 - - [27/Jul/2012 00:00:00 +0200] \"/sparql?query=PREFIX++%3A+++++%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F%3E%0APREFIX++dc%3A+++%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Felements%2F1.1%2F%3E%0APREFIX++dbpedia2%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2F%3E%0APREFIX++dbpedia-owl%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E%0APREFIX++foaf%3A+%3Chttp%3A%2F%2Fxmlns.com%2Ffoaf%2F0.1%2F%3E%0APREFIX++yago%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fclass%2Fyago%2F%3E%0APREFIX++dcterms%3A+%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fterms%2F%3E%0APREFIX++schema%3A+%3Chttp%3A%2F%2Fschema.org%2F%3E%0APREFIX++rdfs%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%0APREFIX++category%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FCategory%3A%3E%0APREFIX++umbel%3A+%3Chttp%3A%2F%2Fumbel.org%2Fumbel%2Frc%2F%3E%0APREFIX++dbpedia%3A+%3Chttp%3A%2F%2Fdbpedia.org%2F%3E%0APREFIX++xsd%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3E%0APREFIX++owl%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3E%0APREFIX++rdf%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%0APREFIX++skos%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E%0A%0ASELECT+DISTINCT++%3Fsubject%0AWHERE%0A++%7B+%3ARichard_Strauss+dcterms%3Asubject+%3Fsubject+%7D%0A\" 200 3072 \"-\" \"Java\"\n" + 
				"";
		String q3 = "6efc2decec4c9ddc93de28ddbd5073c9 - - [27/Jul/2012 00:00:00 +0200] \"/sparql?query=PREFIX++%3A+++++%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F%3E%0APREFIX++dc%3A+++%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Felements%2F1.1%2F%3E%0APREFIX++dbpedia-owl%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E%0APREFIX++geo%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2003%2F01%2Fgeo%2Fwgs84_pos%23%3E%0APREFIX++foaf%3A+%3Chttp%3A%2F%2Fxmlns.com%2Ffoaf%2F0.1%2F%3E%0APREFIX++dbpedia-prop%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2F%3E%0APREFIX++yago%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fclass%2Fyago%2F%3E%0APREFIX++rdfs%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%0APREFIX++umbel-sc%3A+%3Chttp%3A%2F%2Fumbel.org%2Fumbel%2Fsc%2F%3E%0APREFIX++dbpedia%3A+%3Chttp%3A%2F%2Fdbpedia.org%2F%3E%0APREFIX++xsd%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3E%0APREFIX++owl%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3E%0APREFIX++rdf%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%0APREFIX++skos%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E%0A%0ASELECT+DISTINCT++%3Fcompany+%3Fwebaddress+%3Flabel+%3FcompanyName+%3Fsymbol+%3FsameAsUri+%3FlinkUrl%0AWHERE%0A++%7B+%7B+++%7B+%3AAmvescap_PLC%0A++++++++++++++++++++dbpedia-prop%3Aredirect++%3Fcompany+.%0A++++++++%7D%0A++++++UNION%0A++++++++%7B+%3AInvesco_Plc++dbpedia-prop%3Aredirect++%3Fcompany+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++dbpedia-prop%3Ahomepage++%3Chttp%3A%2F%2Fwww.invesco.com%3E+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++dbpedia-prop%3Ahomepage++%3Chttp%3A%2F%2Fwww.invesco.com%2F%3E+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++dbpedia-prop%3Asymbol++%22IVZIH%22+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++rdfs%3Alabel++%22Invesco+Plc%22%40en+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++rdfs%3Alabel++%22Amvescap+PLC%22%40en+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++rdfs%3Alabel++%22Amvescap+PLC%22%40en+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++dbpedia-prop%3Aname++%22Invesco+Plc%22%40en+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++dbpedia-prop%3AcompanyName++%22Invesco+Plc%22%40en+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++foaf%3Aname++%22Invesco+Plc%22+.%7D%0A++++%7D%0A++++%7B+%3Fcompany++rdf%3Atype++%3Ftype+.%0A++++++FILTER+regex%28%3Ftype%2C+%22.%2B%2F%28%28Company%29%7C%28Business%29%7C%28Company.*%29%7C%28CompaniesBasedIn.*%29%7C%28.*CompaniesOf.*%29%29%24%22%2C+%22i%22%29%0A++++%7D%0A++++%7B+%3Fcompany++rdfs%3Alabel++%3Flabel+.%0A++++++FILTER+%28+lang%28%3Flabel%29+%3D+%22en%22+%29%0A++++%7D%0A++++OPTIONAL%0A++++++%7B+++%7B+%3Fcompany++dbpedia-prop%3Ahomepage++%3Fwebaddress+.%7D%0A++++++++UNION%0A++++++++++%7B+%3Fcompany++dbpedia-prop%3AcompanyName++%3FcompanyName+.%7D%0A++++++++UNION%0A++++++++++%7B+%3Fcompany++dbpedia-prop%3Asymbol++%3Fsymbol+.%7D%0A++++++++UNION%0A++++++++++%7B+%3Fcompany++owl%3AsameAs++%3FsameAsUri+.%7D%0A++++++++UNION%0A++++++++++%7B+%3Fcompany++foaf%3Apage++%3FlinkUrl+.%7D%0A++++++%7D%0A++%7D%0A\" 200 2560 \"-\" \"Java\"\n" + 
				"";
		String q4 = "1dfa92f5728708ea2d33a35c40f32477 - - [27/Jul/2012 00:00:00 +0200] \"/sparql?query=prefix+owl%3a+%3chttp%3a%2f%2fwww.w3.org%2f2002%2f07%2fowl%23%3e+select+*+where+%7b+%3chttp%3a%2f%2fdbpedia.org%2fresource%2fHoliday_Inn%3e+rdfs%3Alabel+%3flabel+FILTER+(lang(%3flabel)+%3d%22it%22)+.+optional%7b%3chttp%3a%2f%2fdbpedia.org%2fresource%2fHoliday_Inn%3e+owl%3asameAs+%3ffreebaseMid+FILTER+(regex(%3ffreebaseMid%2c+%22freebase%22%2c%22i%22))%7d+.+++%7d&default-graph-uri=http%3A%2F%2Fdbpedia.org\" 200 512 \"-\" \"-\"\n" + 
				"";
		Query query = new Query(q4);
		if (!query.isIngenuneQueryDecoding()) {
			query.jena(query.getQueryString());
			if (!query.isIngenuneQuerySyntax()) {
				regex.addRegexes(query.regex);
				regex.addFlag(query.getFlag());
				System.out.println(query.getQueryString());
			}
			else{
				System.out.println(query.getIngenuneQuerySyntax());
			}

		} else {
			System.out.println(query.getIngenuneQueryDecoding());
		}

	}

}
