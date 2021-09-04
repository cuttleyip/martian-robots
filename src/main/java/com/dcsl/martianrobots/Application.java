/**
 * 
 */
package com.dcsl.martianrobots;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.dcsl.martianrobots.command.ForwardCommand;
import com.dcsl.martianrobots.command.TurnLeftCommand;
import com.dcsl.martianrobots.command.TurnRightCommand;
import com.dcsl.martianrobots.utility.InputValidator;

/**
 * @author Jason
 *
 */
public class Application {

	private static Grid mars;
	private static Set<Scent> scents;
	private Scanner input;
	private String output;

	public Application(Scanner input) {
		mars = null;
		scents = new HashSet<Scent>();
		this.input = input;
		this.output = null;
	}

	public void run() throws Exception {
		int x = InputValidator.validateCoordinate(input.nextInt());
		int y = InputValidator.validateCoordinate(input.nextInt());
		mars = new Grid(x, y);
		StringBuffer output = new StringBuffer();
		while (input.hasNext()) {
			x = InputValidator.validateCoordinate(input.nextInt());
			y = InputValidator.validateCoordinate(input.nextInt());
			String orientation = input.next();
			Robot robot = new Robot(new Grid(x, y), Orientation.valueOf(orientation));
			String commands = InputValidator.validateInstruction(input.next());
			char[] commandArray = commands.toCharArray();
			robotloop: for (char c : commandArray) {
				switch (c) {
				case 'L':
					new TurnLeftCommand(robot).execute();
					break;
				case 'R':
					new TurnRightCommand(robot).execute();
					break;
				case 'F':
					if (scents.contains(new Scent(robot.getLocation(), robot.getOrientation()))) {
						output.append(
								"There was a robot dropping off the world at the same grid point. The current robot should stop and stay in the current position to prevent dropping off the world.\n");
						break robotloop;
					}
					new ForwardCommand(robot).execute();
					break;
				}
				if (mars.isOutside(robot.getLocation())) {
					Scent scent = new Scent(robot.getLastLocation(), robot.getOrientation());
					if (!scents.contains(scent)) {
						scents.add(scent);
						break;
					}
				}
			}
			if (mars.isOutside(robot.getLocation())) {
				output.append(robot.printLastLocation() + " LOST\n");
			} else {
				output.append(robot.toString() + "\n");
			}
		}
		this.output = output.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File input = null;
		BufferedWriter writer = null;
		try {
			input = new File("input.txt");
			Application app = new Application(new Scanner(input));
			app.run();
			writer = new BufferedWriter(new FileWriter("output.txt"));
			writer.write(app.getOutput());
			writer.close();
		} catch (FileNotFoundException e) {
			System.err.println("An error occurred during reading input file.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("An error occurred during writing output file.");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.toString());
		}
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

}
