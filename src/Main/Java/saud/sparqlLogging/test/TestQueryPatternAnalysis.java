package Main.Java.saud.sparqlLogging.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QueryParseException;
import com.hp.hpl.jena.sparql.core.PathBlock;
import com.hp.hpl.jena.sparql.core.TriplePath;
import com.hp.hpl.jena.sparql.core.Var;
import com.hp.hpl.jena.sparql.expr.Expr;
import com.hp.hpl.jena.sparql.expr.ExprFunctionN;
import com.hp.hpl.jena.sparql.expr.ExprVar;
import com.hp.hpl.jena.sparql.expr.ExprVisitorBase;
import com.hp.hpl.jena.sparql.expr.ExprWalker;
import com.hp.hpl.jena.sparql.syntax.ElementFilter;
import com.hp.hpl.jena.sparql.syntax.ElementPathBlock;
import com.hp.hpl.jena.sparql.syntax.ElementVisitorBase;
import com.hp.hpl.jena.sparql.syntax.ElementWalker;

/**
 * User: Saud Aljaloud email: sza1g10@ecs.soton.ac.uk
 */

public class TestQueryPatternAnalysis {
	private String queryString;

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	List<Var> VariablLists = new ArrayList<>();

	public List<Var> getVariablLists() {
		return VariablLists;
	}

	public void addVariablLists(Var v) {
		this.VariablLists.add(v);
	}

	public static void main(String[] args) {

		String a = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ "PREFIX ont: <http://dbpedia.org/ontology/> "
				+ "PREFIX foaf: <http://xmlns.com/foaf/0.1/> "
				+ "PREFIX xsd:    <http://www.w3.org/2001/XMLSchema#> "
				+ "SELECT ?page ?place ?name ?date ?placelabel "
				+ "WHERE {?person ont:birthDate ?date;" + " foaf:page ?page;"
				+ " ont:birthPlace ?place;" + " foaf:name ?name ."
				+ " ?place rdfs:label ?placelabel ."
				+ "FILTER (lang(?placelabel) = \"en\") ."
				+ " FILTER( ( ( datatype(?date) = xsd:date ) ||"
				+ " ( datatype(?date) = xsd:dateTime ) )  "
				+ "&& ( regex(str(?date), \"1982-01-11\") )"
				+ "&& (regex(str(?place),\"Australia\") ||"
				+ " regex(str(?place),\"Melbourne\")) ) }";
		TestQueryPatternAnalysis test = new TestQueryPatternAnalysis();
		test.jena(a);
		test.getQueryString();
	}

	public void jena(String query) {

		try {
			com.hp.hpl.jena.query.Query q = QueryFactory.create(query);

			ElementWalker.walk(q.getQueryPattern(), new ElementVisitorBase() {
				@Override
				public void visit(ElementFilter el) {
					Expr triples = el.getExpr();
					ExprWalker.walk(new ExprVisitorBase() {
						@Override
						public void visit(ExprFunctionN func) {
							if (func.getFunction().getFunctionSymbol()
									.getSymbol() == "regex") {
								List<Expr> fun = func.getArgs();
								for (Expr expr : fun) {
									if (expr.isVariable()) {
										System.out.println(expr.getExprVar());
										addVariablLists(expr.getExprVar()
												.asVar());

									} else if (expr.isFunction()) {
										Var ex = expr.getFunction()
												.getVarsMentioned().iterator()
												.next();
										System.out.println(ex);
										addVariablLists(ex);
									}
									if (expr.isConstant()) {

										if (expr.getConstant().getNode()
												.getLiteralLexicalForm()
												.equals("i")
												|| expr.getConstant()
														.getNode()
														.getLiteralLexicalForm()
														.equals("si")) {
											System.out.println("flag");
										} else if (expr.getConstant().getNode()
												.getLiteralLexicalForm()
												.equals(null)) {

										} else {
											System.out.println(expr
													.getConstant().getNode()
													.getLiteralLexicalForm());
										}
									}
								}
							}

						}

					}, triples);

				}
			});

			System.out.println("analysing patterns");
			System.out.println(getVariablLists().size());
			ElementWalker.walk(q.getQueryPattern(), new ElementVisitorBase() {
				public void visit(ElementPathBlock el) {
					// when it's a block of triples, add in some triple

					Iterator<Var> itr = getVariablLists().iterator();
					while (itr.hasNext()) {
						Var var = itr.next();
						Iterator<TriplePath> triples = el.patternElts();
						while (triples.hasNext()) {
							TriplePath t = triples.next();

							if (t.getSubject().isVariable()) {
								if (t.getSubject().toString()
										.equals(var.toString())) {
									System.out
											.println("regex var was: subject");
								}
							}
							if (t.getPredicate().isVariable()) {
								if (t.getPredicate().toString()
										.equals(var.toString())) {
									System.out
											.println("regex var was: predicate");
								}
							}
							if (t.getObject().isVariable()) {
								if (t.getObject().toString()
										.equals(var.toString())) {
									System.out.println("regex var was: object");
									System.out.println(t.getPredicate()
											.getURI());
								}
							}
						}
					}

				}
			});

		} catch (QueryParseException e) {
			if (e.getMessage().contains("Unresolved prefixed name")) {
				Pattern p = Pattern
						.compile(".*Unresolved prefixed name: (.*?):.*");
				Matcher m = p.matcher(e.getMessage());
				String prefix = null;
				if (m.matches()) {
					prefix = m.group(1);
				}
				CopyOfPrefixes pre = new CopyOfPrefixes();
				String onePrefix = pre.prefixes.get(prefix.toLowerCase());
				String prefix2 = "PREFIX " + prefix.toLowerCase() + ": <"
						+ onePrefix + ">\n" + query;
				// System.out.println(prefix2);
				setQueryString(prefix2);
				jena(getQueryString());

			} else if (e.getMessage().toLowerCase()
					.contains("encountered \" \"count\"")) {
				String q = getQueryString().replaceAll(
						"(?i)count\\((.*?)\\)|as|(?i)COUNT", "");
				setQueryString(q);
				jena(getQueryString());
			} else {

				e.printStackTrace();
				System.exit(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

	}
}
