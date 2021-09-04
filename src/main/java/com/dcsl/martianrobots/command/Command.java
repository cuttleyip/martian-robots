/**
 * 
 */
package com.dcsl.martianrobots.command;

import com.dcsl.martianrobots.Robot;

/**
 * @author Jason
 *
 */
public abstract class Command {
	public Robot robot;
	
	Command(Robot robot) {
		this.robot = robot;
	}
	
	public abstract boolean execute();
}
