package Main.Java.saud.sparqlLogging.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;

import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QueryParseException;
import com.hp.hpl.jena.sparql.expr.Expr;
import com.hp.hpl.jena.sparql.expr.ExprFunctionN;
import com.hp.hpl.jena.sparql.expr.ExprVisitorBase;
import com.hp.hpl.jena.sparql.expr.ExprWalker;
import com.hp.hpl.jena.sparql.syntax.ElementFilter;
import com.hp.hpl.jena.sparql.syntax.ElementVisitorBase;
import com.hp.hpl.jena.sparql.syntax.ElementWalker;

/**
 * User: Saud Aljaloud email: sza1g10@ecs.soton.ac.uk
 */

public class QueryForExtractingSPARQLRegex {
	Logger log = org.slf4j.LoggerFactory
			.getLogger(QueryForExtractingSPARQLRegex.class);
	private String queryString;

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	private Boolean ingenuneQueryDecoding = false;

	public Boolean isIngenuneQueryDecoding() {
		return ingenuneQueryDecoding;
	}

	public void setIngenuneQueryDecoding(Boolean ingenuneQueryDecoding) {
		this.ingenuneQueryDecoding = ingenuneQueryDecoding;
	}

	private String IngenuneQueryDecoding = null;

	public String getIngenuneQueryDecoding() {
		return IngenuneQueryDecoding;
	}

	public void setIngenuneQueryDecoding(String ingenuneQueryDecoding) {
		this.IngenuneQueryDecoding = ingenuneQueryDecoding;
	}

	private Boolean IsingenuneQuerySyntax = false;

	public Boolean isIngenuneQuerySyntax() {
		return IsingenuneQuerySyntax;
	}

	public void setIsIngenuneQuerySyntax(Boolean ingenuneQuerySyntax) {
		this.IsingenuneQuerySyntax = ingenuneQuerySyntax;
	}

	private String IngenuneQuerySyntax = null;

	public String getIngenuneQuerySyntax() {
		return IngenuneQuerySyntax;
	}

	public void setIngenuneQuerySyntax(String ingenuneQuerySyntax) {
		this.IngenuneQuerySyntax = ingenuneQuerySyntax;
	}

	// Constrctor
	public QueryForExtractingSPARQLRegex(String queryStr) {
		setQueryString(queryStr);
		if (queryStr.contains(" ")) {
			extractQueryPartOutOfFullLog();
		}
		urlDecoding();

	}

	private void extractQueryPartOutOfFullLog() {
		String log = getQueryString();
		List<String> tokens = Arrays.asList(log.split("\\s+"));
		String prequery = "";
		for (int i = 0; i < tokens.size(); i++) {
			if (tokens.get(i).contains("query=")) {
				prequery = tokens.get(i).replaceFirst(".*query=", "");
			}
		}

		String prequery2 = prequery.replaceAll("\"|&.*", "");
		String query = prequery2.replaceAll("((?i)bif%3Acontains)", "%3C$0%3E");
		setQueryString(query);
	}

	private void urlDecoding() {

		try {
			setQueryString(URLDecoder.decode(getQueryString(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			log.error("Error with UnsupportedEncodingException");
			log.error(e.fillInStackTrace().toString());
		} catch (IllegalArgumentException e) {
			String wrongString = getQueryString().replaceAll("(%.?)?HTTP/1..",
					"");
			try {
				setQueryString(URLDecoder.decode(wrongString, "UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				log.error("Error with UnsupportedEncodingException");
				log.error(e1.fillInStackTrace().toString());
			} catch (IllegalArgumentException e1) {
				setIngenuneQueryDecoding(true);
				setIngenuneQueryDecoding(getQueryString());
			}

		}
	}

	public void jena(String query) {

		try {
			com.hp.hpl.jena.query.Query q = QueryFactory.create(query);

		} catch (QueryParseException e) {
			if (e.getMessage().contains("Unresolved prefixed name")) {
				Pattern p = Pattern
						.compile(".*Unresolved prefixed name: (.*?):.*");
				Matcher m = p.matcher(e.getMessage());
				String prefix = null;
				if (m.matches()) {
					prefix = m.group(1);
				}
				String prefix2 = "PREFIX " + prefix + ": <>\n" + query;
				log.trace(prefix2);
				setQueryString(prefix2);
				jena(getQueryString());

			} else if (e.getMessage().toLowerCase()
					.contains("encountered \" \"count\"")) {
				String q = getQueryString().replaceAll(
						"(?i)count\\((.*?)\\)|as|(?i)COUNT", "");
				setQueryString(q);
				jena(getQueryString());
			} else {
				setIsIngenuneQuerySyntax(true);
				setIngenuneQuerySyntax(getQueryString() + "\n" + e.toString());

			}

		} catch (Exception e) {
			setIsIngenuneQuerySyntax(true);
			setIngenuneQuerySyntax(getQueryString() + "\n" + e.toString());
		}

	}

}
