import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class FlightDeparture {
	private LocalDate dateOfFlight;
	private LocalTime departureTime;
	private LocalTime arrivalTime;
	private double delay;
	private String departureAirport;
	private String departureCity;
	private String arrivalAirport;
	private String arrivalCity;
	private String flightNumber;
	private String airline;
	private LocalTime newArrivalTime;
	
	public ArrayList<FlightDeparture> cloneDepartureData(ArrayList<Flight> flightList) {
		
		
		//take Flight data, calc newATime, add into new FlightDeparture instance
		//add instance to arraylist
		//return arraylist
		
		ArrayList<FlightDeparture> departureData = new ArrayList<FlightDeparture>();
		
		for(Flight flightObj : flightList) {
			departureData.add(new FlightDeparture(
				dateOfFlight = flightObj.getdateOfFlight(), 
				departureTime = flightObj.getdepartureTime(), 
				arrivalTime = flightObj.getarrivalTime(), 
				delay = flightObj.getdelay(), 
				departureAirport = flightObj.getdepartureAirport(), 
				departureCity = flightObj.getdepartureCity(), 
				arrivalAirport = flightObj.getarrivalAirport(), 
				arrivalCity = flightObj.getarrivalCity(), 
				flightNumber = flightObj.getflightNo(), 
				airline = flightObj.getairline(), 
				newArrivalTime = calculateNewArrivalTime(flightObj.getarrivalTime(), flightObj.getdateOfFlight(), flightObj.getdelay())
			));
		}
		return departureData;
	}
	
	private LocalTime calculateNewArrivalTime(LocalTime arrivalTime, LocalDate dateOfFlight, double delay) {		
		LocalTime newArrivalTime = LocalTime.of(0, 0);
		if(delay != 0) {
			// FINDS HOW MUCH EXTRA TIME IS ADDED
			// delay / 60
			// quotient = hour, add to old hours
			// store remainder as int, add to old minutes
			
			int hoursRemaining = (int) delay / 60;
			int minutesRemaining = (int) delay % 60;
			
			
			// ADD EXTRA TIME TO ARRIVAL TIME
			// did this because i needed to copy arrivalTime instead of getting a reference to it
			// probably dozens of better ways to do this
			newArrivalTime = arrivalTime.plusHours(0);
			newArrivalTime = newArrivalTime.plusHours(hoursRemaining);
			newArrivalTime = newArrivalTime.plusMinutes(minutesRemaining);
			
		}
		else {
			return LocalTime.of(0, 0);
		}
		
		return newArrivalTime;
	}
	
	public ArrayList<FlightDeparture> getDepartureData() throws IOException {
		return new ArrayList<FlightDeparture>(cloneDepartureData(Airport.importData()));
	}
	
	public FlightDeparture() {
		
	}
	
	// probably not a good idea
	public FlightDeparture(LocalDate dateOfFlight, LocalTime departureTime, LocalTime arrivalTime, double delay, String departureAirport,
			String departureCity, String arrivalAirport, String arrivalCity, String flightNo, String airline, LocalTime newArrivalTime) {
		this.dateOfFlight = dateOfFlight;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.delay = delay;
		this.departureAirport = departureAirport;
		this.departureCity = departureCity;
		this.arrivalAirport = arrivalAirport;
		this.arrivalCity = arrivalCity;
		this.flightNumber = flightNo;
		this.airline = airline;
		this.newArrivalTime = newArrivalTime;
	}

	// GETTERS	
	
	public LocalDate getDateOfFlight() {
		return dateOfFlight;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public double getDelay() {
		return delay;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getAirline() {
		return airline;
	}

	public LocalTime getNewArrivalTime() {
		return newArrivalTime;
	}

}


