package com.dcsl.martianrobots;

import java.util.Scanner;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MartianRobotsRestController {

	@RequestMapping(
		    value = "/run", 
		    method = RequestMethod.POST,
		    consumes = MediaType.TEXT_PLAIN_VALUE)
	String run(@RequestBody String payload) {
		String output = null;
		try {
			Application app = new Application(new Scanner(payload));
			app.run();
			output = app.getOutput();
		} catch (Exception e) {
			output = e.toString();
			e.printStackTrace();
		}
		return output;
	}
}
