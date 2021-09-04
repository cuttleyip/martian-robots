/**
 * 
 */
package com.dcsl.martianrobots;

/**
 * @author Jason
 *
 */
public class TurnLeftCommand extends Command {

	/**
	 * @param robot
	 */
	public TurnLeftCommand(Robot robot) {
		super(robot);
	}

	@Override
	public boolean execute() {
		Orientation currentOrientation = this.robot.getOrientation();
		switch(currentOrientation) { 
		case E:
			this.robot.setOrientation(Orientation.N);
			break;
		case S:
			this.robot.setOrientation(Orientation.E);
			break;
		case W:
			this.robot.setOrientation(Orientation.S);
			break;
		case N:
			this.robot.setOrientation(Orientation.W);
			break;
		default:
			return false;
		}
		return true;
	}

}
