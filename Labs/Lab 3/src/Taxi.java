//

public class Taxi {
	double rate;
	int capacity;
	int passengers;
    /*
     * Put global fields here.
     */

	public Taxi() { // NO-ARGUMENT CONSTRUCTOR
        /*
         * Initialize global fields.
         * These values will never be changed because the constructor has no parameters.
         */
		this.rate = 0.0;
		this.capacity = 0;
		this.passengers = 0;
	}
	
	public Taxi(double rate, int capacity) {
        /*
         * Initialize global fields.
         * These values can be changed via constructor parameters.
         */
		this.rate = rate;
		this.capacity = capacity;
	}
	
	public double calculateFare(int passengersLeaving, int durationOfRide) {
        /*
         * Your method implementation goes here.
         */
		return (this.rate * durationOfRide) / passengersLeaving;
	}
	
	public boolean pickUp(int passengersLoading) {
        /*
         * Your method implementation goes here.
         */
		if(this.capacity>=passengersLoading) {
			return true;
		}else {
			return false;
		}
	}

}