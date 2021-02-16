package lab4;

public class CruiseShip extends Ship implements RequestPortAuthority, Fuel{

	private int passengersNumber, fuelAmount;
	private String fuelType;

	public CruiseShip(int x, int y, int passengersNumber, CollisionDetectionSystem cds) {

		super(x, y, (int) (Math.random() * 6) + 9, cds);

		this.passengersNumber = passengersNumber;
		this.fuelType = "Diesel";
		this.fuelAmount = 100;

	}

	public final int getPassengersNumber() {

		return passengersNumber;

	}

	public final String getStatus(int seaConditions) {
		
		if (seaConditions + 3 > getType() || this.getFuelAmount() <= 0) {
			this.setCanMove(false);
			return "This cruise ship will stay put: " + seaConditions + " " + getType();
		} else {
			this.setCanMove(false);
			return "This cruise ship will move: " + seaConditions + " " + getType();
		}
	}

	public final void move(int newX, int newY) {
		if (this.getCanMove() && this.authorisation() && !isCollision(newX, newY)) {
			if (Math.abs(newX - this.getX()) <= 30) {
				this.setX(newX);
			}

			if (Math.abs(newY - this.getY()) <= 30) {
				this.setY(newY);
			}
			
			this.setFuelAmount(this.getFuelAmount() - 1);
			this.updateShipLog();
		}
	}

	@Override
	public boolean authorisation() {
		return PortAuthority.authorise(this);
	}

	@Override
	public String getFuelType() {
		return this.fuelType;
	}

	@Override
	public int getFuelAmount() {
		return this.fuelAmount;
	}

	@Override
	public void setFuelAmount(int val) {
		this.fuelAmount = val;
	}

}