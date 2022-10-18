import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class DepartureFilter {
	private ArrayList<FlightDeparture> departureList = new ArrayList<FlightDeparture>();
	FlightDeparture departureData = new FlightDeparture();
	
	public ArrayList<FlightDeparture> filterByCode(String labelCode) {
		ArrayList<FlightDeparture> sortedList = new ArrayList<FlightDeparture>();
		for(FlightDeparture flight : this.departureList) {
			if(flight.getDepartureAirport().equals(labelCode)) {
				sortedList.add(flight);
			}
		}
		return sortedList;
	}
	
	public ArrayList<FlightDeparture> filterDeparturesByCurrentDay(ArrayList<FlightDeparture> filteredList) {
		ArrayList<FlightDeparture> sortedList = new ArrayList<FlightDeparture>();
		for(FlightDeparture flight : filteredList) {
			if(flight.getDateOfFlight().isEqual(LocalDate.now())) {
				sortedList.add(flight);
			}
		}
		return sortedList;
	}
	
	public ArrayList<FlightDeparture> filterDeparturesByAfterCurrentTime(ArrayList<FlightDeparture> filteredList) {
		ArrayList<FlightDeparture> sortedList = new ArrayList<FlightDeparture>();
		for(FlightDeparture flight : filteredList) {
			if(flight.getArrivalTime().compareTo(LocalTime.now()) == 1 
			|| flight.getArrivalTime().compareTo(LocalTime.now()) == 0) {
			sortedList.add(flight);
			}
		}
		return sortedList;
	}
	
	public ArrayList<FlightDeparture> filterByDelayedDeparture(ArrayList<FlightDeparture> filteredList) {
		ArrayList<FlightDeparture> sortedList = new ArrayList<FlightDeparture>();
		for(FlightDeparture flight : filteredList) {
			if(flight.getDelay() >= 30) {
				sortedList.add(flight);
			}
		}
		return sortedList;
	}
	
	
	
	public ArrayList<FlightDeparture> getDepartureList() {
		return departureList;
	}

	//very inefficient implementation
	public DepartureFilter() {
		try {
			departureList = (ArrayList<FlightDeparture>)departureData.getDepartureData().clone();
		} catch(IOException e) {
			System.out.println("IOException - DepartureFlight");
		}
	}
	
	
}
