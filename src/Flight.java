import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Flight {
		private LocalDate dateOfFlight;
		private LocalTime departureTime;
		private LocalTime arrivalTime;
		private String duration;
		private double distanceTravelled;
		private double delay;
		private String departureAirport;
		private String departureCity;
	    private String arrivalAirport;
		private String arrivalCity;
		private String flightNo;
		private String airline;
		
		public Flight(LocalDate dateOfFlight, LocalTime departureTime, LocalTime arrivalTime, String duration, double distanceTravelled,
				double delay, String departureAirport, String departureCity, String arrivalAirport, String arrivalCity, String flightNo, String airline) {
			this.dateOfFlight = dateOfFlight;
			this.departureTime = departureTime;
			this.arrivalTime = arrivalTime;
			this.duration = duration;
			this.distanceTravelled = distanceTravelled;
			this.delay = delay;
			this.departureAirport = departureAirport;
			this.departureCity = departureCity;
			this.arrivalAirport = arrivalAirport;
			this.arrivalCity = arrivalCity;
			this.flightNo = flightNo;
			this.airline = airline;
		}
		
		public LocalDate getdateOfFlight() {
			return dateOfFlight;
		}
		
		public void setdateOfFlight(LocalDate dateOfFlight) {
			this.dateOfFlight = dateOfFlight;
		}
		
		public LocalTime getdepartureTime() {
			return departureTime;
		}
		
		public void setdepartureTime(LocalTime departureTime) {
			this.departureTime = departureTime;
		}
		
		public LocalTime getarrivalTime() {
			return arrivalTime;
		}
		public void setarrivalTime(LocalTime arrivalTime) {
			this.arrivalTime = arrivalTime;
		}
		
		public String getduration() {
			return duration;
		}
		
		public void setduration(String duration) {
			this.duration = duration;
		}
		
		public double getdistanceTravelled() {
			return distanceTravelled;
		}
		
		public void setdistanceTravelled(double distanceTravelled) {
			this.distanceTravelled = distanceTravelled;
		}
		
		public double getdelay() {
			return delay;
		}
		
		public void setdelay(double delay) {
			this.delay = delay;
		}
		
		public String getdepartureAirport() {
			return departureAirport;
		}
		
		public void setdepartureAirport(String departureAirport){
			this.departureAirport = departureAirport;
		}
		
		public String getdepartureCity() {
			return departureCity;
		}
		
		public void setdepartureCity(String departureCity) {
			this.departureCity = departureCity;
		}

		public String getarrivalAirport() {
			return arrivalAirport;
		}
		
		public void setarrivalAirport(String arrivalAirport) {
			this.arrivalAirport = arrivalAirport;
		}
		
		public String getarrivalCity() {
			return arrivalCity;
		}
		
		public void setarrivalCity(String arrivalCity) {
			this.arrivalCity = arrivalCity;
		}
	
		public String getflightNo() {
			return flightNo;
		}
		
		public void setFlightNo(String flightNo) {
			this.flightNo = flightNo;
		}
		
		public String getairline() {
			return airline;
		}
		
		public void setairline(String airline) {
			this.airline = airline;
		}
	
		
			
}



