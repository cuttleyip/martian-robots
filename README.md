
# JAVA - Martian Robots

This project is to control the martian robots move according to the input instructions. A robot position consists of a grid coordinate (a pair of integers: x-coordinate followed
by y-coordinate) and an orientation (N, S, E, W for north, south, east, and west). A
robot instruction is a string of the letters "L", "R", and "F" which represent,
respectively, the instructions:
- Left: the robot turns left 90 degrees and remains on the current grid point.
- Right: the robot turns right 90 degrees and remains on the current grid point.
- Forward: the robot moves forward one grid point in the direction of the current orientation and maintains the same orientation.
The direction North corresponds to the direction from grid point (x, y) to grid point (x,
y+1).

Since the grid is rectangular and bounded (...yes Mars is a strange planet), a robot
that moves "off" an edge of the grid is lost forever. However, lost robots leave a robot
"scent" that prohibits future robots from dropping off the world at the same grid point.
The scent is left at the last grid position the robot occupied before disappearing over
the edge. An instruction to move "off" the world from a grid point from which a robot
has been previously lost is simply ignored by the current robot.


### Note: I implemented both Java Stand-alone application version and RESTful API version for this project. New Command can also be added by extending the Command abstract class.

## Authors

- [@cuttleyip](https://github.com/cuttleyip/martian-robots)

  
## API Reference

#### Run by REST API

```http
  POST /run
```

| Body | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `body` | `text` | **Required**. Your input instructions |

Takes input instructions and returns the output result.

#### Run by Command line

```http
  java -jar martian-robots.jar
```

Read input.txt file and returns the output file both in current directory.

  
## Deployment

To deploy this project as REST API, run

```bash
  docker build -t dcsl/martian-robots
  docker run -p 8080:8080 dcsl/martian-robots
```
To deploy this project as a Stand-Alone Java Application, run

```bash
  ./mvnw package && java -jar target/martian-robots.jar
```

  # Screenshots
[Please refer to the Screenshots folder](https://github.com/cuttleyip/martian-robots/tree/master/Screenshots)