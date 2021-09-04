/**
 * 
 */
package com.dcsl.martianrobots;

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
