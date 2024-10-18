
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.FileWriter;

public class Main {
	
	public static void main(String[] args) {
		// declare ArrayList
		ArrayList<HurricaneRowData> info = new ArrayList<HurricaneRowData>();
		
		// declare scanner
		Path p = Paths.get("ace.csv");
		Scanner input = null;
		try {
			input = new Scanner(p);
		}
		catch (IOException e) {
			System.out.println("File not found");
		}
		
		// read in the stuff from ace.csv and fill info with HurricaneRowData instances
		input.nextLine(); // skip first line
		while (input.hasNextLine()) {
			String[] temp = input.nextLine().split(","); // use .parseInt(str)
			HurricaneRowData row = new HurricaneRowData(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]),Integer.parseInt(temp[2]),Integer.parseInt(temp[3]),Integer.parseInt(temp[4]));
			info.add(row);
		}
		
		
		// run findHighestYear and set to a variable
		int year = findHighestYear(info);
		int ace = info.get(year-1950).getACE();
		
		// print out both the highest year and the max ace value
		System.out.println("The year with the highest ACE was " + year + ", with a value of " + ace);
		
		// print both into a txt file
		// code taken from https://www.w3schools.com/java/java_files_create.asp and edited
		
		try {
		  FileWriter output = new FileWriter("output.txt");
		  output.write("The year with the highest ACE was " + year + ", with a value of " + ace);
		  output.close();
		} catch (IOException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
		
		
	}
	
	private static int findHighestYear(ArrayList<HurricaneRowData> info) {
		// loop through info and find the highest ace value
		int index = 0;
		for (int i = 0; i < info.size(); i++) {
			if (info.get(i).getACE() > info.get(index).getACE()) {
				index = i;
			}
		}
		
		// return the corresponding year
		int year = info.get(index).getYear();
		return year;
	}
	
	
}
