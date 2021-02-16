package lab4;

public abstract class Ship implements CollisionDetectionInterface{

	private int x, y, shipType;
	
	private boolean canMove;
	
	private String shipLog;
	
	private static CollisionDetectionSystem cds;

	public Ship(int x, int y, int shipType, CollisionDetectionSystem cds) {

		this.x = x;

		this.y = y;

		this.shipType = shipType;
		
		this.shipLog = "";
		this.updateShipLog();
		
		this.cds = cds;

	}


	public final int getX() {

		return x;

	}

	public final int getY() {

		return y;

	}

	public final int getType() {

		return shipType;

	}
	
	public final String getShipLog() {
		return this.shipLog;
	}
	
	public final void updateShipLog() {
		this.shipLog += this.toString() + "\n";
	}
	
	public final boolean getCanMove() {
		return canMove;
	}

	public final void setX(int newX) {

		x = newX;

	}

	public final void setY(int newY) {

		y = newY;

	}
	
	public final void setCanMove(boolean canMove) {
		this.canMove = canMove;
	}

	public abstract String getStatus(int seaConditions);
	
	public void move(int newX, int newY) {
		this.setX(newX);
		this.setY(newY);
	}
	
	public final boolean isCollision(int newX, int newY) {
		return cds.isCollision(newX, newY);
		
	}


	@Override
	public String toString() {
		return "Ship [x=" + x + ", y=" + y + ", shipType=" + shipType + ", canMove=" + canMove + "]";
	};
	
	
	
}
