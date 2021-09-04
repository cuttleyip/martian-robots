/**
 * 
 */
package com.dcsl.martianrobots;

import java.util.Objects;

/**
 * @author Jason
 *
 */
public class Scent {
	private Grid location;
	private Orientation orientation;
	
	public Scent(Grid location, Orientation orientation) {
		this.location = location;
		this.orientation = orientation;
	}

	public Grid getLocation() {
		return location;
	}

	public void setLocation(Grid location) {
		this.location = location;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(location, orientation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scent other = (Scent) obj;
		return Objects.equals(location, other.location) && orientation == other.orientation;
	}
}
