package Main.Java.saud.sparqlLogging.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/**
Auther: saudaljaloud
Email: sza1g10@ecs.soton.ac.uk
 */
public class TestStringBuilder {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		BufferedReader reader = new BufferedReader(new FileReader("/home/saudubuntu/usewod2013_dataset/data/SPARQL-endpoint-logs/openbiomed/2011-02-14.log"));
		String line = null;
		StringBuilder queryBuilder = new StringBuilder();
		while ((line = reader.readLine()) != null) {

			if (!line.equals("------------")){
				queryBuilder.append(line);
			}
			else{
				
				System.out.println(queryBuilder);
				queryBuilder = new StringBuilder();
			}
			
		}
		
		

	}

}
