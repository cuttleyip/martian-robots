/**
 * 
 */
package com.dcsl.martianrobots.utility;

/**
 * @author Jason
 *
 */
public class InputValidator {

	public static int validateCoordinate(int coordinate) throws Exception {
		if (coordinate > SysParam.MAX_COORDINATE) {
			throw new Exception(ErrorMsg.OVER_MAX_COORDINATE);
		}
		return coordinate;
	}
	
	public static String validateInstruction(String instruction) throws Exception {
		if (instruction.length() >= SysParam.INSTRUCTION_LENGTH_LIMIT) {
			throw new Exception(ErrorMsg.OVER_INSTRUCTION_LENGTH);
		}
		return instruction;
	}
}
