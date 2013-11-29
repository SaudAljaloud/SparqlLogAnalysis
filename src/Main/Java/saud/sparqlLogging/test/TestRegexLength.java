package main.Java.saud.sparqlLogging.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Auther: saudaljaloud Email: sza1g10@ecs.soton.ac.uk
 */
public class TestRegexLength {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String a = "http://dbpedia.org/resource/Template:(infobox_)?radio_station";
		 String a = "saud.*aljaloud";

		int counter = 0;
		int max = 0;
		Character ch1 = '$';
		Character ch2 = '^';
		Character ch3 = '.';
		Character ch4 = '*';
		Character ch5 = '+';
		Character ch6 = '^';
		Character ch7 = '/';
		Character ch8 = '?';
		Character ch9 = ')';
		Character ch10 = '(';
		for (int i = 0; i < a.length(); i++) {
			Character org = a.charAt(i);
			if (!org.equals(ch1) && !org.equals(ch2) && !org.equals(ch3)
					&& !org.equals(ch4) && !org.equals(ch5) && !org.equals(ch6)
					&& !org.equals(ch7) && !org.equals(ch8) && !org.equals(ch9)
					&& !org.equals(ch10)) {
				counter++;
			} else {
				if (counter > max)
					max = counter;
				counter = 0;
			}

		}
		if (counter > max)
			max = counter;
		System.out.println("max is:" + max);

	}

}
