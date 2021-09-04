/**
 * 
 */
package com.dcsl.martianrobots;

/**
 * @author Jason
 *
 */
public class Robot {
	private Orientation orientation;
	private Grid location;
	private Grid lastLocation;
	
	Robot(Grid location, Orientation orientation) {
		this.location = location;
		this.orientation = orientation;
		this.lastLocation = new Grid(location.getX(), location.getY());
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public Grid getLocation() {
		return location;
	}

	public void setLocation(Grid location) {
		this.location = location;
	}

	public Grid getLastLocation() {
		return lastLocation;
	}

	public void setLastLocation(Grid lastLocation) {
		this.lastLocation = lastLocation;
	}
	
	public void saveCurrentLocation() {
		this.getLastLocation().copy(this.location);;
	}
	
	public String printLastLocation() {
		return lastLocation.getX() + " " + lastLocation.getY() + " " + orientation.toString();
	}

	@Override
	public String toString() {
		return location.getX() + " " + location.getY() + " " + orientation.toString();
	}

}
