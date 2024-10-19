
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.FileWriter;

public class Main {
	
	public static void main(String[] args) {
		// declare ArrayList
		DoublyLinkedSortedList info = new DoublyLinkedSortedList();
		
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
			info.insert(row);
		}
		
		
		// run findHighestYear and set to a variable
		DoublyLinkedSortedList link = info.getFirst();
		HurricaneRowData row = link.getValue();
		
		// print out both the highest year and the max ace value
		System.out.println("The year with the highest ACE was " + row.getYear() + ", with a value of " + row.getACE());
		
		// print both into a txt file
		// code taken from https://www.w3schools.com/java/java_files_create.asp and edited
		
		try {
		  FileWriter output = new FileWriter("output.txt");
		  output.write("The year with the highest ACE was " + row.getYear() + ", with a value of " + row.getACE());
		  output.close();
		} catch (IOException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
		
		System.out.println(info.getFirst().toString());
		
	}
	
	
}
