
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;

public class Airport {

    public static ArrayList<Flight> importData() throws IOException {
    	ArrayList<Flight> allFlights = new ArrayList<Flight>();
		
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("H:mm");
			
		String[] data = new String[12];
		
		File file = new File("res/data/Flights.csv");
		FileReader fileHandle = new FileReader(file);
		BufferedReader br = new BufferedReader(fileHandle);
		String line = null;
		while((line = br.readLine()) != null) {
			//reads lines
			data = line.split(",");
			allFlights.add(new Flight(
				LocalDate.parse(data[0], dateformatter),
				LocalTime.parse(data[1], timeformatter),
				LocalTime.parse(data[2], timeformatter),
				data[3],
				Double.parseDouble(data[4]),
				Double.parseDouble(data[5]),
				data[6], data[7], data[8], data[9], data[10], data[11]
			));
		}
		br.close();
		fileHandle.close();
		return allFlights;
    }
}