package lab4;

public class PortAuthority {
	
	public static final boolean authorise(Ship s) {

		int rand = (int) (Math.random() * 9);
		
		if(s instanceof AircraftCarrier) {
			return rand < 9 ? true : false;
		} else if(s instanceof CruiseShip) {
			return rand < 4 ? true : false;
		}
		
		return false;
		
	}
}
