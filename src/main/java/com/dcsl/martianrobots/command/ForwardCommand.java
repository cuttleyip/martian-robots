/**
 * 
 */
package com.dcsl.martianrobots.command;

import com.dcsl.martianrobots.Grid;
import com.dcsl.martianrobots.Orientation;
import com.dcsl.martianrobots.Robot;

/**
 * @author Jason
 *
 */
public class ForwardCommand extends Command {

	/**
	 * @param robot
	 */
	public ForwardCommand(Robot robot) {
		super(robot);
	}

	@Override
	public boolean execute() {
		this.robot.saveCurrentLocation();
		Orientation currentOrientation = this.robot.getOrientation();
		Grid location = this.robot.getLocation();
		switch(currentOrientation) {
		case E:
			location.setX(location.getX() + 1);
			break;
		case S:
			location.setY(location.getY() - 1);
			break;
		case W:
			location.setX(location.getX() - 1);
			break;
		case N:
			location.setY(location.getY() + 1);
			break;
		default:
			return false;
		}
		return true;
	}

}
