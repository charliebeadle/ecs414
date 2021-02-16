package lab4;

public class PortMaster {
	public static void main(String[] args) {
		
		int seaConditions, newX, newY, loop;
		CollisionDetectionSystem cds;
		
		Ship[] shipArray = new Ship[10];
		
		cds = new CollisionDetectionSystem(shipArray);
		
		for(int s = 0; s < 10; s++) {
			if(Math.random() > 0.6) {
				shipArray[s] = new AircraftCarrier((int) (Math.random() * 1000), (int) (Math.random() * 1000), (int) (Math.random() * 50), cds);
			} else if(Math.random() > 0.3){
				shipArray[s] = new CruiseShip((int) (Math.random() * 1000), (int) (Math.random() * 1000), (int) (Math.random() * 10000), cds);
			} else {
				shipArray[s] = new Ironclad((int) (Math.random() * 1000), (int) (Math.random() * 1000), (int) (Math.random() * 20), cds);
			}
		}
		

		
		
//		seaConditions = Integer.parseInt(args[0]);
		seaConditions = Integer.parseInt("10");
		
//		loop = Integer.parseInt(args[1]);
		loop = Integer.parseInt("10");

		for(int n = 0; n < loop; n++) {
			for (Ship s : shipArray) {

				newX = s.getX() + 10 + (int) (Math.random() * 50);
				newY = s.getY() + 10 + (int) (Math.random() * 50);

				System.out.print(
						"Status: " + s.getStatus(seaConditions) + ", Position: (" + s.getX() + ", " + s.getY() + ")");

				
				s.move(newX, newY);

				System.out.println(" => (" + s.getX() + ", " + s.getY() + ")");

			}
		}
		
		for(Ship s: shipArray) {
			System.out.println(s.getShipLog());
		}
	}
}
