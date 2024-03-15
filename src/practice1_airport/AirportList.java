package practice1_airport;

import java.util.ArrayList;

public class AirportList {
    protected ArrayList<Flight> flights;
    protected String action;

    public AirportList() {
        flights = new ArrayList<>();
        action = "N/A";
    }

    public boolean isEmpty() {
        return flights.isEmpty();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void doAction() {
        if(!isEmpty()) {
            Flight flight = flights.remove(0);
            System.out.println("CONTROL " + flight.getFlightNo() + " " + action);
        }
    }
}
