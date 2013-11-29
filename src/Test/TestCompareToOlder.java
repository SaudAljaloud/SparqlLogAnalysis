package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestCompareToOlder {

	public static void main(String[] args) {

		TestCompareToOlder a1 = new TestCompareToOlder();
		a1.s1();

	}

	public void s1() {

		String dir1 = "/Users/user/Downloads/usewod2013_dataset/data/CLF-server-logs/dbpedia/3-3/JustRegex.txt.Decoded.txt.JustRegex.txt.CutFromRegex.txt.EachRegex.txt.CutSuffix.txt.JustQuatation.txt";
		String dir2 = "/Users/user/Downloads/usewod2013_dataset/data/CLF-server-logs/dbpedia/3-3/Original/Regexes.txt";
		File in1 = new File(dir1);
		File in2 = new File(dir2);
		String line1 = null;
		String line2 = null;
		
		ArrayList<String> log1 = new ArrayList<>();
		ArrayList<String> log2 = new ArrayList<>();

		try {
			BufferedReader reader1 = new BufferedReader(new FileReader(in1));
			BufferedReader reader2 = new BufferedReader(new FileReader(in2));
			while ((line1 = reader1.readLine()) != null) {
				log1.add(line1.replaceAll("\"|\'", ""));

			}
			while ((line2 = reader2.readLine()) != null) {
				log2.add(line2);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		log1.removeAll(log2);
		System.out.println(log1.size());
		for (int i = 0; i < log1.size(); i++) {
			System.out.println(log1.get(i));
		}

	}

}
