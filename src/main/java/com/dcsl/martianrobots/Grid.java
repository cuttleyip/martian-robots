/**
 * 
 */
package com.dcsl.martianrobots;

import java.util.Objects;

/**
 * @author Jason
 *
 */
public class Grid {
	private int x;
	private int y;
	
	Grid(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isOutside(Grid location) {
		return (this.x < location.getX() || this.y < location.getY());
	}
	
	public void copy(Grid location) {
		this.x = location.getX();
		this.y = location.getY();
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grid other = (Grid) obj;
		return x == other.x && y == other.y;
	}
}
