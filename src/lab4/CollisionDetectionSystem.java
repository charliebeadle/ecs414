package lab4;

public class CollisionDetectionSystem {
	
	Ship[] shipArray;
	
	public CollisionDetectionSystem(Ship[] shipArray) {
		
		this.shipArray = shipArray;
		
	}
	
	public final boolean isCollision(int x, int y) {
		
		for(Ship s: shipArray) {
			if(s.getX() == x && s.getY() == y) {
				System.out.println("POTENTIAL COLLISION DETECTED!");
				return true;
			}
		}
		return false;
	}
	
}
