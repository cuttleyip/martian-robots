/**
 * 
 */
package com.dcsl.martianrobots;

/**
 * @author Jason
 *
 */
public class TurnRightCommand extends Command {

	/**
	 * @param robot
	 */
	public TurnRightCommand(Robot robot) {
		super(robot);
	}

	@Override
	public boolean execute() {
		Orientation currentOrientation = this.robot.getOrientation();
		switch(currentOrientation) { 
		case E:
			this.robot.setOrientation(Orientation.S);
			break;
		case S:
			this.robot.setOrientation(Orientation.W);
			break;
		case W:
			this.robot.setOrientation(Orientation.N);
			break;
		case N:
			this.robot.setOrientation(Orientation.E);
			break;
		default:
			return false;
		}
		return true;
	}

}
