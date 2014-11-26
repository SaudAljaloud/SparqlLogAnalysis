package Main.Java.saud.sparqlLogging.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Saud Aljaloud email: sza1g10@ecs.soton.ac.uk
 */

public class TestStats2 {

	public static void main(String[] args) {
		String a = "*ud";
		Pattern p = Pattern.compile("([^\\.]|^)\\*");
		Matcher m = p.matcher(a);
		if (m.find()) {
			System.out.println("yes");
		}

	}
}
