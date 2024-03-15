package practice1_airport;

import java.util.Random;

public class Airport {
    private LandingList landing;
    private EmergencyLandingList emergency;
    private TakeOffList takeOff;

    public Airport() {
        landing = new LandingList();
        emergency = new EmergencyLandingList();
        takeOff = new TakeOffList();
    }

    public void simulate(int repeat) {
        Random rnd = new Random();
        for(int i = 0; i < repeat; i++) {
            int action = rnd.nextInt(3);
            Flight flight;
            switch (action) {
                case 0:
                    if(!emergency.isEmpty()) {
                        emergency.doAction();
                    }
                    else if(!landing.isEmpty()) {
                        landing.doAction();
                    }
                    else if(!takeOff.isEmpty()) {
                        takeOff.doAction();
                    }
                    else {
                        System.out.println("CONTROL: No flights pending");
                    }
                    break;
                case 1:
                    int emergencyProbability = rnd.nextInt(100);
                    flight = new Flight(rnd.nextInt(10000));
                    if(emergencyProbability < 90) {
                        landing.addFlight(flight);
                        System.out.println("Flight " + flight.getFlightNo() + " requests landing");
                    }
                    else {
                        emergency.addFlight(flight);
                        System.out.println("Flight " + flight.getFlightNo() + " requests emergency landing");
                    }
                    break;
                case 2:
                    flight = new Flight(rnd.nextInt(10000));
                    takeOff.addFlight(flight);
                    System.out.println("Flight " + flight.getFlightNo() + " requests take off");
                    break;
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
