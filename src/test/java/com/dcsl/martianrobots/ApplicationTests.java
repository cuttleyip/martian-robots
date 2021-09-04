package com.dcsl.martianrobots;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class ApplicationTests {

	@Test
	void testSaveCurrentLocation() {
		Robot robot = new Robot(new Grid(3,3), Orientation.N);
		robot.saveCurrentLocation();
		assertEquals(robot.getLastLocation(), robot.getLocation());
	}

	@Test
	void testPrintLastLocation() {
		Robot robot = new Robot(new Grid(3,3), Orientation.N);
		robot.saveCurrentLocation();
		assertEquals(robot.printLastLocation(), "3 3 N");
	}

	@Test
	void testRobotToString() {
		assertEquals(new Robot(new Grid(3,3), Orientation.N).toString(), "3 3 N");
	}
	
	@Test
	void testTurnLeft() {
		Robot robot = new Robot(new Grid(1,1), Orientation.E);
		Command c = new TurnLeftCommand(robot);
		c.execute();
		assertEquals(robot.toString(), "1 1 N");
	}

	@Test
	void testTurnRight() {
		Robot robot = new Robot(new Grid(1,1), Orientation.E);
		Command c = new TurnRightCommand(robot);
		c.execute();
		assertEquals(robot.toString(), "1 1 S");
	}
	
	@Test
	void testForward() {
		Robot robot = new Robot(new Grid(1,1), Orientation.E);
		Command c = new ForwardCommand(robot);
		c.execute();
		assertEquals(robot.toString(), "2 1 E");
	}

	@Test
	void testApp() {
		try {
			File input = new File("input.txt");
			Application app = new Application(new Scanner(input));
			app.run();
			assertEquals("1 1 E\n"
					+ "3 3 N LOST\n"
					+ "4 2 N\n", app.getOutput());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("An error occurred during reading input file.");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}
	
}
