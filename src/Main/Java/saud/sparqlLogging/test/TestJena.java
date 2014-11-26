package Main.Java.saud.sparqlLogging.test;

import java.util.ArrayList;

import Main.Java.saud.sparqlLogging.model.Query;
import Main.Java.saud.sparqlLogging.model.Regex;

/**
 * User: Saud Aljaloud email: sza1g10@ecs.soton.ac.uk
 */

public class TestJena {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Regex regex = new Regex();

		String q = "./2012-07-26.log:90d0dc66ba0505ef9733b876edc30915 - - [26/Jul/2012 04:00:00 +0200] \"/sparql?format=XML&default-graph-uri=http%3A%2F%2Fdbpedia.org&query=PREFIX+rdf%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%0APREFIX+dbpedia2%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2F%3E%0APREFIX+owl%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E%0ASELECT+%3FcoverartVar%0AWHERE+%7B%0A%3Fsubject+dbpedia2%3Aname+%3Fname+.%0A%3Fsubject+dbpedia2%3Aartist+%3Fartist+.%0A%3Fartist+dbpedia2%3Aname+%22Various%22%40en+.%0A%3Fsubject+rdf%3Atype+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2FAlbum%3E+.%0A%3Fsubject+dbpedia2%3Acover+%3FcoverartVar+.FILTER+%28regex%28str%28%3Fname%29%2C+%22Retro%3AActive+-+Rare+%26+Remixed%22%40en%2C+%22i%22%29%29%7DLimit+10\" 200 512 \"-\" \"bliss\"\n"
				+ "";
		String q2 = "e0fb027e80350190acb1e591d555a525 - - [27/Jul/2012 00:00:00 +0200] \"/sparql?query=PREFIX++%3A+++++%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F%3E%0APREFIX++dc%3A+++%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Felements%2F1.1%2F%3E%0APREFIX++dbpedia2%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2F%3E%0APREFIX++dbpedia-owl%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E%0APREFIX++foaf%3A+%3Chttp%3A%2F%2Fxmlns.com%2Ffoaf%2F0.1%2F%3E%0APREFIX++yago%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fclass%2Fyago%2F%3E%0APREFIX++dcterms%3A+%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Fterms%2F%3E%0APREFIX++schema%3A+%3Chttp%3A%2F%2Fschema.org%2F%3E%0APREFIX++rdfs%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%0APREFIX++category%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FCategory%3A%3E%0APREFIX++umbel%3A+%3Chttp%3A%2F%2Fumbel.org%2Fumbel%2Frc%2F%3E%0APREFIX++dbpedia%3A+%3Chttp%3A%2F%2Fdbpedia.org%2F%3E%0APREFIX++xsd%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3E%0APREFIX++owl%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3E%0APREFIX++rdf%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%0APREFIX++skos%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E%0A%0ASELECT+DISTINCT++%3Fsubject%0AWHERE%0A++%7B+%3ARichard_Strauss+dcterms%3Asubject+%3Fsubject+%7D%0A\" 200 3072 \"-\" \"Java\"\n"
				+ "";
		String q3 = "6efc2decec4c9ddc93de28ddbd5073c9 - - [27/Jul/2012 00:00:00 +0200] \"/sparql?query=PREFIX++%3A+++++%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F%3E%0APREFIX++dc%3A+++%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Felements%2F1.1%2F%3E%0APREFIX++dbpedia-owl%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E%0APREFIX++geo%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2003%2F01%2Fgeo%2Fwgs84_pos%23%3E%0APREFIX++foaf%3A+%3Chttp%3A%2F%2Fxmlns.com%2Ffoaf%2F0.1%2F%3E%0APREFIX++dbpedia-prop%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2F%3E%0APREFIX++yago%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fclass%2Fyago%2F%3E%0APREFIX++rdfs%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%0APREFIX++umbel-sc%3A+%3Chttp%3A%2F%2Fumbel.org%2Fumbel%2Fsc%2F%3E%0APREFIX++dbpedia%3A+%3Chttp%3A%2F%2Fdbpedia.org%2F%3E%0APREFIX++xsd%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3E%0APREFIX++owl%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3E%0APREFIX++rdf%3A++%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%0APREFIX++skos%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E%0A%0ASELECT+DISTINCT++%3Fcompany+%3Fwebaddress+%3Flabel+%3FcompanyName+%3Fsymbol+%3FsameAsUri+%3FlinkUrl%0AWHERE%0A++%7B+%7B+++%7B+%3AAmvescap_PLC%0A++++++++++++++++++++dbpedia-prop%3Aredirect++%3Fcompany+.%0A++++++++%7D%0A++++++UNION%0A++++++++%7B+%3AInvesco_Plc++dbpedia-prop%3Aredirect++%3Fcompany+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++dbpedia-prop%3Ahomepage++%3Chttp%3A%2F%2Fwww.invesco.com%3E+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++dbpedia-prop%3Ahomepage++%3Chttp%3A%2F%2Fwww.invesco.com%2F%3E+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++dbpedia-prop%3Asymbol++%22IVZIH%22+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++rdfs%3Alabel++%22Invesco+Plc%22%40en+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++rdfs%3Alabel++%22Amvescap+PLC%22%40en+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++rdfs%3Alabel++%22Amvescap+PLC%22%40en+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++dbpedia-prop%3Aname++%22Invesco+Plc%22%40en+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++dbpedia-prop%3AcompanyName++%22Invesco+Plc%22%40en+.%7D%0A++++++UNION%0A++++++++%7B+%3Fcompany++foaf%3Aname++%22Invesco+Plc%22+.%7D%0A++++%7D%0A++++%7B+%3Fcompany++rdf%3Atype++%3Ftype+.%0A++++++FILTER+regex%28%3Ftype%2C+%22.%2B%2F%28%28Company%29%7C%28Business%29%7C%28Company.*%29%7C%28CompaniesBasedIn.*%29%7C%28.*CompaniesOf.*%29%29%24%22%2C+%22i%22%29%0A++++%7D%0A++++%7B+%3Fcompany++rdfs%3Alabel++%3Flabel+.%0A++++++FILTER+%28+lang%28%3Flabel%29+%3D+%22en%22+%29%0A++++%7D%0A++++OPTIONAL%0A++++++%7B+++%7B+%3Fcompany++dbpedia-prop%3Ahomepage++%3Fwebaddress+.%7D%0A++++++++UNION%0A++++++++++%7B+%3Fcompany++dbpedia-prop%3AcompanyName++%3FcompanyName+.%7D%0A++++++++UNION%0A++++++++++%7B+%3Fcompany++dbpedia-prop%3Asymbol++%3Fsymbol+.%7D%0A++++++++UNION%0A++++++++++%7B+%3Fcompany++owl%3AsameAs++%3FsameAsUri+.%7D%0A++++++++UNION%0A++++++++++%7B+%3Fcompany++foaf%3Apage++%3FlinkUrl+.%7D%0A++++++%7D%0A++%7D%0A\" 200 2560 \"-\" \"Java\"\n"
				+ "";
		String q4 = "1dfa92f5728708ea2d33a35c40f32477 - - [27/Jul/2012 00:00:00 +0200] \"/sparql?query=prefix+owl%3a+%3chttp%3a%2f%2fwww.w3.org%2f2002%2f07%2fowl%23%3e+select+*+where+%7b+%3chttp%3a%2f%2fdbpedia.org%2fresource%2fHoliday_Inn%3e+rdfs%3Alabel+%3flabel+FILTER+(lang(%3flabel)+%3d%22it%22)+.+optional%7b%3chttp%3a%2f%2fdbpedia.org%2fresource%2fHoliday_Inn%3e+owl%3asameAs+%3ffreebaseMid+FILTER+(regex(%3ffreebaseMid%2c+%22freebase%22%2c%22i%22))%7d+.+++%7d&default-graph-uri=http%3A%2F%2Fdbpedia.org\" 200 512 \"-\" \"-\"\n"
				+ "";
		String q5 = "./http02102013.log:682f38e0c47fbae8d569d5c6d02aef18 - - [02/Oct/2013 00:00:00 +0300] \"GET /sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=prefix+dbpr%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F%3E%0D%0Aprefix+dbpo%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E%0D%0Aprefix+dbpp%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2F%3E%0D%0A%0D%0ASELECT+%3Fname+%3Fcountry+%3Fpopulation%0D%0A%09WHERE+%7B%0D%0A%09%3Fcity+dbpo%3Acountry+%3Fc+.%0D%0A%09%3Fc+dbpo%3AlongName+%3Fname+.%0D%0A%09%3Fc+dbpo%3Aabstract+%3Fcountry+.%0D%0A%09%3Fc+dbpp%3ApopulationEstimate+%3Fpopulation+.%0D%0A%09%0D%0AFILTER+%28regex+%28str%28%3Fcity%29%2C+%22amsterdam%22%2C+%22i%22%29+%26%26+langMatches%28lang%28%3Fprovince%29%2C+%27nl%27%29%29%0D%0A%0D%0A%7D&format=text%2Fhtml&timeout=30000&debug=on HTTP/1.1\" 200 0 \"-\" \"R\" \"-\"\n"
				+ "";
		String q6 = "0.0.3.239 - - [02/Oct/2012:13:43:48 +0200] \"GET /sparql?query=SELECT++%3Fsub%0AWHERE%0A++%7B+%3Fsub+%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23type%3E+%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23Class%3E%0A++++FILTER+regex%28str%28%3Fsub%29%2C+%22%5Ehttp%3A%2F%2Flinkedgeodata.org%2Fontology%2F%22%29%0A++%7D%0ALIMIT+++50000%0A HTTP/1.1\" 200 112104 \"-\" \"Java/1.6.0_24\"\n"
				+ "";

		String q7 = "675868 0.0.0.0 - - [18/Dec/2009:11:34:20 -0800] \"GET /sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&should-sponge=&query=prefix+rdfs%3A+%3Chttp%3A%2F%2Fww        w.w3.org%2F2000%2F01%2Frdf-schema%23%3E%0D%0APREFIX+rdf%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%0D%0APREFIX+foaf%3A+%3Chttp%        3A%2F%2Fxmlns.com%2Ffoaf%2F0.1%2F%3E+%0D%0APREFIX+dbpedia%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F%3E%0D%0APREFIX+dbpprop%3A+%3Chttp%3A%2F%2Fdbpedi        a.org%2Fproperty%2F%3E%0D%0APREFIX+dbpedia-owl%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2F%3E%0D%0Aprefix+owl%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F0        7%2Fowl%23%3E%0D%0Aprefix+skos%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E%0D%0Aselect+DISTINCT+%3Fname+%3Ftitle+++%0D%0AWHERE%0D%0A%        7B+++++%0D%0A%0D%0A%3FgreekEurovision+rdf%3Atype++skos%3AConcept.%0D%0A%3FgreekEurovision+rdfs%3Alabel++%3Flabel.%0D%0AFILTER+%28regex%28str%28%3Flabel        %29%2C+%22Greek%22%29%29.%0D%0AFILTER+%28regex%28str%28%3Flabel%29%2C+%22Eurovision%22%29%29.%0D%0AFILTER+%28regex%28str%28%3Flabel%29%2C+%22entrants%2        2%29%29.%0D%0A%0D%0A%3Fartist+rdf%3Atype+dbpedia-owl%3AArtist.%0D%0A%3Fartist+skos%3Asubject+%3FgreekEurovision.%0D%0A%3Fartist+dbpedia-owl%3AbirthPlac        e+%3Fcity.%0D%0A%3Fartist+dbpedia-owl%3AbirthPlace+%3Fcountry.%0D%0A%3Fartist+foaf%3Aname+%3Fname.%0D%0A%3Fcountry+rdf%3Atype+dbpedia-owl%3APlace.%0D%0        A%3Fcity+rdf%3Atype++dbpedia-owl%3AArea.%0D%0A%3Fcountry+skos%3Asubject++Category%3AEuropean_Union_member_states.%0D%0A%0D%0A%3Fsong+skos%3Asubject++Ca        tegory%3AGreek_Eurovision_songs.%0D%0A%3Fsong+dbpedia-owl%3AmusicalArtist+%3Fartist.%0D%0A%3Fsong+foaf%3Aname+%3Ftitle.%0D%0A%7D&format=text%2Fhtml&deb        ug=on&timeout= HTTP/1.1\" 400 612 \"http://dbpedia.org/sparql\" \"Mozilla/5.0 (Windows; U; Windows NT 6.0; el; rv:1.9.0.15) Gecko/2009101601 Firefox/3.0.15         (.NET CLR 3.5.30729)\" \"GR\" \"941a9f0e359288a0d9e0218f3c8ab9f7702c7a0b\"\n"
				+ "";

		Query query = new Query(q7);
		if (!query.isIngenuneQueryDecoding()) {
			query.jena(query.getQueryString());
			if (!query.isIngenuneQuerySyntax()) {
				regex.addRegexes(query.regex);
				regex.addFlag(query.getFlag());
				System.out.println(query.getQueryString());
			} else {
				System.out.println(query.getIngenuneQuerySyntax());
			}

		} else {
			System.out.println(query.getIngenuneQueryDecoding());
		}

	}

}
