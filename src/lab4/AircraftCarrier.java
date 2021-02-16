package lab4;

public class AircraftCarrier extends Ship implements RequestPortAuthority, Fuel {

	private int airplanesNumber, fuelAmount;
	private String fuelType;

	public AircraftCarrier(int x, int y, int airplanesNumber, CollisionDetectionSystem cds) {

		super(x, y, (int) (Math.random() * 6) + 15, cds);

		this.airplanesNumber = airplanesNumber;
		this.fuelType = "Nuclear";
		this.fuelAmount = 1000;
	}

	public final int getAirplanesNumber() {
		return airplanesNumber;

	}

	public final String getStatus(int seaConditions) {

		if (seaConditions > getType() || this.getFuelAmount() <= 0) {
			this.setCanMove(false);
			return "This AircraftCarrier will stay put: " + seaConditions + " " + getType();
		} else {
			this.setCanMove(true);
			return "This AircraftCarrier will move: " + seaConditions + " " + getType();
		}
	}

	public final void move(int newX, int newY) {
		if (this.getCanMove() && this.authorisation() && !isCollision(newX, newY)) {
			
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
