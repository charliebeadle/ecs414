package lab4;

public class Ironclad extends Ship implements Fuel{
	
	private int gunsNumber, fuelAmount;
	private String fuelType;
	
	public Ironclad(int x, int y, int gunsNumber, CollisionDetectionSystem cds) {
		super(x, y, (int) (Math.random() * 3) + 10, cds);
		this.gunsNumber = gunsNumber;
		this.fuelAmount = 500;
		this.fuelType = "Coal";
		
	}
	
	public final void move(int newX, int newY) {
		if (this.getCanMove() && !isCollision(newX, newY)) {
			
			if (Math.abs(newX - this.getX()) <= 50) {
				this.setX(newX);
			}
			if (Math.abs(newY - this.getY()) <= 50) {
				this.setY(newY);
			}
			
			this.setFuelAmount(this.getFuelAmount() - 1);
			this.updateShipLog();
		}
	}
	
	public final int getGunsNumber() {
		return this.gunsNumber;
	}

	@Override
	public final String getFuelType() {
		return this.fuelType;
	}

	@Override
	public final int getFuelAmount() {
		return this.fuelAmount;
	}

	@Override
	public final void setFuelAmount(int val) {
		this.fuelAmount = val;
		
	}

	@Override
	public final String getStatus(int seaConditions) {

		if (seaConditions > getType() || this.getFuelAmount() <= 0) {
			this.setCanMove(false);
			return "This Ironclad will stay put: " + seaConditions + " " + getType();
		} else {
			this.setCanMove(true);
			return "This Ironclad will move: " + seaConditions + " " + getType();
		}
	}

}
